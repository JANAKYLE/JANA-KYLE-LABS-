public class ObjectDemo {
    public static void main(String[] args) {
        Plain p = new Plain();

        // Every class extends java.lang.Object, so these methods exist automatically
        System.out.println(p instanceof Object);  // true
        System.out.println(p.getClass().getName());  // Plain
        // true: default toString = ClassName@hash
        System.out.println(p.toString().startsWith("Plain@"));
        // false: default equals compares references
        System.out.println(p.equals(new Plain()));

        Named n = new Named("Tendai");
        System.out.println(n);  // uses the overridden toString()
    }
}

class Plain { }  // no 'extends' written: extends Object

class Named {
    private final String name;
    Named(String name) { this.name = name; }

    @Override
    public String toString() { return "Named[" + name + "]"; }
}
