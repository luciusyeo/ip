package chani.commands;

import chani.*;
import chani.tasks.Task;
import chani.tasks.TaskRegistry;

/**
 * Represents a command that adds a new {@link Task} to the {@link TaskList}.
 * <p>
 * The {@code AddCommand} creates a new task using the {@link TaskRegistry},
 * adds it to the task list, and informs the user through the {@link Ui}.
 * </p>
 */
public class AddCommand extends Command {

    /**
     * Constructs an {@code AddCommand}.
     *
     * @param command the command keyword (e.g., "todo", "deadline", "event")
     * @param args arguments required to construct the task (e.g., description, dates)
     */
    public AddCommand(String command, String... args) {
        super(command, args);
    }

    /**
     * Executes the add command by creating a new task, adding it to the task list,
     * and displaying the result to the user.
     *
     * @param taskList the task list to which the task will be added
     * @param ui the user interface for displaying feedback
     * @param storage the storage handler (not used directly in this command)
     */
    @Override
    public void execute(TaskList taskList, Ui ui, Storage storage) {
        Task task = TaskRegistry.createTask(command, args);
        taskList.add(task);
        ui.showAddedTask(task, taskList.size());
    }
}
