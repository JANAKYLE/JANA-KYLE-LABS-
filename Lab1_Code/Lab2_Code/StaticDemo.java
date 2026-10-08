public class StaticDemo {
    public static void main(String[] args) {
        // call via class name
        System.out.println("Issued before: " + Ticket.getTotalIssued());

        Ticket t1 = new Ticket("Tendai");
        Ticket t2 = new Ticket("Rudo");
        Ticket t3 = new Ticket("Farai");

        // instance members: via object
        System.out.println(t1.getId() + " " + t1.getPassenger());
        System.out.println(t2.getId() + " " + t2.getPassenger());
        System.out.println(t3.getId() + " " + t3.getPassenger());
        System.out.println("Issued after : " + Ticket.getTotalIssued());
    }
}
