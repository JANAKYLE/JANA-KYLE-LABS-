public class ThisDemo {
    public static void main(String[] args) {
        // 1. Without 'this' the parameters hide the fields
        BrokenPoint bp = new BrokenPoint(3, 4);
        System.out.println("BrokenPoint: " + bp.x + ", " + bp.y);  // 0, 0 (bug)

        // 2. With 'this' the fields are set correctly
        Point p = new Point(3, 4);
        System.out.println("Point      : " + p.x + ", " + p.y);  // 3, 4

        // 3. Returning 'this' allows method chaining
        Counter c = new Counter();
        c.increment().increment().increment();
        System.out.println("Counter    : " + c.value);  // 3
    }
}

class BrokenPoint {
    int x, y;
    BrokenPoint(int x, int y) {
        x = x;  // assigns the parameter to itself!
        y = y;
    }
}

class Point {
    int x, y;
    Point(int x, int y) {
        this.x = x;  // field = parameter
        this.y = y;
    }
}

class Counter {
    int value;
    Counter increment() {
        value++;
        return this;  // return the current object
    }
}
