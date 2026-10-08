public class Car {  // Car HAS-A Engine (composition), not IS-A
    private final Engine engine = new Engine();
    private final String model;

    public Car(String model) { this.model = model; }

    public void drive() {
        engine.start();  // delegate the work to the part
        System.out.println(model + " is driving");
    }

    public void park() {
        engine.stop();
        System.out.println(model + " is parked");
    }
}
