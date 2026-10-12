public class Task {
    private final int id;
    private final String title;
    private final Priority priority;
    private boolean done;

    public Task(int id, String title, Priority priority, boolean done) {
        this.id = id;
        this.title = title;
        this.priority = priority;
        this.done = done;
    }

    public int getId() { return id; }
    public String getTitle() { return title; }
    public Priority getPriority() { return priority; }
    public boolean isDone() { return done; }

    public void markDone() {
        done = true;
    }

    public String toCsv() {
        return id + "," + title + "," + priority + "," + done;
    }

    public static Task fromCsv(String line) {
        String[] f = line.split(",");
        if (f.length != 4) {
            throw new IllegalArgumentException("bad task line: " + line);
        }
        return new Task(Integer.parseInt(f[0]), f[1], Priority.valueOf(f[2]),
                Boolean.parseBoolean(f[3]));
    }

    @Override
    public String toString() {
        return String.format("#%d [%s] %-18s %s", id, done ? "x" : " ", title, priority);
    }
}
