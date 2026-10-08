package lab3.other;

import lab3.access.AccessDemo;

public class SubclassTest extends AccessDemo {  // different package, but a SUBCLASS
    public static void main(String[] args) {
        new SubclassTest().test();
    }

    void test() {
        System.out.println(publicField);  // OK
        System.out.println(protectedField);  // OK (inherited, accessed through this)
        // System.out.println(defaultField);   // ERROR: not visible here
        // System.out.println(privateField);           // ERROR: private
    }
}
