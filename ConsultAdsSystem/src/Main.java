public class Main{
    public static void main(String[] args) {
        ChatUser chat = new ChatUser("localhost", "chat_test", "history", "admin", "1234", 1, "aom");
        chat.sendMessageToDB("hello this is the first message");
        chat.autoUpdateLocalChat();
    }
}