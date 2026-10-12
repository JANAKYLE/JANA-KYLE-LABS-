import java.util.ArrayList;
import java.util.List;

// The SUBJECT in the Observer pattern. Single responsibility: manage tasks.
public class TaskService {
    private final List<Task> tasks = new ArrayList<>();
    private final List<TaskListener> listeners = new ArrayList<>();
    private int nextId = 1;

    public void addListener(TaskListener listener) {
        listeners.add(listener);
    }

    private void notifyListeners(String event, Task task) {
        for (TaskListener l : listeners) {
            l.onEvent(event, task);
        }
    }

    public Task add(String title, Priority priority) {
        AppConfig config = AppConfig.getInstance();               // Singleton in use
        if (title == null || title.isBlank()) {
            throw new IllegalArgumentException("Title must not be empty");
        }
        if (title.length() > config.getMaxTitleLength() || title.contains(",")) {
            throw new IllegalArgumentException("Invalid title: " + title);
        }
        Task t = new Task(nextId++, title.trim(), priority, false);
        tasks.add(t);
        notifyListeners("ADDED", t);
        return t;
    }

    public Task find(int id) throws TaskNotFoundException {
        for (Task t : tasks) {
            if (t.getId() == id) {
                return t;
            }
        }
        throw new TaskNotFoundException(id);
    }

    public void complete(int id) throws TaskNotFoundException {
        Task t = find(id);
        t.markDone();
        notifyListeners("COMPLETED", t);
    }

    public List<Task> sorted(SortStrategy strategy) {             // Strategy in use
        return strategy.sort(tasks);
    }

    public List<Task> all() {
        return new ArrayList<>(tasks);
    }

    public void restore(List<Task> loaded) {
        tasks.clear();
        tasks.addAll(loaded);
        nextId = loaded.stream().mapToInt(Task::getId).max().orElse(0) + 1;
    }
}
