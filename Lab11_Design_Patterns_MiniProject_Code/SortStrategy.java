import java.util.List;

// PATTERN 3: STRATEGY. One interface, interchangeable algorithms.
public interface SortStrategy {
    List<Task> sort(List<Task> tasks);
}
