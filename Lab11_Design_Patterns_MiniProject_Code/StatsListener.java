public class StatsListener implements TaskListener {
    private int added;
    private int completed;

    @Override
    public void onEvent(String event, Task task) {
        if (event.equals("ADDED")) {
            added++;
        } else if (event.equals("COMPLETED")) {
            completed++;
        }
    }

    public String summary() {
        return "Stats: " + added + " added, " + completed + " completed";
    }
}
