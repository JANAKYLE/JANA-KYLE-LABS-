import java.util.List;
import java.util.Map;
import java.util.TreeMap;
import java.util.stream.Collectors;

public class StreamDemo {
    public static void run() {
        List<Product> products = List.of(
                new Product("Laptop", "Electronics", 850.00, 5),
                new Product("Phone", "Electronics", 520.00, 10),
                new Product("Monitor", "Electronics", 210.00, 7),
                new Product("Desk", "Furniture", 150.00, 8),
                new Product("Chair", "Furniture", 80.00, 20),
                new Product("Notebook", "Stationery", 2.50, 200),
                new Product("Pen", "Stationery", 0.80, 500));

        // filter + map + collect
        List<String> pricey = products.stream()
                .filter(p -> p.price() > 100)
                .map(Product::name)
                .collect(Collectors.toList());
        System.out.println("Price over 100       : " + pricey);

        // sorted + limit
        List<String> top3 = products.stream()
                .sorted((a, b) -> Double.compare(b.price(), a.price()))
                .limit(3)
                .map(Product::name)
                .toList();
        System.out.println("Top 3 by price       : " + top3);

        // sorted with a Comparator, then joining
        String alphabetical = products.stream()
                .map(Product::name)
                .sorted()
                .collect(Collectors.joining(", ", "[", "]"));
        System.out.println("Alphabetical         : " + alphabetical);

        // reduce: total stock value two ways
        double total = products.stream()
                .map(Product::value)
                .reduce(0.0, Double::sum);
        double total2 = products.stream().mapToDouble(Product::value).sum();
        System.out.printf("Total stock value    : %.2f (reduce) / %.2f (mapToDouble)%n", total, total2);

        // grouping
        Map<String, Long> countByCategory = products.stream()
                .collect(Collectors.groupingBy(Product::category, TreeMap::new, Collectors.counting()));
        System.out.println("Count per category   : " + countByCategory);

        Map<String, Double> avgPrice = products.stream()
                .collect(Collectors.groupingBy(Product::category, TreeMap::new,
                        Collectors.averagingDouble(Product::price)));
        avgPrice.forEach((cat, avg) -> System.out.printf("  avg price %-12s: %.2f%n", cat, avg));

        // other terminal operations
        System.out.println("Any under 1.00?      : " + products.stream().anyMatch(p -> p.price() < 1));
        System.out.println("All have stock?      : " + products.stream().allMatch(p -> p.quantity() > 0));
        System.out.println("Cheapest             : " + products.stream()
                .min((a, b) -> Double.compare(a.price(), b.price())).get().name());
        System.out.println("Furniture count      : " + products.stream()
                .filter(p -> p.category().equals("Furniture")).count());
        System.out.println("First over 500       : " + products.stream()
                .filter(p -> p.price() > 500).findFirst().map(Product::name).orElse("none"));
    }
}
