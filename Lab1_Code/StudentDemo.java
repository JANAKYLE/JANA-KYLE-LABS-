public class StudentDemo {
    public static void main(String[] args) {
        Student s1 = new Student();          // create an object with new
        s1.name = "Tendai";                  // dot operator: set fields
        s1.regNo = 101;
        s1.mark = 67.5;

        Student s2 = new Student();
        s2.name = "Rudo";
        s2.regNo = 102;
        s2.mark = 42;

        s1.display();                        // dot operator: call methods
        s2.display();
        System.out.println(s1.name + " passed? " + s1.hasPassed());
        System.out.println(s2.name + " passed? " + s2.hasPassed());
    }
}
