// CHECKED exception: callers are forced to handle or declare it
public class InsufficientFundsException extends Exception {
    private final double balance;
    private final double requested;

    public InsufficientFundsException(double balance, double requested) {
        super(String.format("Cannot withdraw %.2f: balance is only %.2f", requested, balance));
        this.balance = balance;
        this.requested = requested;
    }

    public double getShortfall() {
        return requested - balance;
    }
}
