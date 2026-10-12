// Added LAST: no existing class needs to change (open/closed principle)
public class Hexagon extends Shape {
    private final double side;

    public Hexagon(double side) {
        super("Hexagon");
        this.side = side;
    }

    @Override
    public double area() {
        return 3 * Math.sqrt(3) / 2 * side * side;
    }

    @Override
    public double perimeter() {
        return 6 * side;
    }
}
