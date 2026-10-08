public class ReferenceDemo {
    public static void main(String[] args) {
        Student a = new Student();
        a.name = "Tendai";

        Student b = a;                       // copies the reference
        b.name = "Rudo";                     // changes the one shared object
        System.out.println(a.name);          // Rudo

        Student c = new Student();           // a second, separate object
        c.name = "Rudo";
        System.out.println(a == b);          // true  (same object)
        System.out.println(a == c);          // false (different objects)

        b = c;                               // b now points to the second object
        b.name = "Farai";
        System.out.println(a.name + " " + c.name);   // Rudo Farai
    }
}
