public class TaskNotFoundException extends Exception {
    public TaskNotFoundException(int id) {
        super("No task with id " + id);
    }
}
