import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.runners.MockitoJUnitRunner;

import static org.mockito.Matchers.*;
import static org.mockito.Mockito.never;
import static org.mockito.Mockito.verify;

@RunWith(MockitoJUnitRunner.class)
public class AlertTest {
    @Mock
    private EmailClient emailClient;
    @Mock
    private SlackClient slackClient;

    private App app;

    @Before
    public void setUp() throws Exception {
        app = new App(slackClient, emailClient);
    }

    @Test
    public void shouldSendAlert_whenAnErrorIsLogged() {
        app.runWithError();

        verify(emailClient).sendEmail(anyString(), anyString(), contains("Something wrong happened."));
    }

    @Test
    public void shouldSendAlertMessageToSlack_whenAnErrorIsLogged() {
        app.runWithError();

        verify(slackClient).sendMessage(anyString(), contains("Something wrong happened."));
    }

    @Test
    public void shouldNotSendAlert_whenThereIsNoError() {
        app.runSuccessfully();

        verify(emailClient, never()).sendEmail(anyString(), anyString(), anyString());
    }

    @Test
    public void shouldNotSendAlertMessageToSlack_whenThereIsNoError() {
        app.runSuccessfully();

        verify(slackClient, never()).sendMessage(anyString(), anyString());
    }
}
