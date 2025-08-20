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
            String[] splitInput = input.split(" ", 2);
            String command = splitInput[0];

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
                    int taskId = Integer.parseInt(splitInput[1]);
                    Task taskToMark = tasks[taskId - 1];
                    taskToMark.markAsDone();
                    System.out.println("Nice! I've marked this task as done:\n");
                    System.out.println("    " + taskToMark);
                    break;
                } case "unmark": {
                    int taskId = Integer.parseInt(splitInput[1]);
                    Task taskToUnMark = tasks[taskId - 1];
                    taskToUnMark.markAsUnDone();
                    System.out.println("Nice! I've marked this task as not done yet:\n");
                    System.out.println("    " + taskToUnMark);
                    break;
                } default:
                    String description = splitInput[1];
                    tasks[count] = new Task(description);
                    count++;
                    System.out.println("added: " + description);
            }
        }
    }
}
