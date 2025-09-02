package chani.tasks;

public class EventTask extends Task {
    protected String start;
    protected String end;


    public EventTask(String description, String start, String end) {
        super(description);
        this.start = start;
        this.end = end;
    }

    @Override
    public String toStorageString() {
        return
    }

    @Override
    public String toString() {
        return "[E]" + super.toString() + " (from: " + start + " (to: " + end + ")";
    }
}
