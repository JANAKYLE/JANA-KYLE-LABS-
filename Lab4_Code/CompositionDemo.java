public class CompositionDemo {
    public static void main(String[] args) {
        Car car = new Car("Toyota");
        car.drive();
        car.park();

        Library lib = new Library();
        lib.add("Java Basics");
        lib.add("Data Structures");
        System.out.println("Library holds " + lib.size() + " books: " + lib.titles());
    }
}
