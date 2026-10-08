public class Shape {
    protected String name;

    public Shape(String name) { this.name = name; }

    public double area() { return 0; }

    @Override
    public String toString() { return name + " area=" + String.format("%.2f", area()); }
}
