package chani;

/**
 * Represents a command that exits the Chani application.
 * <p>
 * The {@code ExitCommand} displays a goodbye message through the {@link Ui}
 * and signals the application to terminate by setting the {@code exit} flag.
 * </p>
 */
public class ExitCommand extends Command {

    /**
     * Constructs an {@code ExitCommand}.
     *
     * @param command the command keyword (e.g., "bye")
     * @param args optional arguments (not used for this command)
     */
    public ExitCommand(String command, String... args) {
        super(command, args);
    }

    /**
     * Executes the exit command by displaying a goodbye message
     * and setting the exit flag to {@code true}.
     *
     * @param taskList the task list (not used in this command)
     * @param ui the user interface for displaying the goodbye message
     * @param storage the storage handler (not used in this command)
     */
    @Override
    public void execute(TaskList taskList, Ui ui, Storage storage) {
        ui.showGoodbye();
        this.exit = true;
    }
}
