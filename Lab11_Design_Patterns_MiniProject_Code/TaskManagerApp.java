import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.List;

public class TaskManagerApp {
    public static void main(String[] args) {
        AppConfig config = AppConfig.getInstance();
        System.out.println("=== " + config.getAppName() + " ===");

        System.out.println("\n--- Singleton ---");
        System.out.println("Same instance every time? "
                + (AppConfig.getInstance() == AppConfig.getInstance()));

        System.out.println("\n--- Observer: register listeners, then add tasks ---");
        TaskService service = new TaskService();
        StatsListener stats = new StatsListener();
        service.addListener(new ConsoleLogger());
        service.addListener(stats);
        service.add("Finish OOP lab", Priority.HIGH);
        service.add("Buy data bundle", Priority.LOW);
        service.add("Revise exceptions", Priority.MEDIUM);
        service.add("Email lecturer", Priority.HIGH);

        System.out.println("\n--- Exceptions: bad input and missing task ---");
        try {
            service.add("", Priority.LOW);
        } catch (IllegalArgumentException e) {
            System.out.println("  Rejected: " + e.getMessage());
        }
        try {
            service.add("Too, many, commas", Priority.LOW);
        } catch (IllegalArgumentException e) {
            System.out.println("  Rejected: " + e.getMessage());
        }
        try {
            service.complete(1);
            service.complete(99);
        } catch (TaskNotFoundException e) {
            System.out.println("  Error: " + e.getMessage());
        }

        System.out.println("\n--- Strategy: swap the sorting algorithm ---");
        System.out.println("By priority:");
        service.sorted(new ByPriority()).forEach(t -> System.out.println("  " + t));
        System.out.println("By title:");
        service.sorted(new ByTitle()).forEach(t -> System.out.println("  " + t));

        System.out.println("\n--- Factory: choose an exporter by name ---");
        for (String type : List.of("text", "csv")) {
            Exporter exporter = ExporterFactory.create(type);
            System.out.println(type + " export:");
            System.out.println(exporter.export(service.all()));
        }
        try {
            ExporterFactory.create("pdf");
        } catch (IllegalArgumentException e) {
            System.out.println("Factory error: " + e.getMessage());
        }

        System.out.println("\n--- File I/O: save, reload ---");
        Path file = null;
        try {
            file = Files.createTempFile("tasks", ".csv");
            config.setDataFile(file);
            TaskStorage.save(config.getDataFile(), service.all());

            TaskService fresh = new TaskService();
            fresh.restore(TaskStorage.load(config.getDataFile()));
            System.out.println("Reloaded " + fresh.all().size() + " tasks:");
            fresh.all().forEach(t -> System.out.println("  " + t));
            Task added = fresh.add("New after reload", Priority.LOW);
            System.out.println("Next id continues at: " + added.getId());
        } catch (IOException e) {
            System.out.println("Storage problem: " + e.getMessage());
        } finally {
            try {
                if (file != null) Files.deleteIfExists(file);
            } catch (IOException ignored) {
            }
        }

        System.out.println("\n" + stats.summary());
    }
}
