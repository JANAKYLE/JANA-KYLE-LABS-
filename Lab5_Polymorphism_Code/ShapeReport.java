import java.util.List;

// Works with ANY Shape, including subclasses that do not exist yet
public class ShapeReport {
    public static double totalArea(List<Shape> shapes) {
        double total = 0;
        for (Shape s : shapes) {
            total += s.area();      // dynamic method dispatch
        }
        return total;
    }

    public static void print(List<Shape> shapes) {
        for (Shape s : shapes) {
            System.out.println("  " + s.describe());
        }
    }
}
