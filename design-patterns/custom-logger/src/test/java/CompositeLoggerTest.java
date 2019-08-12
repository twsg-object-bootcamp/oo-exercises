import com.google.common.base.Charsets;
import com.google.common.io.Files;
import org.junit.Before;
import org.junit.Ignore;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.TemporaryFolder;

import java.io.File;
import java.io.IOException;

import static org.hamcrest.Matchers.containsString;
import static org.hamcrest.Matchers.emptyString;
import static org.junit.Assert.assertThat;

@Ignore("Reserved for Composite Pattern exercise")
public class CompositeLoggerTest {
    @Rule
    public TemporaryFolder tmp = new TemporaryFolder();
    private File logFile1;
    private File logFile2;

    @Before
    public void setUp() throws Exception {
        logFile1 = tmp.newFile("app_1.log");
        logFile2 = tmp.newFile("app_2.log");
    }

    @Test
    public void shouldWriteLogIntoFile_whenLoggerTypeIsFile() throws IOException {
        System.setProperty("logger.type", "multi_files");
        System.setProperty("logger.location_1", logFile1.getAbsolutePath());
        System.setProperty("logger.location_2", logFile2.getAbsolutePath());

        new Foo().run();
        new Bar().run();

        String logContent1 = Files.asCharSource(logFile1, Charsets.UTF_8).read();
        assertThat(logContent1, containsString("[INFO] Foo: Application started"));
        assertThat(logContent1, containsString("[INFO] Bar: Application started"));
        String logContent2 = Files.asCharSource(logFile2, Charsets.UTF_8).read();
        assertThat(logContent2, containsString("[INFO] Foo: Application started"));
        assertThat(logContent2, containsString("[INFO] Bar: Application started"));
    }

    @Test
    public void shouldNotWriteLogIntoFile_whenLoggerTypeIsNotFile() throws IOException {
        System.clearProperty("logger.type");
        System.clearProperty("logger.location_1");
        System.clearProperty("logger.location_2");

        new Foo().run();
        new Bar().run();

        assertThat(Files.asCharSource(logFile1, Charsets.UTF_8).read(), emptyString());
        assertThat(Files.asCharSource(logFile2, Charsets.UTF_8).read(), emptyString());
    }
}
