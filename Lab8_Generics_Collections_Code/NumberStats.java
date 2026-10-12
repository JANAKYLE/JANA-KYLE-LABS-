import java.util.List;

// Bounded type parameter: T must be a Number (Integer, Double, ...)
public class NumberStats<T extends Number> {
    private final List<T> values;

    public NumberStats(List<T> values) {
        this.values = values;
    }

    public double sum() {
        double total = 0;
        for (T v : values) {
            total += v.doubleValue();       // available because T extends Number
        }
        return total;
    }

    public double average() {
        return values.isEmpty() ? 0 : sum() / values.size();
    }
}
