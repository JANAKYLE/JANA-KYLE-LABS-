package lab3.other;

import lab3.access.AccessDemo;

public class UnrelatedTest {  // different package, NOT a subclass
    public static void main(String[] args) {
        AccessDemo d = new AccessDemo();
        System.out.println(d.publicField);  // OK: the only one visible here
        // System.out.println(d.protectedField);       // ERROR: protected access
        // System.out.println(d.defaultField);         // ERROR: not public
        // System.out.println(d.privateField);         // ERROR: private
    }
}
