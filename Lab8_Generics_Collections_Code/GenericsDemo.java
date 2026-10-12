import java.util.*;

public class GenericsDemo {
    public static void main(String[] args) {

        System.out.println("=== Part A: Generic classes ===");
        Box<String> textBox = new Box<>("Hello");
        Box<Integer> numBox = new Box<>(42);        // int -> Integer (autoboxing)
        String s = textBox.get();                   // no cast needed
        int n = numBox.get();                       // auto-unboxing
        System.out.println(textBox + " " + numBox + " -> " + s + ", " + n);
        // textBox.set(99);                         // COMPILE ERROR: type safety

        Pair<String, Integer> p = new Pair<>("Age", 20);
        System.out.println("Pair: " + p);

        System.out.println("\n=== Part B: Bounded types and generic methods ===");
        NumberStats<Integer> stats = new NumberStats<>(List.of(4, 8, 15, 16, 23, 42));
        System.out.printf("sum = %.1f, average = %.2f%n", stats.sum(), stats.average());
        System.out.println("max of ints    = " + GenericUtils.max(List.of(3, 9, 2)));
        System.out.println("max of strings = "
                + GenericUtils.max(List.of("pear", "apple", "zebra")));
        System.out.println("sumAll(doubles)= " + GenericUtils.sumAll(List.of(1.5, 2.5)));

        List<String> letters = new ArrayList<>(List.of("A", "B", "C"));
        GenericUtils.swap(letters, 0, 2);
        System.out.println("after swap: " + letters);

        System.out.println("\n=== Part C: Type erasure ===");
        List<String> strings = new ArrayList<>();
        List<Integer> ints = new ArrayList<>();
        System.out.println("Same runtime class? " + (strings.getClass() == ints.getClass()));

        System.out.println("\n=== Part D: List, Set, Map, Queue ===");
        List<String> list = new ArrayList<>(List.of("b", "a", "b", "c"));
        Set<String> set = new TreeSet<>(list);                 // no duplicates, sorted
        System.out.println("List (keeps duplicates, ordered): " + list);
        System.out.println("TreeSet (unique, sorted)        : " + set);

        Map<String, Integer> wordCount = new HashMap<>();
        for (String w : "to be or not to be".split(" ")) {
            wordCount.merge(w, 1, Integer::sum);
        }
        System.out.println("Map word counts: " + new TreeMap<>(wordCount));

        Queue<String> queue = new LinkedList<>();              // FIFO
        queue.offer("first");
        queue.offer("second");
        queue.offer("third");
        System.out.println("Queue poll: " + queue.poll() + ", next in line: " + queue.peek());

        System.out.println("\n=== Part E: Comparable, Comparator, Collections ===");
        List<Student> students = new ArrayList<>(List.of(
                new Student("Chipo", 72), new Student("Farai", 88),
                new Student("Anesu", 65), new Student("Tariro", 88)));

        Collections.sort(students);                            // natural order (Comparable)
        System.out.println("By name        : " + students);

        students.sort(Comparator.comparingInt(Student::getMark).reversed()
                .thenComparing(Student::getName));             // Comparator
        System.out.println("By mark (desc) : " + students);

        List<Integer> sorted = new ArrayList<>(List.of(40, 10, 30, 20));
        Collections.sort(sorted);
        int idx = Collections.binarySearch(sorted, 30);
        System.out.println("Sorted " + sorted + ", index of 30 = " + idx);
        System.out.println("Max = " + Collections.max(sorted) + ", Min = " + Collections.min(sorted));
        Collections.reverse(sorted);
        System.out.println("Reversed: " + sorted);
    }
}
