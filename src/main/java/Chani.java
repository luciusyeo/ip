import java.util.Scanner;

public class Chani {
    public static void main(String[] args) {
        final String BOT_NAME = "Chani";
        Scanner scanner = new Scanner(System.in);


        String greeting = String.format("%s: Hello! I'm %s. How may I be of service?", BOT_NAME, BOT_NAME);

        System.out.println(greeting);

        while (true) {
            String input = scanner.nextLine();

            if (input.equalsIgnoreCase("bye")) {
                System.out.println(BOT_NAME + ": Bye ;) Hope to see you again soon!");
                break;
            }

            System.out.println(BOT_NAME + ": " + input);
        }
    }
}
