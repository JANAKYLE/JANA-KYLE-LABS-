import java.util.List;

public class GenericUtils {
    // Generic method with a bound: T must be comparable to itself
    public static <T extends Comparable<T>> T max(List<T> items) {
        T best = items.get(0);
        for (T item : items) {
            if (item.compareTo(best) > 0) {
                best = item;
            }
        }
        return best;
    }

    // Generic method: swap two positions in any list
    public static <T> void swap(List<T> list, int i, int j) {
        T temp = list.get(i);
        list.set(i, list.get(j));
        list.set(j, temp);
    }

    // Wildcard: reads any list of Numbers (List<Integer>, List<Double>, ...)
    public static double sumAll(List<? extends Number> numbers) {
        double total = 0;
        for (Number n : numbers) {
            total += n.doubleValue();
        }
        return total;
    }
}
