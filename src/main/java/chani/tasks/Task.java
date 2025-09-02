package chani.tasks;

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

    public String getDescription() {
        return description;
    }

    public boolean isDone() {
        return isDone;
    }

    abstract String toStorageString();

    @Override
    public String toString() {
        return (isDone ? "[X]" : "[ ]") + " " + description;
    }

}
