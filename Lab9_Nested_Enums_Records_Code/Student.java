// A record is an immutable data carrier. The compiler generates the constructor,
// accessors (name(), mark()), equals, hashCode and toString.
public record Student(String name, int mark) {

    // Compact constructor: validation runs before the fields are assigned
    public Student {
        if (name == null || name.isBlank()) {
            throw new IllegalArgumentException("name is required");
        }
        if (mark < 0 || mark > 100) {
            throw new IllegalArgumentException("mark must be 0-100 but was " + mark);
        }
    }

    // Records may have extra methods and static factories
    public String grade() {
        if (mark >= 75) return "A";
        if (mark >= 60) return "B";
        if (mark >= 50) return "C";
        return "F";
    }

    public static Student parse(String text) {          // "Tariro:82"
        String[] parts = text.split(":");
        return new Student(parts[0].trim(), Integer.parseInt(parts[1].trim()));
    }
}
