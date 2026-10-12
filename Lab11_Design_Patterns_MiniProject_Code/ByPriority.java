import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class ByPriority implements SortStrategy {
    @Override
    public List<Task> sort(List<Task> tasks) {
        List<Task> copy = new ArrayList<>(tasks);
        copy.sort(Comparator.comparing(Task::getPriority).reversed()   // HIGH first
                .thenComparing(Task::getTitle));
        return copy;
    }
}
