package chani;

import chani.tasks.Task;

/**
 * Represents the ui messages of the chatbot
 */
public class Ui {
    private final String bot;

    /**
     * Constructs a Ui with the specified bot name.
     * @param bot The name of the bot.
     */
    public Ui(String bot) {
        this.bot = bot;
    }

    /**
     * Returns the welcome message of the bot.
     * @return Welcome message string.
     */
    public String showWelcome() {
        return "Hello! I'm " + bot + ", What can I do for you?";
    }

    /**
     * Returns a message showing the list of tasks.
     * @param taskList The string representation of tasks.
     * @return Task list message.
     */
    public String showList(String taskList) {
        return "Here are the tasks in your list: \n " + taskList;
    }

    /**
     * Returns the goodbye message of the bot.
     * @return Goodbye message string.
     */
    public String showGoodbye() {
        return "see you again soon :( \n closing bot...";
    }

    /**
     * Returns a message for a marked task.
     * @param task The task that was marked done.
     * @return Marked task message.
     */
    public String showMarkedTask(Task task) {
        return "Nice! I've marked this task as done: \n" + task;
    }

    /**
     * Returns a message for an unmarked task.
     * @param task The task that was marked not done.
     * @return Unmarked task message.
     */
    public String showUnmarkedTask(Task task) {
        return "Nice! I've marked this task as not done yet:" + task;
    }

    /**
     * Returns a message for an added task.
     * @param task The task that was added.
     * @param size The total number of tasks in the list.
     * @return Added task message.
     */
    public String showAddedTask(Task task, int size) {
        return "Got it. I've added this task: \n"
                + task
                + "Now you have " + size + " tasks in the list.";
    }

    /**
     * Returns a message for a deleted task.
     * @param task The task that was removed.
     * @param size The total number of tasks left in the list.
     * @return Deleted task message.
     */
    public String showDeletedTask(Task task, int size) {
        return "Noted. I've removed this task:"
                + task
                + "Now you have " + size + " tasks in the list.";
    }

    /**
     * Returns a message showing queried tasks.
     * @param queried The string of queried tasks.
     * @return Queried tasks message.
     */
    public String showQueriedTasks(String queried) {
        return queried;
    }
}
