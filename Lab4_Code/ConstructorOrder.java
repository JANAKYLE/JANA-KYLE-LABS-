public class ConstructorOrder {
    public static void main(String[] args) {
        System.out.println("Creating C...");
        new C();
    }
}

class A {
    A() { System.out.println("A constructor"); }  // implicit super() -> Object()
}

class B extends A {
    B() {  // implicit super() -> A()
        System.out.println("B constructor");
    }
}

class C extends B {
    C() {  // implicit super() -> B()
        System.out.println("C constructor");
    }
}
