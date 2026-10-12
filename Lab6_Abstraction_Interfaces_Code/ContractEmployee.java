public class ContractEmployee extends Employee {
    private final double hourlyRate;
    private final int hoursWorked;

    public ContractEmployee(String name, int id, double hourlyRate, int hoursWorked) {
        super(name, id);
        this.hourlyRate = hourlyRate;
        this.hoursWorked = hoursWorked;
    }

    @Override
    public double calculatePay() {
        return hourlyRate * hoursWorked;
    }

    @Override
    public String role() {
        return "Contract";
    }

    @Override
    public String payslip() {                    // overriding a default method
        return String.format("Pay due: $%.2f (%d h @ $%.2f)",
                calculatePay(), hoursWorked, hourlyRate);
    }
}
