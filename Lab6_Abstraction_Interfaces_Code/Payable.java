// An interface: a contract with no state, plus optional default and static methods
public interface Payable {
    double calculatePay();                       // implicitly public abstract

    default String payslip() {                   // default method: shared behaviour
        return String.format("Pay due: $%.2f", calculatePay());
    }

    static double totalPay(java.util.List<? extends Payable> items) {   // static method
        double total = 0;
        for (Payable p : items) {
            total += p.calculatePay();
        }
        return total;
    }
}
