import java.util.Scanner;

public class Chani {
    public static void main(String[] args) {
        final String BOT_NAME = "Chani";
        Scanner scanner = new Scanner(System.in);

        Task[] tasks = new Task[100];
        int count = 0;

        String greeting = String.format("Hello! I'm %s\nWhat can I do for you?", BOT_NAME);
        System.out.println(greeting);

        while (true) {
            String input = scanner.nextLine();
            String[] commandRest = input.split(" ", 2);
            String command = commandRest[0];

            switch(command) {
                case "list":
                    for (int i = 0; i < count; i ++) {
                        int numbering = i + 1;
                        System.out.println(numbering + ". " + tasks[i]);
                    }
                    break;
                case "bye":
                    System.out.println("Bye. Hope to see you again soon!");
                    return;
                case "mark": {
                    int taskId = Integer.parseInt(commandRest[1]);
                    Task taskToMark = tasks[taskId - 1];
                    taskToMark.markAsDone();
                    System.out.println("Nice! I've marked this task as done:");
                    System.out.println("    " + taskToMark);
                    break;
                } case "unmark": {
                    int taskId = Integer.parseInt(commandRest[1]);
                    Task taskToUnMark = tasks[taskId - 1];
                    taskToUnMark.markAsUnDone();
                    System.out.println("Nice! I've marked this task as not done yet:");
                    System.out.println("    " + taskToUnMark);
                    break;
                } case "todo": {
                    String description = commandRest[1];
                    Task toDo = new ToDos(description);
                    tasks[count] = toDo;
                    count++;
                    System.out.println("Got it. I've added this task:");
                    System.out.println(toDo);
                    System.out.println("Now you have " + count + " tasks in the list.");
                    break;
                } case "deadline": {
                    String rest = commandRest[1];
                    String[] descBy = rest.split(" /by ", 2);
                    Task deadline = new Deadline(descBy[0], descBy[1]);
                    tasks[count] = deadline;
                    count++;
                    System.out.println("Got it. I've added this task:");
                    System.out.println(deadline);
                    System.out.println("Now you have " + count + " tasks in the list.");

                    break;
                } case "event": {
                    String rest = commandRest[1];
                    String[] descriptionRest = rest.split(" /from ", 2);
                    String[] fromTo = descriptionRest[1].split(" /to ", 2);

                    Task event = new Event(descriptionRest[0], fromTo[0], fromTo[1]);
                    tasks[count] = event;
                    count++;
                    System.out.println("Got it. I've added this task:");
                    System.out.println(event);
                    System.out.println("Now you have " + count + " tasks in the list.");
                } default:
            }
        }
    }
}
