package duke.task;

public class Task {
    protected String description;
    protected boolean isCompleted;

    public Task(String name) {
        this.description = name;
        this.isCompleted = false;
    }

    public String getStatus() {
        return isCompleted ? "X" : " ";
    }

    public void markAsCompleted() {
        isCompleted = true;
    }

    public void markAsNotCompleted() {
        isCompleted = false;
    }

    public String getDescription() {
        return this.description;
    }

    @Override
    public String toString() {
        return "[" + this.getStatus() + "] "
                + this.description;
    }
}
