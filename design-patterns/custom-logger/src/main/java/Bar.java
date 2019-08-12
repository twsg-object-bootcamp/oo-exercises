import logger.ConsoleLogger;
import logger.Logger;

public class Bar {
    private Logger logger = new ConsoleLogger(Bar.class);

    public void run() {
        logger.info("Application started");
    }
}
