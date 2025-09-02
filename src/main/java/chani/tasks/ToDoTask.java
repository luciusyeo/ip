package chani.tasks;

import java.util.List;

public class ToDoTask extends Task{
    public ToDoTask(String description) {
        super(description, "T");
    }

    @Override
    public List<String> toStringList() {
        return super.toStringList();
    }

    @Override
    public String toString() {
        return "[T]" + super.toString(); // mark done task with X
    }

}
