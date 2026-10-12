import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class ByTitle implements SortStrategy {
    @Override
    public List<Task> sort(List<Task> tasks) {
        List<Task> copy = new ArrayList<>(tasks);
        copy.sort(Comparator.comparing(Task::getTitle, String.CASE_INSENSITIVE_ORDER));
        return copy;
    }
}
