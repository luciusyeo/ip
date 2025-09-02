package chani.tasks;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.List;

//TODO: Catch this.by DateTime errors

public class DeadlineTask extends Task{
    protected LocalDate by;

    public DeadlineTask(String description, String by) {
        super(description,"D");
        this.by = LocalDate.parse(by);
    }

    @Override
    public List<String> toStringList() {
        List<String> list = super.toStringList();
        list.add(by.toString());
        return list;
    }

    @Override
    public String toString() {
        return "[D]" + super.toString() + " (by: " + by.format(DateTimeFormatter.ofPattern("MMM d yyyy")) + ")";
    }
}
