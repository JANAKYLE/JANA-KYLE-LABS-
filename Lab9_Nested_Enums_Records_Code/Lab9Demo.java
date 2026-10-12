import java.util.EnumMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class Lab9Demo {
    public static void main(String[] args) {

        System.out.println("=== Part A: Four kinds of nested class ===");
        Library lib = new Library("City Library");
        lib.addBook("Algorithms");
        lib.addBook("Java in Depth");
        lib.addBook("Art of Computing");

        Library.Settings settings = new Library.Settings(14);       // no Library object needed
        System.out.println(settings.describe());

        Library.Member kyle = lib.new Member("Kyle");               // needs a Library object
        kyle.borrow("Algorithms");
        kyle.borrow("Algorithms");

        System.out.println("Starts with J: " + lib.titlesStartingWith('j'));
        System.out.println("By length    : " + lib.sortedByLength());

        System.out.println("\n=== Part B: Enums ===");
        Priority p = Priority.HIGH;
        System.out.println(p + " -> level " + p.getLevel() + ", label " + p.getLabel()
                + ", urgent? " + p.isUrgent());
        for (Priority each : Priority.values()) {
            System.out.println("  " + each.ordinal() + ": " + each.name());
        }
        System.out.println("valueOf(\"LOW\")  = " + Priority.valueOf("LOW"));
        System.out.println("fromLevel(2)    = " + Priority.fromLevel(2));
        try {
            Priority.valueOf("URGENT");
        } catch (IllegalArgumentException e) {
            System.out.println("valueOf(\"URGENT\") fails: IllegalArgumentException");
        }

        String advice = switch (p) {                                 // switch expression
            case LOW -> "Do it when free";
            case MEDIUM -> "Do it this week";
            case HIGH -> "Do it today";
        };
        System.out.println("Advice for " + p + ": " + advice);

        for (Operation op : Operation.values()) {
            System.out.println("  3 " + op.getSymbol() + " 4 = " + op.apply(3, 4));
        }

        Map<Priority, Integer> counts = new EnumMap<>(Priority.class);
        counts.put(Priority.HIGH, 2);
        counts.put(Priority.LOW, 5);
        System.out.println("EnumMap (kept in enum order): " + counts);

        System.out.println("\n=== Part C: Records ===");
        Student s1 = new Student("Tariro", 82);
        Student s2 = new Student("Tariro", 82);
        System.out.println(s1);                                      // generated toString
        System.out.println("name() = " + s1.name() + ", mark() = " + s1.mark()
                + ", grade = " + s1.grade());
        System.out.println("s1.equals(s2) = " + s1.equals(s2) + ", s1 == s2 = " + (s1 == s2));
        System.out.println("Parsed: " + Student.parse("Farai: 58"));
        try {
            new Student("Bad", 150);
        } catch (IllegalArgumentException e) {
            System.out.println("Rejected: " + e.getMessage());
        }

        System.out.println("\n=== Part D: The equals / hashCode contract ===");
        Set<BrokenPoint> broken = new HashSet<>();
        broken.add(new BrokenPoint(1, 2));
        broken.add(new BrokenPoint(1, 2));
        System.out.println("BrokenPoint set size   : " + broken.size() + "  (expected 1)");
        System.out.println("contains equal point?  : " + broken.contains(new BrokenPoint(1, 2)));

        Set<SoundPoint> sound = new HashSet<>();
        sound.add(new SoundPoint(1, 2));
        sound.add(new SoundPoint(1, 2));
        System.out.println("SoundPoint set size    : " + sound.size());
        System.out.println("contains equal point?  : " + sound.contains(new SoundPoint(1, 2)));
        System.out.println("toString               : " + new SoundPoint(1, 2));
        System.out.println("equal hash codes?      : "
                + (new SoundPoint(1, 2).hashCode() == new SoundPoint(1, 2).hashCode()));
    }
}
