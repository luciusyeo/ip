package chani;

public class Parser {

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
                String task_id = commandArgs[1];
                return new MarkCommand(command, task_id);
            }
            case "unmark": {
                // unmark <task_id>
                validateSplit(commandArgs, "unmark <task_id>");
                String task_id = commandArgs[1];
                return new UnMarkCommand(command, task_id);
            }
            case "delete":
                // delete <task_id>
                validateSplit(commandArgs, "delete <task_id>");
                String task_id = commandArgs[1];
                return new DeleteCommand(command, task_id);
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

    private static void validateSplit(String[] input, String message) throws ChaniException{
        if (input.length < 2) {
            throw new ChaniException("Invalid chani.Command: Use " + message + " instead");
        }
    }
}