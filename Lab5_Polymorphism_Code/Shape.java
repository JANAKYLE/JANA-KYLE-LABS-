public abstract class Shape {
    private final String name;

    public Shape(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    // Overridden by every subclass: the version that runs is chosen at run time
    public abstract double area();

    public double perimeter() {
        return 0;
    }

    public String describe() {
        return String.format("%s | area = %.2f | perimeter = %.2f", name, area(), perimeter());
    }
}
