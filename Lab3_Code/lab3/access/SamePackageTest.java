package lab3.access;

public class SamePackageTest {  // same package, NOT a subclass
    public static void main(String[] args) {
        AccessDemo d = new AccessDemo();
        System.out.println(d.publicField);  // OK
        System.out.println(d.protectedField);  // OK (same package)
        System.out.println(d.defaultField);  // OK (same package)
        // System.out.println(d.privateField);   // ERROR: private access
        d.showAll();  // a public method may use the private field for us
    }
}
