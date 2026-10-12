import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class AbstractionDemo {
    public static void main(String[] args) {

        System.out.println("=== Part A: Abstract classes cannot be instantiated ===");
        // Employee e = new Employee("X", 0);   // COMPILE ERROR: Employee is abstract
        System.out.println("Employee is abstract, so 'new Employee(...)' will not compile.");

        System.out.println("\n=== Part B: Polymorphism through the abstract type ===");
        List<Employee> staff = new ArrayList<>();
        staff.add(new FullTimeEmployee("Tariro", 1, 1800));
        staff.add(new ContractEmployee("Farai", 2, 12.5, 90));
        staff.add(new FullTimeEmployee("Nyasha", 3, 950));
        staff.add(new ContractEmployee("Chipo", 4, 20, 40));
        for (Employee e : staff) {
            System.out.println(e);
        }

        System.out.println("\n=== Part C: Interface static method ===");
        System.out.printf("Total payroll = $%.2f%n", Payable.totalPay(staff));

        System.out.println("\n=== Part D: Comparable (natural ordering) ===");
        Collections.sort(staff);                 // uses Employee.compareTo
        for (Employee e : staff) {
            System.out.println(e);
        }

        System.out.println("\n=== Part E: Program to an interface ===");
        Notifier email = new EmailNotifier();
        new PayrollService(email).run(staff);

        Notifier sms = new SmsNotifier();        // swap implementation, no other change
        new PayrollService(sms).run(staff.subList(0, 2));

        Notifier custom = (to, msg) -> System.out.println("[LOG] " + to + " -> " + msg);
        new PayrollService(custom).run(staff.subList(0, 1));
    }
}
