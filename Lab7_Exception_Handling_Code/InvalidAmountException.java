// UNCHECKED exception: signals a programming error (bad argument)
public class InvalidAmountException extends RuntimeException {
    public InvalidAmountException(double amount) {
        super("Amount must be positive but was " + amount);
    }
}
