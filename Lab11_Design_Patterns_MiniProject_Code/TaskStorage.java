import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.List;

// Single responsibility: persistence only
public class TaskStorage {
    public static void save(Path file, List<Task> tasks) throws IOException {
        List<String> lines = new ArrayList<>();
        for (Task t : tasks) {
            lines.add(t.toCsv());
        }
        Files.write(file, lines);
    }

    public static List<Task> load(Path file) throws IOException {
        List<Task> result = new ArrayList<>();
        for (String line : Files.readAllLines(file)) {
            if (!line.isBlank()) {
                result.add(Task.fromCsv(line));
            }
        }
        return result;
    }
}
