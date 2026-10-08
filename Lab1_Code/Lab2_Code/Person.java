public class Person {
    // ---- static members belong to the CLASS ----
    private static int count = 0;  // shared by all objects
    static final String SCHOOL;

    static {  // static initialiser block: runs ONCE, when the class is loaded
        SCHOOL = "HIT";
        System.out.println("[static block]   Person class loaded");
    }

    // ---- instance members belong to each OBJECT ----
    String name;
    int age;

    {  // instance initialiser block: runs for EVERY object, before the constructor body
        count++;
        System.out.println("[instance block] creating object #" + count);
    }

    // ---- overloaded constructors, chained with this(...) ----
    Person() {
        this("Unknown", 0);  // calls Person(String, int)
        System.out.println("Person()");
    }

    Person(String name) {
        this(name, 0);  // calls Person(String, int)
        System.out.println("Person(String)");
    }

    Person(String name, int age) {  // the "main" constructor
        this.name = name;  // this.name = field, name = parameter
        this.age = age;
        System.out.println("Person(String, int)");
    }

    static int getCount() {  // static method: no 'this'
        return count;
    }

    void display() {
        System.out.println(name + ", " + age + " (" + SCHOOL + ")");
    }
}
