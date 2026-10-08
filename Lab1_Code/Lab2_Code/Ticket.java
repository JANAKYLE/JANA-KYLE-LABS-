public class Ticket {
    private static int nextId = 1;  // static: one copy, shared
    private static int totalIssued = 0;

    private final int id;  // instance: each ticket has its own id
    private final String passenger;

    Ticket(String passenger) {
        this.id = nextId++;
        this.passenger = passenger;
        totalIssued++;
    }

    int getId()               { return id; }
    String getPassenger()     { return passenger; }
    static int getTotalIssued() { return totalIssued; }  // static method

    // static int broken() { return id; }
    // ERROR: non-static variable id cannot be referenced from a static context
}
