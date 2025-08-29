package chani;

public class UnMarkCommand extends Command{

    public UnMarkCommand(String command, String... args) {
        super(command, args);
    }

    @Override
    public void execute(TaskList taskList, Ui ui, Storage storage) {
        int taskId = Integer.parseInt(args[0]);
        Task task = taskList.get(taskId).markAsUnDone();
        ui.showUnmarkedTask(task);
    }
}
