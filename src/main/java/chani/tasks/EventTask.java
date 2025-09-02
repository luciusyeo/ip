package chani.tasks;

import java.util.List;

public class EventTask extends Task {
    protected String start;
    protected String end;


    public EventTask(String description, String start, String end) {
        super(description, "E");
        this.start = start;
        this.end = end;
    }

    @Override
    public List<String> toStringList() {
        List<String> list = super.toStringList();
        list.add(start);
        list.add(end);
        return list;
    }

    @Override
    public String toString() {
        return "[E]" + super.toString() + " (from: " + start + " (to: " + end + ")";
    }
}
