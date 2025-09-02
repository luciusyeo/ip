package chani.tasks;

import java.util.ArrayList;
import java.util.List;

abstract public class Task {
    protected String identifier;
    protected String description;
    protected boolean isDone;

    public Task(String description, String identifier) {
        this.identifier = identifier;
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

    public List<String> toStringList() {
        String done = isDone() ? "1" : "0";
        return new ArrayList<>(List.of(identifier, done, description));
    }

    @Override
    public String toString() {
        return (isDone ? "[X]" : "[ ]") + " " + description;
    }

}
