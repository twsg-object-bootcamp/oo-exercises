package logger;

public interface ErrorObservable {
    void attach(ErrorObserver observer);
    void detach(ErrorObserver observer);
}
