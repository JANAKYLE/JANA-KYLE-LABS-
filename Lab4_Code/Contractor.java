public final class Contractor extends Employee {  // final class: cannot be extended
    public Contractor(String name, double baseSalary) {
        super(name, baseSalary);
        System.out.println("Contractor constructor: " + name);
    }
}
