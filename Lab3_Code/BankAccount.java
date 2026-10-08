public class BankAccount {
    private final String accountNumber;  // final: can never change after construction
    private String holder;
    private double balance;

    public BankAccount(String accountNumber, String holder, double openingBalance) {
        if (accountNumber == null || accountNumber.isBlank()) {
            throw new IllegalArgumentException("Account number is required");
        }
        this.accountNumber = accountNumber;
        setHolder(holder);  // reuse the setter so validation lives in ONE place
        if (openingBalance < 0) {
            throw new IllegalArgumentException("Opening balance cannot be negative");
        }
        this.balance = openingBalance;
    }

    // ---- getters (controlled read access) ----
    public String getAccountNumber() { return accountNumber; }
    public String getHolder()        { return holder; }
    public double getBalance()       { return balance; }

    // ---- setter with validation ----
    public void setHolder(String holder) {
        if (holder == null || holder.isBlank()) {
            throw new IllegalArgumentException("Holder name cannot be empty");
        }
        this.holder = holder;
    }

    // ---- no setBalance(): the balance changes ONLY through these methods ----
    public void deposit(double amount) {
        if (amount <= 0) {
            throw new IllegalArgumentException("Deposit must be greater than 0");
        }
        balance += amount;
    }

    public void withdraw(double amount) {
        if (amount <= 0) {
            throw new IllegalArgumentException("Withdrawal must be greater than 0");
        }
        if (amount > balance) {
            throw new IllegalArgumentException("Insufficient funds");
        }
        balance -= amount;
    }
}
