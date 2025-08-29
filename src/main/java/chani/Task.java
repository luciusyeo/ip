package chani;

abstract public class Task {
    protected String description;
    protected boolean isDone;

    public Task(String description) {
        this.description = description;
        this.isDone = false;
    }

    public Task markAsDone() {
        this.isDone = true;
        return this;
    }

    public Task markAsUnDone() {
        this.isDone = false;
        return this;
    }

    @Override
    public String toString() {
        return (isDone ? "[X]" : "[ ]") + " " + description; // mark done task with X
    }

    public String getDescription() {
        return description;
    }

    public boolean isDone() {
        return isDone;
    }
}
