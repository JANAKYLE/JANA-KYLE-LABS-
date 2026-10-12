import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.function.BiFunction;
import java.util.function.BinaryOperator;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.function.Supplier;
import java.util.function.UnaryOperator;

public class LambdaDemo {

    // Our own functional interface: exactly ONE abstract method
    @FunctionalInterface
    interface Discount {
        double apply(double price);
    }

    public static void run() {
        System.out.println("-- Lambdas and the standard functional interfaces --");
        Runnable greet = () -> System.out.println("Runnable lambda: hello");
        greet.run();

        Predicate<Integer> isEven = n -> n % 2 == 0;                  // T -> boolean
        Function<String, Integer> length = s -> s.length();           // T -> R
        Consumer<String> shout = s -> System.out.println(s.toUpperCase() + "!"); // T -> void
        Supplier<Double> half = () -> 0.5;                            // () -> T
        BiFunction<Integer, Integer, Integer> add = (a, b) -> a + b;  // (T, U) -> R
        UnaryOperator<String> trim = String::trim;                    // T -> T

        System.out.println("isEven(4) = " + isEven.test(4) + ", isEven(7) = " + isEven.test(7));
        System.out.println("length(\"lambda\") = " + length.apply("lambda"));
        shout.accept("consumer");
        System.out.println("supplier = " + half.get() + ", add(2,3) = " + add.apply(2, 3));
        System.out.println("trim = [" + trim.apply("  hi  ") + "]");
        System.out.println("isEven.negate().test(4) = " + isEven.negate().test(4));

        Discount tenOff = price -> price * 0.9;
        int fixed = 20;                                    // effectively final: may be captured
        Discount minus = price -> price - fixed;
        System.out.println("tenOff(200) = " + tenOff.apply(200) + ", minus(200) = " + minus.apply(200));

        System.out.println("\n-- Method references --");
        List<String> names = new ArrayList<>(Arrays.asList("kyle", "Tariro", "farai", "Anesu"));
        names.sort(String::compareToIgnoreCase);                      // arbitrary instance
        System.out.println("sorted ignoring case, printed with System.out::println:");
        names.forEach(System.out::println);     // particular instance
        Function<String, Integer> parse = Integer::parseInt;          // static method
        Supplier<List<String>> maker = ArrayList::new;                // constructor
        BinaryOperator<Integer> bigger = Math::max;                   // static method
        System.out.println("parse(\"42\") + 1 = " + (parse.apply("42") + 1));
        System.out.println("new list size = " + maker.get().size() + ", max(3,9) = " + bigger.apply(3, 9));

        System.out.println("\n-- Lambda as Comparator --");
        List<String> words = new ArrayList<>(List.of("kiwi", "fig", "banana", "apple"));
        words.sort((a, b) -> a.length() - b.length());
        System.out.println("by length: " + words);
        words.sort(Comparator.comparing(String::length).reversed().thenComparing(Comparator.naturalOrder()));
        System.out.println("longest first: " + words);
    }
}
