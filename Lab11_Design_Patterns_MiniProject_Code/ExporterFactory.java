// PATTERN 2: FACTORY. Callers ask for a type by name and get an Exporter back,
// without knowing which concrete class is created.
public class ExporterFactory {
    public static Exporter create(String type) {
        return switch (type.toLowerCase()) {
            case "csv" -> new CsvExporter();
            case "text" -> new TextExporter();
            default -> throw new IllegalArgumentException("Unknown exporter: " + type);
        };
    }
}
