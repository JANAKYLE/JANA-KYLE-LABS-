import java.util.ArrayList;
import java.util.List;

public class PolymorphismDemo {
    public static void main(String[] args) {

        System.out.println("=== Part A: Overloading (compile-time) ===");
        Calculator calc = new Calculator();
        System.out.println("add(2, 3)        -> " + calc.add(2, 3));
        System.out.println("add(2.5, 3.5)    -> " + calc.add(2.5, 3.5));
        System.out.println("add(1, 2, 3)     -> " + calc.add(1, 2, 3));
        System.out.println("add(\"Hi\", \"!\")   -> " + calc.add("Hi", "!"));

        System.out.println("\n=== Part B: Upcasting and dynamic dispatch ===");
        Shape s1 = new Circle(5);              // Circle object, Shape reference
        Shape s2 = new Rectangle(4, 6);
        Shape s3 = new Triangle(3, 4, 5);
        System.out.println("s1 is declared as Shape but behaves as: " + s1.getName());
        System.out.println(s1.describe());
        System.out.println(s2.describe());
        System.out.println(s3.describe());

        System.out.println("\n=== Part C: Safe downcasting ===");
        List<Shape> shapes = new ArrayList<>();
        shapes.add(s1);
        shapes.add(s2);
        shapes.add(s3);

        for (Shape s : shapes) {
            if (s instanceof Circle c) {                       // pattern matching
                System.out.println("Circle with radius " + c.getRadius());
            } else if (s instanceof Rectangle) {
                System.out.println("A rectangle (no pattern variable needed)");
            } else {
                System.out.println("Some other shape: " + s.getName());
            }
        }

        // Unsafe downcast: compiles, but fails at run time
        try {
            Circle bad = (Circle) s2;
            System.out.println(bad.getRadius());
        } catch (ClassCastException e) {
            System.out.println("ClassCastException caught: Rectangle is not a Circle");
        }

        System.out.println("\n=== Part D: Open/closed principle ===");
        System.out.println("Before adding Hexagon:");
        ShapeReport.print(shapes);
        System.out.printf("  Total area = %.2f%n", ShapeReport.totalArea(shapes));

        shapes.add(new Hexagon(2));            // ShapeReport is NOT modified
        System.out.println("After adding Hexagon:");
        ShapeReport.print(shapes);
        System.out.printf("  Total area = %.2f%n", ShapeReport.totalArea(shapes));
    }
}
