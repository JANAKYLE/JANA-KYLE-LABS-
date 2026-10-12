// Implements AutoCloseable so try-with-resources can close it automatically
public class AuditLog implements AutoCloseable {
    private final String name;

    public AuditLog(String name) {
        this.name = name;
        System.out.println("  [" + name + "] opened");
    }

    public void write(String entry) {
        System.out.println("  [" + name + "] " + entry);
    }

    @Override
    public void close() {
        System.out.println("  [" + name + "] closed");
    }
}
