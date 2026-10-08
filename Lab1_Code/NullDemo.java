public class NullDemo {
    public static void main(String[] args) {
        // 1. Fields of reference type default to null
        Student s = new Student();
        System.out.println("Default name: " + s.name);       // null

        // 2. A reference variable that points to nothing
        Student t = null;

        // 3. Safe usage: check before using the dot operator
        if (t != null) {
            t.display();
        } else {
            System.out.println("t has no object yet");
        }

        // 4. Unsafe usage: throws NullPointerException
        try {
            t.display();
        } catch (NullPointerException e) {
            System.out.println("Caught: " + e.getMessage());
        }

        // 5. Fix: create the object first
        t = new Student();
        t.name = "Farai";
        t.regNo = 103;
        t.mark = 80;
        t.display();
    }
}
