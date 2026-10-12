import java.util.List;

// Programs to interfaces: depends on Notifier and Payable, never on concrete classes
public class PayrollService {
    private final Notifier notifier;

    public PayrollService(Notifier notifier) {
        this.notifier = notifier;
    }

    public void run(List<? extends Employee> staff) {
        for (Employee e : staff) {
            notifier.send(e.getName(), e.payslip());
        }
    }
}
