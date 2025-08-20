import java.util.Scanner;

public class Chani {
    public static void main(String[] args) {
        String botName = "Chani";
        Scanner scanner = new Scanner(System.in);

        String greeting = String.format("%s: Hello! I'm %s. How may I be of service?", botName, botName);

        System.out.println(greeting);

        while (true) {
            String input = scanner.nextLine();

            if (input.equalsIgnoreCase("bye")) {
                System.out.println(botName + ": Bye ;) Hope to see you again soon!");
                break;
            }

            System.out.println(botName + ": " + input);
        }
    }
}
