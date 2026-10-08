public class ShapeDemo {
    public static void main(String[] args) {
        Shape[] shapes = {
            new Circle(2), new RectangleShape(4, 5), new Shape("Generic")
        };
        for (Shape s : shapes) {
            System.out.println(s);  // each object runs ITS OWN area()
        }
    }
}
