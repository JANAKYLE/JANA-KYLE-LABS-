import java.nio.file.Path;

// PATTERN 1: SINGLETON. Exactly one instance, reachable from everywhere.
public class AppConfig {
    private static AppConfig instance;                 // the one and only instance

    private final String appName = "Task Manager";
    private final int maxTitleLength = 25;
    private Path dataFile = Path.of("tasks.csv");

    private AppConfig() {                              // private: nobody else can call new
    }

    public static synchronized AppConfig getInstance() {
        if (instance == null) {                        // lazy creation
            instance = new AppConfig();
        }
        return instance;
    }

    public String getAppName() { return appName; }
    public int getMaxTitleLength() { return maxTitleLength; }
    public Path getDataFile() { return dataFile; }
    public void setDataFile(Path dataFile) { this.dataFile = dataFile; }
}
