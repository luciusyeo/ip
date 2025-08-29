package chani;

abstract public class Command {
    protected boolean exit;
    protected String command;
    protected String[] args;

    public Command(String command, String... args) {
        this.exit = false;
        this.command = command;
        this.args = args;
    }

    public abstract void execute(TaskList taskList, Ui ui, Storage storage);

    public boolean isExit() {
        return exit;
    }


}
