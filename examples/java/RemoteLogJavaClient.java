package com.example.remote_log;

import io.grpc.Channel;
import io.grpc.ManagedChannel;
import io.grpc.ManagedChannelBuilder;
import io.grpc.StatusRuntimeException;
import java.util.concurrent.TimeUnit;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.apache.logging.log4j.core.LogEvent;

public class RemoteLogJavaClient {
  private static final Logger logger = Logger.getLogger(RemoteLogJavaClient.class.getName());
  private final ManagedChannel channel;
  private final RemoteLogGrpc.RemoteLogBlockingStub blockingStub;

  public RemoteLogJavaClient(String serverAddr) {
    channel = ManagedChannelBuilder.forTarget(serverAddr)
              .usePlaintext()
              .build();
    blockingStub = RemoteLogGrpc.newBlockingStub(channel);
  }

  public void shutdownChannel() throws InterruptedException {
    // ManagedChannels use resources like threads and TCP connections. To prevent leaking these
    // resources the channel should be shut down when it will no longer be used. If it may be used
    // again leave it running.
    channel.shutdownNow().awaitTermination(5, TimeUnit.SECONDS);
  }
  
  public void log(final LogEvent event) {
    // TODO: only handle message at the moment
    // See https://www.javatips.net/api/lilith-master/log4j/converter-log4j2/src/main/java/de/huxhorn/lilith/log4j2/producer/Log4j2LoggingConverter.java for more comprehensive example
    final String content = event.getMessage().getFormattedMessage();
    LogMessage request = LogMessage.newBuilder().setContent(content).build();
    LogResponse response;
    try {
      response = blockingStub.log(request);
    } catch (StatusRuntimeException e) {
      logger.log(Level.WARNING, "RPC failed: {0}", e.getStatus());
      return;
    }
    logger.info("Ack: " + response.getConfirmation());
  }
}
