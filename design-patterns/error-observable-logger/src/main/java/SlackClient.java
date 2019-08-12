public class SlackClient {
    public void sendMessage(String chatId, String message) {
        System.out.println(String.format("Sending message to %s: %s.", chatId, message));
    }
}
