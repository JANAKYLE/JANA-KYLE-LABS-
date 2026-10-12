// PATTERN 4: OBSERVER. Observers implement this and register with the subject.
public interface TaskListener {
    void onEvent(String event, Task task);
}
