package chani.commands;

import chani.Storage;
import chani.TaskList;
import chani.Ui;

/**
 * Represents a command that lists all tasks in the {@link TaskList}.
 * <p>
 * The {@code ListCommand} generates a numbered list of tasks and
 * displays it through the {@link Ui}.
 * </p>
 */
public class ListCommand extends Command {

    /**
     * Constructs a {@code ListCommand}.
     *
     * @param command the command keyword (e.g., "list")
     * @param args optional arguments (not used for this command)
     */
    public ListCommand(String command, String... args) {
        super(command, args);
    }

    /**
     * Executes the list command by retrieving all tasks from the task list,
     * formatting them into a numbered list, and displaying the result.
     *
     * @param taskList the task list containing tasks to be displayed
     * @param ui the user interface for showing the list of tasks
     * @param storage the storage handler (not used in this command)
     */
    @Override
    public void execute(TaskList taskList, Ui ui, Storage storage) {
        StringBuilder taskMessage = new StringBuilder();
        for (int i = 1; i <= taskList.size(); i++) {
            taskMessage.append(String.format("%d. %s\n", i, taskList.get(i)));
        }
        ui.showList(taskMessage.toString());
    }
}
