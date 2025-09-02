package chani.commands;

import chani.Storage;
import chani.tasks.Task;
import chani.TaskList;
import chani.Ui;

/**
 * Represents a command that deletes a {@link Task} from the {@link TaskList}.
 * <p>
 * The {@code DeleteCommand} removes a task specified by its task ID
 * from the task list and notifies the user via the {@link Ui}.
 * </p>
 */
public class DeleteCommand extends Command {

    /**
     * Constructs a {@code DeleteCommand}.
     *
     * @param command the command keyword (e.g., "delete")
     * @param args arguments for the command, where the first argument is expected
     *             to be the task ID (index in the task list)
     */
    public DeleteCommand(String command, String... args) {
        super(command, args);
    }

    /**
     * Executes the delete command by removing the specified task from the task list
     * and displaying confirmation to the user.
     *
     * @param taskList the task list from which the task will be removed
     * @param ui the user interface for displaying feedback
     * @param storage the storage handler (not used directly in this command)
     */
    @Override
    public void execute(TaskList taskList, Ui ui, Storage storage) {
        int taskId = Integer.parseInt(args[0]);
        Task toDelete = taskList.get(taskId);
        taskList.remove(toDelete);
        ui.showDeletedTask(toDelete, taskList.size());
    }
}
