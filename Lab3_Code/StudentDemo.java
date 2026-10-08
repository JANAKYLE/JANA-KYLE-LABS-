public class StudentDemo {
    public static void main(String[] args) {
        Student s = new Student("Tendai", 67);
        System.out.println(s.getName() + " " + s.getMark() + " " + s.getGrade());

        s.setMark(82);
        System.out.println(s.getName() + " " + s.getMark() + " " + s.getGrade());

        try {
            s.setMark(150);  // invalid: rejected
        } catch (IllegalArgumentException e) {
            System.out.println("Rejected: " + e.getMessage());
        }
        System.out.println("Mark is still " + s.getMark());

        try {
            new Student("", 50);  // invalid: object is never created
        } catch (IllegalArgumentException e) {
            System.out.println("Rejected: " + e.getMessage());
        }
    }
}
