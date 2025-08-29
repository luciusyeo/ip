package chani;

public class EventTaskFactory implements TaskFactory {
    @Override
    public Task create(String... args) {
        if (args.length < 3) {
            throw new IllegalArgumentException("chani.EventTask requires description, start date and end date");
        }
        String description = args[0];
        String startDate = args[1];
        String endDate = args[2];
        return new EventTask(description, startDate, endDate);
    }

}
