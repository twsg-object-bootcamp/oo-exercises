public class EmailClient {
    public void sendEmail(String recipient, String subject, String body) {
        System.out.println(String.format("Sending email to %s with subject: %s. Body: %s.", recipient, subject, body));
    }
}
