package chani;

import chani.tasks.Task;

import java.util.Scanner;

public class Ui {
    private final String bot;
    private final Scanner scanner;

    public Ui(String bot) {
        this.bot = bot;
        scanner = new Scanner(System.in);
    }

    public void showWelcome() {
        System.out.printf("Hello! I'm %s%nWhat can I do for you?%n", bot);
    }

    public String readCommand() {
        return scanner.nextLine();
    }

    public void showLine() {
        System.out.println("________________________");
    }

    public void showList(String taskList) {
        System.out.println("Here are the tasks in your list:");
        System.out.println(taskList);
    }

    public void showError(String message) {
        System.out.println("    " + message);
    }

    public void showGoodbye() {
        System.out.println("Bye. Hope to see you again soon!");
    }

    public void showMarkedTask(Task task) {
        System.out.println("Nice! I've marked this task as done:");
        System.out.println("    " + task);
    }

    public void showUnmarkedTask(Task task) {
        System.out.println("Nice! I've marked this task as not done yet:");
        System.out.println("    " + task);
    }

    public void showAddedTask(Task task, int size) {
        System.out.println("Got it. I've added this task:");
        System.out.println("    " + task);
        System.out.println("Now you have " + size + " tasks in the list.");
    }

    public void showDeletedTask(Task task, int size) {
        System.out.println("Noted. I've removed this task:");
        System.out.println("    " + task);
        System.out.println("Now you have " + size + " tasks in the list.");
    }

    public void showQueriedTasks(String queried) {
        System.out.println(queried);
    }
}
