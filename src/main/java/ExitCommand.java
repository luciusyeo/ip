public class ExitCommand extends Command{

    public ExitCommand(String command, String... args) {
        super(command, args);
    }

    @Override
    public void execute(TaskList taskList, Ui ui, Storage storage) {
        ui.showGoodbye();
        this.exit = true;
    }
}