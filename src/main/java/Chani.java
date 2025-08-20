import java.util.Scanner;

public class Chani {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String greeting = "Hello! I'm Chani\n" +
                "What can I do for you?\n";
        System.out.println(greeting);

        while (true) {
            String input = scanner.nextLine();

            if (input.equalsIgnoreCase("bye")) {
                System.out.println("Chani: Bye ;) Hope to see you again soon!");
                break;
            }

            System.out.println("Chani: " + input);
        }
    }
}
