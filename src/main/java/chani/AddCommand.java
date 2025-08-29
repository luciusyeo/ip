package chani;

public class AddCommand extends Command{

    public AddCommand(String command, String... args) {
        super(command, args);
    }

    @Override
    public void execute(TaskList taskList, Ui ui, Storage storage){
        Task task = TaskRegistry.createTask(command, args);
        taskList.add(task);
        ui.showAddedTask(task, taskList.size());
    }
}
