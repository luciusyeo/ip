package chani;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

//TODO: Catch this.by DateTime errors

public class DeadlineTask extends Task{
    protected LocalDate by;

    public DeadlineTask(String description, String by) {
        super(description);
            this.by = LocalDate.parse(by);
    }

    @Override
    public String toString() {
        return "[D]" + super.toString() + " (by: " + by.format(DateTimeFormatter.ofPattern("MMM d yyyy")) + ")";
    }
}
