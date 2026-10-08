public class Rectangle {
    private static int created = 0;
    double width;
    double height;

    Rectangle() {  // default 1 x 1
        this(1, 1);
    }

    Rectangle(double side) {  // a square
        this(side, side);
    }

    Rectangle(double width, double height) {
        this.width = width;
        this.height = height;
        created++;
    }

    double area() { return width * height; }

    static int getCreated() { return created; }
}
