import java.io.BufferedWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.StandardOpenOption;
import java.util.ArrayList;
import java.util.List;

public class ProductRepository {
    private static final String HEADER = "name,category,price,quantity";

    // Write everything at once (replaces the file)
    public static void save(Path file, List<Product> products) throws IOException {
        List<String> lines = new ArrayList<>();
        lines.add(HEADER);
        for (Product p : products) {
            lines.add(p.toCsv());
        }
        Files.write(file, lines);
    }

    // Append one record using try-with-resources (the writer is closed automatically)
    public static void append(Path file, Product p) throws IOException {
        try (BufferedWriter w = Files.newBufferedWriter(file, StandardOpenOption.APPEND)) {
            w.write(p.toCsv());
            w.newLine();
        }
    }

    // Read everything back, skipping the header and any malformed lines
    public static List<Product> load(Path file) throws IOException {
        List<Product> result = new ArrayList<>();
        List<String> lines = Files.readAllLines(file);
        for (int i = 1; i < lines.size(); i++) {
            String line = lines.get(i).trim();
            if (line.isEmpty()) {
                continue;
            }
            try {
                result.add(Product.fromCsv(line));
            } catch (IllegalArgumentException e) {
                System.out.println("  Skipping line " + (i + 1) + ": " + e.getMessage());
            }
        }
        return result;
    }
}
