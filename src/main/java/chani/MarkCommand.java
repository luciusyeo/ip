package chani;

/**
 * Represents a command that marks a {@link Task} in the {@link TaskList} as done.
 * <p>
 * The {@code MarkCommand} identifies the task by its ID, updates its status,
 * and notifies the user through the {@link Ui}.
 * </p>
 */
public class MarkCommand extends Command {

    /**
     * Constructs a {@code MarkCommand}.
     *
     * @param command the command keyword (e.g., "mark")
     * @param args arguments for the command, where the first argument is expected
     *             to be the task ID (index in the task list)
     */
    public MarkCommand(String command, String... args) {
        super(command, args);
    }

    /**
     * Executes the mark command by marking the specified task as done
     * and displaying confirmation to the user.
     *
     * @param taskList the task list containing the task to be marked
     * @param ui the user interface for showing feedback
     * @param storage the storage handler (not used directly in this command)
     * @throws NumberFormatException if the provided task ID is not a valid integer
     * @throws IndexOutOfBoundsException if the provided task ID does not exist in the task list
     */
    @Override
    public void execute(TaskList taskList, Ui ui, Storage storage) {
        int taskId = Integer.parseInt(args[0]);
        Task markedTask = taskList.get(taskId).markAsDone();
        ui.showMarkedTask(markedTask);
    }
}
