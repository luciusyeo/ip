public class ListCommand extends Command{

    public ListCommand(String command, String... args) {
        super(command, args);
    }

    @Override
    public void execute(TaskList taskList, Ui ui, Storage storage) {
        StringBuilder taskMessage = new StringBuilder();
        for (int i = 1; i <= taskList.size(); i ++) {
            taskMessage.append(String.format("%d. %s\n", i, taskList.get(i)));
        }
        ui.showList(taskMessage.toString());
    }
}
