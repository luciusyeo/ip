import java.util.Scanner;

public class Chani {
    public static void main(String[] args) {
        final String BOT_NAME = "Chani";
        Scanner scanner = new Scanner(System.in);

        String[] tasks = new String[100];
        int count = 0;

        String greeting = String.format("Hello! I'm %s\nWhat can I do for you?", BOT_NAME);
        System.out.println(greeting);

        while (true) {
            String input = scanner.nextLine();
            String[] splitInput = input.split(" ");
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
                default:
                    tasks[count] = input;
                    count++;
                    System.out.println("added: " + input);

            }
        }
    }
}
