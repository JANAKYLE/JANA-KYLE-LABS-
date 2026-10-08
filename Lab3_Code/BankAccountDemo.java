public class BankAccountDemo {
    public static void main(String[] args) {
        BankAccount acc = new BankAccount("ACC-001", "Tendai", 100);
        acc.deposit(50);
        acc.withdraw(30);
        // prints: Tendai balance = 120.0
        System.out.println(acc.getHolder() + " balance = " + acc.getBalance());

        // Every attempt below is rejected and the object stays valid
        try { acc.withdraw(500); }
        catch (IllegalArgumentException e) {
            System.out.println("Rejected: " + e.getMessage());
        }

        try { acc.deposit(-10); }
        catch (IllegalArgumentException e) {
            System.out.println("Rejected: " + e.getMessage());
        }

        try { acc.setHolder("  "); }
        catch (IllegalArgumentException e) {
            System.out.println("Rejected: " + e.getMessage());
        }

        try { new BankAccount("ACC-002", "Rudo", -5); }
        catch (IllegalArgumentException e) {
            System.out.println("Rejected: " + e.getMessage());
        }

        System.out.println("Final balance = " + acc.getBalance());  // still 120.0
    }
}
