public class InheritanceDemo {
    public static void main(String[] args) {
        Employee[] staff = {
            new Manager("Tendai", 2000, 500),
            new Developer("Rudo", 1800, 10),
            new Contractor("Farai", 1500)
        };

        System.out.println("--- payroll ---");
        for (Employee e : staff) {
            System.out.println(e);  // toString() + overridden calculatePay()
        }
        System.out.println(staff[0].companyName());  // inherited final method
    }
}
