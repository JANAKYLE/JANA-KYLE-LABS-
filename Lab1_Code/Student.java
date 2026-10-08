public class Student {
    // State (fields)
    String name;
    int regNo;
    double mark;

    // Behaviour (methods)
    void display() {
        System.out.println(regNo + " " + name + " scored " + mark);
    }

    boolean hasPassed() {
        return mark >= 50;
    }
}
