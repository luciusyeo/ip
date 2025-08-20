import java.util.Scanner;
import java.util.ArrayList;

public class Chani {
    public static void main(String[] args) {
        final String BOT_NAME = "Chani";
        Scanner scanner = new Scanner(System.in);

        ArrayList<Task> tasks = new ArrayList<>();

        String greeting = String.format("Hello! I'm %s\nWhat can I do for you?", BOT_NAME);
        System.out.println(greeting);

        while (true) {
            String input = scanner.nextLine();
            String[] commandRest = input.split(" ", 2);
            String command = commandRest[0];

            switch(command) {
                case "list":
                    for (int i = 0; i < tasks.size(); i ++) {
                        int numbering = i + 1;
                        System.out.println(numbering + ". " + tasks.get(i));
                    }
                    break;
                case "bye":
                    System.out.println("Bye. Hope to see you again soon!");
                    return;
                case "mark": {
                    int taskId = Integer.parseInt(commandRest[1]);
                    Task taskToMark = tasks.get(taskId - 1);
                    taskToMark.markAsDone();
                    System.out.println("Nice! I've marked this task as done:");
                    System.out.println("    " + taskToMark);
                    break;
                } case "unmark": {
                    int taskId = Integer.parseInt(commandRest[1]);
                    Task taskToUnMark = tasks.get(taskId - 1);
                    taskToUnMark.markAsUnDone();
                    System.out.println("Nice! I've marked this task as not done yet:");
                    System.out.println("    " + taskToUnMark);
                    break;
                } case "todo": {
                    try {
                        if (commandRest.length < 2 || commandRest[1].trim().isEmpty()) {
                            throw new ChaniException("Invalid Command: The description of a todo cannot be empty.\n" +
                                    "Follow this convention: todo <desc>");
                        }
                        String description = commandRest[1];
                        Task toDo = new ToDos(description);
                        tasks.add(toDo);
                        System.out.println("Got it. I've added this task:");
                        System.out.println(toDo);
                        System.out.println("Now you have " + tasks.size() + " tasks in the list.");
                    } catch (ChaniException e) {
                        System.out.println("    " + e.getMessage());
                    }
                    break;
                } case "deadline": {
                    try {
                        if (commandRest.length < 2 || commandRest[1].trim().isEmpty()) {
                            throw new ChaniException("Invalid Command: The description and by date are missing.\n" +
                                    "Use: deadline <desc> /by <date>");
                        }

                        String rest = commandRest[1];
                    String[] descBy = rest.split(" /by ", 2);
                        if (descBy.length < 2 || descBy[1].trim().isEmpty()) {
                            throw new ChaniException("Invalid Command: The by date is missing.\n" +
                                    "d: deadline <desc> /by <date>");
                        }

                        Task deadline = new Deadline(descBy[0], descBy[1]);
                    tasks.add(deadline);
                    System.out.println("Got it. I've added this task:");
                    System.out.println(deadline);
                    System.out.println("Now you have " + tasks.size() + " tasks in the list.");
                    } catch (ChaniException e) {
                        System.out.println("    " + e.getMessage());
                    }
                    break;
                } case "event": {
                    String rest = commandRest[1];
                    String[] descriptionRest = rest.split(" /from ", 2);
                    String[] fromTo = descriptionRest[1].split(" /to ", 2);

                    Task event = new Event(descriptionRest[0], fromTo[0], fromTo[1]);
                    tasks.add(event);
                    System.out.println("Got it. I've added this task:");
                    System.out.println(event);
                    System.out.println("Now you have " + tasks.size() + " tasks in the list.");
                    break;
                } default:
                    try {
                        throw new ChaniException("OOPS!!! I'm sorry, but I don't know what that means :-(");
                    } catch (ChaniException e) {
                        System.out.println("    " + e.getMessage());
                    }
            }
        }
    }
}
