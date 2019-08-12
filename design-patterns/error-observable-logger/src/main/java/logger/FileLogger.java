package logger;

import com.google.common.base.Charsets;
import com.google.common.io.FileWriteMode;
import com.google.common.io.Files;

import java.io.File;
import java.io.IOException;

public class FileLogger implements Logger {
    private final Class loggingClass;
    private final File logFile;

    public FileLogger(Class loggingClass, String filePath) {
        this.loggingClass = loggingClass;
        this.logFile = new File(filePath);
    }

    @Override
    public void info(String message) {
        writeLogToFile(message, "INFO");
    }

    @Override
    public void error(String message) {
        writeLogToFile(message,"ERROR");
    }

    private void writeLogToFile(String message, String logLevel) {
        try {
            Files.asCharSink(logFile, Charsets.UTF_8, FileWriteMode.APPEND)
                    .write(String.format("[" + logLevel + "] %s: %s\n", loggingClass.getName(), message));
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
