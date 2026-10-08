public class RectangleDemo {
    public static void main(String[] args) {
        Rectangle r1 = new Rectangle();
        r1.width = 5;
        r1.height = 3;
        System.out.println("Area      = " + r1.area());
        System.out.println("Perimeter = " + r1.perimeter());

        Rectangle r2 = r1;                   // same object
        r2.width = 10;
        System.out.println("r1 area after r2.width = 10: " + r1.area());
    }
}
