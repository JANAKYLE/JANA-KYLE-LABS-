import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.NoSuchFileException;
import java.nio.file.Path;
import java.nio.file.StandardOpenOption;
import java.util.List;

public class FileIoDemo {
    public static void run() {
        Path file = null;
        try {
            file = Files.createTempFile("products", ".csv");

            ProductRepository.save(file, List.of(
                    new Product("Laptop", "Electronics", 850.0, 5),
                    new Product("Desk", "Furniture", 150.0, 8)));
            System.out.println("File after save():");
            System.out.print(Files.readString(file));

            ProductRepository.append(file, new Product("Pen", "Stationery", 0.8, 500));
            Files.writeString(file, "Broken,line\nChair,Furniture,abc,3\n", StandardOpenOption.APPEND);

            System.out.println("Loading (two lines are deliberately bad):");
            List<Product> loaded = ProductRepository.load(file);
            for (Product p : loaded) {
                System.out.println("  " + p);
            }
            System.out.println("Loaded " + loaded.size() + " valid products");

            // Handling a checked IOException
            ProductRepository.load(Path.of("does-not-exist.csv"));
        } catch (NoSuchFileException e) {
            System.out.println("File not found: " + e.getMessage());
        } catch (IOException e) {
            System.out.println("I/O problem: " + e.getMessage());
        } finally {
            try {
                if (file != null) {
                    Files.deleteIfExists(file);
                }
            } catch (IOException ignored) {
                // nothing more we can do
            }
        }
    }
}
