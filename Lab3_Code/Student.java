public class Student {
    private String name;
    private int mark;  // invariant: 0 <= mark <= 100

    public Student(String name, int mark) {
        setName(name);  // constructor and setters share the same rules
        setMark(mark);
    }

    public String getName() { return name; }
    public int getMark()    { return mark; }

    public void setName(String name) {
        if (name == null || name.isBlank()) {
            throw new IllegalArgumentException("Name cannot be empty");
        }
        this.name = name.trim();
    }

    public void setMark(int mark) {
        if (mark < 0 || mark > 100) {
            throw new IllegalArgumentException(
                "Mark must be between 0 and 100, got " + mark);
        }
        this.mark = mark;
    }

    // derived value: computed, so it can never disagree with mark
    public String getGrade() {
        if (mark >= 75) return "A";
        if (mark >= 60) return "B";
        if (mark >= 50) return "C";
        return "F";
    }
}
