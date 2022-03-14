package org.apache.logging.log4j.core.appender;

import java.io.Serializable;
import java.net.URL;
import java.util.Objects;
import java.util.concurrent.TimeUnit;

import org.apache.logging.log4j.core.Appender;
import org.apache.logging.log4j.core.Filter;
import org.apache.logging.log4j.core.Layout;
import org.apache.logging.log4j.core.LogEvent;
import org.apache.logging.log4j.core.config.Node;
import org.apache.logging.log4j.core.config.Property;
import org.apache.logging.log4j.core.config.plugins.Plugin;
import org.apache.logging.log4j.core.config.plugins.PluginBuilderAttribute;
import org.apache.logging.log4j.core.config.plugins.PluginBuilderFactory;
import org.apache.logging.log4j.core.config.plugins.PluginElement;
import org.apache.logging.log4j.core.config.plugins.validation.constraints.Required;
import org.apache.logging.log4j.core.net.ssl.SslConfiguration;
import com.example.remote_log.RemoteLogJavaClient;

/**
 * Sends log events over HTTP.
 */
@Plugin(name = "Grpc", category = Node.CATEGORY, elementType = Appender.ELEMENT_TYPE, printObject = true)
public final class GrpcLogAppender extends AbstractAppender {

  /**
   * Builds GrpcLogAppender instances.
   * @param <B> The type to build
   */
  public static class Builder<B extends Builder<B>> extends AbstractAppender.Builder<B>
      implements org.apache.logging.log4j.core.util.Builder<GrpcLogAppender> {

    @PluginBuilderAttribute
    @Required(message = "No URL provided for GrpcLogAppender")
    private String url;

    @Override
    public GrpcLogAppender build() {
      final RemoteLogJavaClient client = new RemoteLogJavaClient(url);
      return new GrpcLogAppender(getName(), getLayout(), getFilter(), isIgnoreExceptions(), client,
                                 getPropertyArray());
    }

    public String getUrl() {
      return url;
    }

    public B setUrl(final String url) {
      this.url = url;
      return asBuilder();
    }
  }

  /**
   * @return a builder for a GrpcLogAppender.
   */
  @PluginBuilderFactory
  public static <B extends Builder<B>> B newBuilder() {
    return new Builder<B>().asBuilder();
  }

  private final RemoteLogJavaClient logClient;

  private GrpcLogAppender(final String name, final Layout<? extends Serializable> layout, final Filter filter,
                          final boolean ignoreExceptions, final RemoteLogJavaClient logClient, final Property[] properties) {
    super(name, filter, layout, ignoreExceptions, properties);
    Objects.requireNonNull(layout, "layout");
    this.logClient = Objects.requireNonNull(logClient, "logClient");
  }

  @Override
  public void start() {
    super.start();
  }

  @Override
  public void append(final LogEvent event) {
    try {
      // Skip getLayout() 
      logClient.log(event);
    } catch (final Exception e) {
      error("Unable to log remotely in appender [" + getName() + "]", event, e);
    }
  }

  @Override
  public boolean stop(final long timeout, final TimeUnit timeUnit) {
    setStopping();
    boolean stopped = super.stop(timeout, timeUnit, false);
    try {
      logClient.shutdownChannel();
    } catch (InterruptedException e) {
      error("interrupted", e);
    }
    setStopped();
    return stopped;
  }

  @Override
  public String toString() {
    return "GrpcLogAppender{" +
        "name=" + getName() +
        ", state=" + getState() +
        '}';
  }
}
