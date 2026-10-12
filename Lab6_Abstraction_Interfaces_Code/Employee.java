// Abstract class: shared state + partial implementation. Cannot be instantiated.
public abstract class Employee implements Payable, Comparable<Employee> {
    private final String name;
    private final int id;

    protected Employee(String name, int id) {
        this.name = name;
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public int getId() {
        return id;
    }

    public abstract String role();               // each subclass must supply this

    @Override
    public int compareTo(Employee other) {       // natural ordering: by pay, then name
        int byPay = Double.compare(this.calculatePay(), other.calculatePay());
        return byPay != 0 ? byPay : this.name.compareTo(other.name);
    }

    @Override
    public String toString() {
        return String.format("%-8s %-10s %s", role(), name, payslip());
    }
}
