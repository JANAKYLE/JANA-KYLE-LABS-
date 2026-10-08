public class Engine {
    private boolean running;

    public void start() { running = true;  System.out.println("Engine started"); }
    public void stop()  { running = false; System.out.println("Engine stopped"); }
    public boolean isRunning() { return running; }
}
