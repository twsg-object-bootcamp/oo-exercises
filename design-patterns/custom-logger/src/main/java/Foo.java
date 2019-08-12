import logger.ConsoleLogger;
import logger.Logger;

public class Foo {
    private Logger logger = new ConsoleLogger(Foo.class);

    public void run() {
        logger.info("Application started");
    }
}
