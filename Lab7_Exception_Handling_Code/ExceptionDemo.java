public class ExceptionDemo {
    public static void main(String[] args) {

        System.out.println("=== Part A: Unchecked exceptions from the JVM ===");
        try {
            int[] data = new int[3];
            data[5] = 1;
        } catch (ArrayIndexOutOfBoundsException e) {
            System.out.println("Caught: " + e.getMessage());
        }
        try {
            String s = null;
            s.length();
        } catch (NullPointerException e) {
            System.out.println("Caught NullPointerException");
        }
        try {
            Integer.parseInt("abc");
        } catch (NumberFormatException e) {
            System.out.println("Caught: " + e.getMessage());
        }

        System.out.println("\n=== Part B: Custom checked exception ===");
        BankAccount acc = new BankAccount("Kyle", 100);
        try {
            acc.withdraw(30);
            System.out.println("After withdraw(30): " + acc);
            acc.withdraw(500);
            System.out.println("This line is never reached");
        } catch (InsufficientFundsException e) {
            System.out.println("Caught: " + e.getMessage());
            System.out.printf("Shortfall = %.2f%n", e.getShortfall());
        }

        System.out.println("\n=== Part C: Custom unchecked exception ===");
        try {
            acc.deposit(-10);
        } catch (InvalidAmountException e) {
            System.out.println("Caught: " + e.getMessage());
        }

        System.out.println("\n=== Part D: try / catch / finally ===");
        try {
            System.out.println("Trying a risky operation...");
            acc.withdraw(1000);
        } catch (InsufficientFundsException e) {
            System.out.println("catch block ran");
        } finally {
            System.out.println("finally block ALWAYS runs");
        }

        System.out.println("\n=== Part E: Multi-catch ===");
        String[] inputs = {"50", "abc", "-5"};
        for (String in : inputs) {
            try {
                double amt = Double.parseDouble(in);
                acc.deposit(amt);
                System.out.println("Deposited " + in + " -> " + acc);
            } catch (NumberFormatException | InvalidAmountException e) {
                System.out.println("Rejected \"" + in + "\": " + e.getMessage());
            }
        }

        System.out.println("\n=== Part F: try-with-resources ===");
        try (AuditLog log = new AuditLog("audit")) {
            log.write("Starting transfer");
            BankAccount other = new BankAccount("Tendai", 0);
            acc.transferTo(other, 20);
            log.write("Transfer complete: " + acc + " | " + other);
            acc.transferTo(other, 9999);          // fails; log still gets closed
            log.write("Not reached");
        } catch (InsufficientFundsException e) {
            System.out.println("Transfer failed: " + e.getMessage());
        }
        System.out.println("Final state: " + acc);
    }
}
