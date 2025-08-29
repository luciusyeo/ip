package chani;

/**
 * Represents a command that marks a {@link Task} in the {@link TaskList} as not done.
 * <p>
 * The {@code UnMarkCommand} identifies the task by its ID, updates its status,
 * and notifies the user through the {@link Ui}.
 * </p>
 */
public class UnMarkCommand extends Command {

    /**
     * Constructs an {@code UnMarkCommand}.
     *
     * @param command the command keyword (e.g., "unmark")
     * @param args arguments for the command, where the first argument is expected
     *             to be the task ID (index in the task list)
     */
    public UnMarkCommand(String command, String... args) {
        super(command, args);
    }

    /**
     * Executes the unmark command by marking the specified task as not done
     * and displaying confirmation to the user.
     *
     * @param taskList the task list containing the task to be unmarked
     * @param ui the user interface for showing feedback
     * @param storage the storage handler (not used directly in this command)
     */
    @Override
    public void execute(TaskList taskList, Ui ui, Storage storage) {
        int taskId = Integer.parseInt(args[0]);
        Task task = taskList.get(taskId).markAsUnDone();
        ui.showUnmarkedTask(task);
    }
}
