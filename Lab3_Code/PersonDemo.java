public class PersonDemo {
    public static void main(String[] args) {
        Person p = new Person("Rudo", 20);
        p.birthday();
        System.out.println(p.getName() + " is " + p.getAge());  // 21

        try { p.setAge(-5); }
        catch (IllegalArgumentException e) {
            System.out.println("Rejected: " + e.getMessage());
        }

        System.out.println("Age is still " + p.getAge());  // 21
    }
}
