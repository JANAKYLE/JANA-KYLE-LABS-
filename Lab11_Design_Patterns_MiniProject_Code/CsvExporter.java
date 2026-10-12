import java.util.List;
import java.util.stream.Collectors;

public class CsvExporter implements Exporter {
    @Override
    public String export(List<Task> tasks) {
        return tasks.stream().map(Task::toCsv).collect(Collectors.joining("\n"));
    }
}
