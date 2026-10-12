public class ConsoleLogger implements TaskListener {
    @Override
    public void onEvent(String event, Task task) {
        System.out.println("  [LOG] " + event + ": " + task.getTitle());
    }
}
