public class BankAccount {
    private final String owner;
    private double balance;

    public BankAccount(String owner, double openingBalance) {
        if (openingBalance < 0) {
            throw new InvalidAmountException(openingBalance);
        }
        this.owner = owner;
        this.balance = openingBalance;
    }

    public double getBalance() {
        return balance;
    }

    public void deposit(double amount) {
        if (amount <= 0) {
            throw new InvalidAmountException(amount);   // validate BEFORE changing state
        }
        balance += amount;
    }

    // 'throws' declares the checked exception in the method signature
    public void withdraw(double amount) throws InsufficientFundsException {
        if (amount <= 0) {
            throw new InvalidAmountException(amount);
        }
        if (amount > balance) {
            throw new InsufficientFundsException(balance, amount);
        }
        balance -= amount;                               // state changes only on success
    }

    // Fails predictably: both accounts stay unchanged if the withdrawal fails
    public void transferTo(BankAccount target, double amount) throws InsufficientFundsException {
        this.withdraw(amount);
        target.deposit(amount);
    }

    @Override
    public String toString() {
        return owner + ": $" + String.format("%.2f", balance);
    }
}
