public class SmsNotifier implements Notifier {
    @Override
    public void send(String to, String message) {
        System.out.println("[SMS to " + to + "] " + message);
    }
}
