import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.apache.logging.log4j.Level;
import org.apache.logging.log4j.core.appender.GrpcLogAppender;
import org.apache.logging.log4j.core.config.Configuration;
import org.apache.logging.log4j.core.config.Configurator;
import org.apache.logging.log4j.core.config.builder.api.ConfigurationBuilder;
import org.apache.logging.log4j.core.config.builder.api.ConfigurationBuilderFactory;
import org.apache.logging.log4j.core.config.builder.impl.BuiltConfiguration;

public class LogGenerator {
  private static Logger logger;

  public static void buildConfig() {
    ConfigurationBuilder<BuiltConfiguration> builder
        = ConfigurationBuilderFactory.newConfigurationBuilder();
    builder.add(builder.newAppender("stdout", "Console"));
    builder.add(
        builder.newAppender("remote", "GRPC")
        .addAttribute("url", "localhost:50051")
        .add(builder.newLayout("PatternLayout")
             .addAttribute("pattern", "%m%n")));
    builder.add(
        builder.newRootLogger(Level.INFO)
        // .add(builder.newAppenderRef("stdout"))
        .add(builder.newAppenderRef("remote")));
    try {
      builder.writeXmlConfiguration(System.out);
    } catch (java.io.IOException e) {
    }
    // Ask log4j to use the config.
    Configurator.initialize(builder.build());
    logger = LogManager.getLogger();
  }

  static {
    buildConfig();
  }

  public static void main( String[] args ) {
    // BasicConfigurator.configure();
    for (int i = 0; i < 100; ++i) {
      logger.info("Hello world");
    }
  }
}
