public class RectangleShape extends Shape {
    private double width, height;

    public RectangleShape(double width, double height) {
        super("Rectangle");
        this.width = width;
        this.height = height;
    }

    @Override
    public double area() { return width * height; }
}
