public class Developer extends Employee {
    private int overtimeHours;

    public Developer(String name, double baseSalary, int overtimeHours) {
        super(name, baseSalary);
        this.overtimeHours = overtimeHours;
        System.out.println("Developer constructor: " + name);
    }

    @Override
    public double calculatePay() {
        return baseSalary + overtimeHours * 15;  // protected field used directly
    }
}
