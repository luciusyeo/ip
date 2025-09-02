package chani.commands;

import chani.Storage;
import chani.tasks.Task;
import chani.TaskList;
import chani.Ui;

import java.util.List;

/**
 * Represents a command that searches for tasks in the task list
 * based on a given query string.
 * <p>
 * The {@code FindCommand} filters tasks whose string representation
 * contains the query and displays them through the {@link Ui}.
 * </p>
 */
public class FindCommand extends Command {


    /**
     * Constructs a {@code FindCommand} with the given command keyword
     * and arguments.
     *
     * @param command the command word ("find")
     * @param args    the arguments provided by the user; expects a single query string
     */
    public FindCommand(String command, String... args) {
        super(command, args);
    }

    /**
     * Executes the find operation by searching for tasks in the {@link TaskList}
     * that match the query string. The results are formatted into a numbered list
     * and displayed using the {@link Ui}.
     *
     * @param taskList the task list to search within
     * @param ui       the user interface to display messages
     * @param storage  the storage used by the bot (not modified in this command)
     */
    @Override
    public void execute(TaskList taskList, Ui ui, Storage storage) {
        StringBuilder taskMessage = new StringBuilder();
        List<Task> queries = taskList.find(args[0]);

        for (int i = 1; i <= queries.size(); i ++) {
            taskMessage.append(String.format("%d. %s\n", i, queries.get(i-1)));
        }
        ui.showQueriedTasks(taskMessage.toString());
    }
}
