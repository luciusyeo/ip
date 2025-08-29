package chani;

public class DeleteCommand extends Command{

    public DeleteCommand(String command, String... args) {
        super(command, args);
    }

    @Override
    public void execute(TaskList taskList, Ui ui, Storage storage) {
        int taskId = Integer.parseInt(args[0]);
        Task toDelete = taskList.get(taskId);
        taskList.remove(toDelete);
        ui.showDeletedTask(toDelete, taskList.size());
    }
}
