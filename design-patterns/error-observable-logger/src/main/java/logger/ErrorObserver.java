package logger;

public interface ErrorObserver {
    void notify(String errorMessage);
}
