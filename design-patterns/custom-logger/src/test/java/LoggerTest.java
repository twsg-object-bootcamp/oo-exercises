import com.google.common.base.Charsets;
import com.google.common.io.Files;
import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.TemporaryFolder;

import java.io.File;
import java.io.IOException;

import static org.hamcrest.Matchers.containsString;
import static org.hamcrest.Matchers.emptyString;
import static org.junit.Assert.assertThat;

public class LoggerTest {
    @Rule
    public TemporaryFolder tmp = new TemporaryFolder();
    private File logFile;

    @Before
    public void setUp() throws Exception {
        logFile = tmp.newFile("app.log");
    }

    @Test
    public void shouldWriteLogIntoFile_whenLoggerTypeIsFile() throws IOException {
        System.setProperty("logger.type", "file");
        System.setProperty("logger.location", logFile.getAbsolutePath());

        new Foo().run();
        new Bar().run();

        String logContent = Files.asCharSource(logFile, Charsets.UTF_8).read();
        assertThat(logContent, containsString("[INFO] Foo: Application started"));
        assertThat(logContent, containsString("[INFO] Bar: Application started"));
    }

    @Test
    public void shouldNotWriteLogIntoFile_whenLoggerTypeIsNotFile() throws IOException {
        System.clearProperty("logger.type");
        System.clearProperty("logger.location");

        new Foo().run();
        new Bar().run();

        assertThat(Files.asCharSource(logFile, Charsets.UTF_8).read(), emptyString());
    }
}
