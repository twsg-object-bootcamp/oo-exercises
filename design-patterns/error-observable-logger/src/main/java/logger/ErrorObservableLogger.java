package logger;

import java.util.ArrayList;
import java.util.List;

public class ErrorObservableLogger implements Logger, ErrorObservable  {
    private final Logger delegatedLogger;
    private final List<ErrorObserver> errorObservers = new ArrayList<>();

    public ErrorObservableLogger(Logger delegatedLogger) {
        this.delegatedLogger = delegatedLogger;
    }

    @Override
    public void info(String message) {
        delegatedLogger.info(message);
    }

    @Override
    public void error(String message) {
        delegatedLogger.error(message);
        errorObservers.forEach(o -> o.notify(message));
    }

    @Override
    public void attach(ErrorObserver observer) {

    }

    @Override
    public void detach(ErrorObserver observer) {

    }
}
