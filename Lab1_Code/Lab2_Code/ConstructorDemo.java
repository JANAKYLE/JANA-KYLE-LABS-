public class ConstructorDemo {
    public static void main(String[] args) {
        System.out.println("--- new Person() ---");
        Person p1 = new Person();

        System.out.println("--- new Person(\"Tendai\") ---");
        Person p2 = new Person("Tendai");

        System.out.println("--- new Person(\"Rudo\", 20) ---");
        Person p3 = new Person("Rudo", 20);

        System.out.println("--- results ---");
        p1.display();
        p2.display();
        p3.display();
        System.out.println("Objects created: " + Person.getCount());
    }
}
