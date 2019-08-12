package logger;

public class ConsoleLogger implements Logger {
    private final Class loggingClass;

    public ConsoleLogger(Class loggingClass) {
        this.loggingClass = loggingClass;
    }

    @Override
    public void info(String message) {
        System.out.println(String.format("[INFO] %s: %s", loggingClass.getName(), message));
    }
}
