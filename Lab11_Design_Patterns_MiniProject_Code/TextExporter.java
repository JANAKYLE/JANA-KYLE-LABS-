import java.util.List;
import java.util.stream.Collectors;

public class TextExporter implements Exporter {
    @Override
    public String export(List<Task> tasks) {
        return tasks.stream().map(Task::toString).collect(Collectors.joining("\n"));
    }
}
