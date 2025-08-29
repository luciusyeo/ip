package chani;

import java.util.Scanner;

/**
 * Represents the Ui displayed on CLI for ChaniBot.
 */
public class Ui {
    private final String bot;
    private final Scanner scanner;

    public Ui(String bot) {
        this.bot = bot;
        scanner = new Scanner(System.in);
    }

    /**
     * Displays the welcome message for the bot.
    **/
    public void showWelcome() {
        System.out.printf("Hello! I'm %s%nWhat can I do for you?%n", bot);
    }

    /**
     * Reads one line from the CLI.
     * @return the user input in the CLI.
     **/
    public String readCommand() {
        return scanner.nextLine();
    }

    /**
     * Displays a separator line in the CLI for better readability.
     */
    public void showLine() {
        System.out.println("________________________");
    }

    /**
     * Displays the list of tasks currently stored.
     *
     * @param taskList a formatted string representing the list of tasks.
     */
    public void showList(String taskList) {
        System.out.println("Here are the tasks in your list:");
        System.out.println(taskList);
    }
    /**
     * Displays an error message to the user.
     *
     * @param message the error message to display.
     */
    public void showError(String message) {
        System.out.println("    " + message);
    }

    /**
     * Displays a goodbye message when the bot exits.
     */
    public void showGoodbye() {
        System.out.println("Bye. Hope to see you again soon!");
    }

    /**
     * Displays a confirmation message when a task is marked as done.
     *
     * @param task the task that was marked.
     */
    public void showMarkedTask(Task task) {
        System.out.println("Nice! I've marked this task as done:");
        System.out.println("    " + task);
    }

    /**
     * Displays a confirmation message when a task is marked as not done.
     *
     * @param task the task that was unmarked.
     */
    public void showUnmarkedTask(Task task) {
        System.out.println("Nice! I've marked this task as not done yet:");
        System.out.println("    " + task);
    }

    /**
     * Displays a confirmation message when a task is added.
     *
     * @param task the task that was added.
     * @param size the total number of tasks after addition.
     */
    public void showAddedTask(Task task, int size) {
        System.out.println("Got it. I've added this task:");
        System.out.println("    " + task);
        System.out.println("Now you have " + size + " tasks in the list.");
    }

    /**
     * Displays a confirmation message when a task is deleted.
     *
     * @param task the task that was deleted.
     * @param size the total number of tasks remaining after deletion.
     */
    public void showDeletedTask(Task task, int size) {
        System.out.println("Noted. I've removed this task:");
        System.out.println("    " + task);
        System.out.println("Now you have " + size + " tasks in the list.");
    }
}
