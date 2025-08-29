public class MarkCommand extends Command{

    public MarkCommand(String command, String... args) {
        super(command, args);
    }

    @Override
    public void execute(TaskList taskList, Ui ui, Storage storage) {
        int taskId = Integer.parseInt(args[0]);
        Task markedTask = taskList.get(taskId).markAsDone();
        ui.showMarkedTask(markedTask);
    }
}
