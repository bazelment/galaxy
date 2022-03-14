import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class LogGenerator {
  private final static Logger logger = LogManager.getRootLogger();
  public static void main( String[] args ) {
    // BasicConfigurator.configure();
    logger.info("Hello world");
  }
}
