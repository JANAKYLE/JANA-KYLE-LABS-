public class RectangleDemo {
    public static void main(String[] args) {
        Rectangle r1 = new Rectangle();
        Rectangle r2 = new Rectangle(4);
        Rectangle r3 = new Rectangle(5, 3);

        System.out.println("r1 area = " + r1.area());
        System.out.println("r2 area = " + r2.area());
        System.out.println("r3 area = " + r3.area());
        System.out.println("Rectangles created = " + Rectangle.getCreated());
    }
}
