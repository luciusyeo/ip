package chani;

import chani.commands.AddCommand;
import chani.commands.Command;
import chani.commands.DeleteCommand;
import chani.commands.ExitCommand;
import chani.commands.FindCommand;
import chani.commands.ListCommand;
import chani.commands.MarkCommand;
import chani.commands.UnMarkCommand;

/**
 * Parses user input strings into {@link Command} objects.
 */
public class Parser {

    /**
     * Parses the input string and returns the corresponding {@link Command}.
     * @param input The user input string.
     * @return The {@link Command} object representing the input.
     * @throws ChaniException if the input is invalid or the command is unknown.
     */
    public static Command parse(String input) throws ChaniException {
        String[] commandArgs = input.split(" ", 2);
        String command = commandArgs[0];

        switch (command) {
        case "list":
            // list
            return new ListCommand(command);
        case "bye":
            // bye
            return new ExitCommand(command);
        case "mark": {
            // mark <task_id>
            validateSplit(commandArgs, "mark <task_id>");
            String taskId = commandArgs[1];
            return new MarkCommand(command, taskId);
        }
        case "unmark": {
            // unmark <task_id>
            validateSplit(commandArgs, "unmark <task_id>");
            String taskId = commandArgs[1];
            return new UnMarkCommand(command, taskId);
        }
        case "delete":
            // delete <task_id>
            validateSplit(commandArgs, "delete <task_id>");
            String taskId = commandArgs[1];
            return new DeleteCommand(command, taskId);
        case "find": {
            validateSplit(commandArgs, "find <query>");
            String query = commandArgs[1];
            return new FindCommand(command, query);
        }
        case "todo": {
            //t.o.d.o <description>
            validateSplit(commandArgs, "todo <desc>");

            String desc = commandArgs[1];
            return new AddCommand(command, desc);
        }
        case "deadline": {
            //deadline <desc> /by <date>
            validateSplit(commandArgs, "deadline <desc> /by <yyyy-mm-dd>");

            String[] descDate = commandArgs[1].split(" /by ", 2);
            validateSplit(descDate, "deadline <desc> /by <yyyy-mm-dd>");

            return new AddCommand(command, descDate);
        }
        case "event": {
            //event <desc> /from /to
            validateSplit(commandArgs, "event <desc> /from /to");

            String[] descFromTo = commandArgs[1].split(" /from ", 2);
            validateSplit(descFromTo, "event <desc> /from /to");

            String[] fromTo = descFromTo[1].split(" /to ", 2);
            validateSplit(fromTo, "event <desc> /from /to");

            String desc = descFromTo[0];
            String from = fromTo[0];
            String to = fromTo[1];

            return new AddCommand(command, desc, from, to);
        }
        default:
            throw new ChaniException("OOPS!!! I'm sorry, but I don't know what that command means :-(");
        }

    }

    /**
     * Checks that the input array has at least two elements.
     * @param input The array to check.
     * @param message The message to include in the exception if invalid.
     * @throws ChaniException if the input array has less than 2 elements.
     */
    private static void validateSplit(String[] input, String message) throws ChaniException {
        if (input.length < 2) {
            throw new ChaniException("Invalid Command: Use " + message + " instead");
        }
    }
}
