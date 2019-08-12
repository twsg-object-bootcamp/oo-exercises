import logger.ErrorObservableLogger;
import logger.ConsoleLogger;
import logger.Logger;

public class App {
    private Logger logger = new ErrorObservableLogger(new ConsoleLogger(App.class));
    private final SlackClient slackClient;
    private final EmailClient emailClient;

    public App(SlackClient slackClient, EmailClient emailClient) {
        this.slackClient = slackClient;
        this.emailClient = emailClient;
    }

    public void runWithError() {
        logger.error("Something wrong happened.");
    }

    public void runSuccessfully() {
        logger.info("Everything is working.");
    }
}
