import java.util.ArrayList;

public class Chani {
    public static void main(String[] args) {
        Ui ui = new Ui("Chani");
        ArrayList<Task> tasks = new ArrayList<>();

        ui.showGreeting();

        while (true) {
            String input = ui.readInput();
            String[] commandRest = input.split(" ", 2);
            String command = commandRest[0];

            switch(command) {
                case "list":
                    StringBuilder taskMessage = new StringBuilder();
                    for (int i = 0; i < tasks.size(); i ++) {
                        int numbering = i + 1;
                        taskMessage.append(String.format("%d. %s\n", numbering, tasks.get(i)));
                    }
                    ui.showList(taskMessage.toString());
                    break;
                case "bye":
                    ui.showGoodbye();
                    return;
                case "mark": {
                    int taskId = Integer.parseInt(commandRest[1]);
                    Task taskToMark = tasks.get(taskId - 1);
                    taskToMark.markAsDone();
                    ui.showMarkedTask(taskToMark);
                    break;
                }
                case "unmark": {
                    int taskId = Integer.parseInt(commandRest[1]);
                    Task taskToUnMark = tasks.get(taskId - 1);
                    taskToUnMark.markAsUnDone();
                    ui.showUnmarkedTask(taskToUnMark);
                    break;
                }
                case "todo": {
                    try {
                        if (commandRest.length < 2 || commandRest[1].trim().isEmpty()) {
                            throw new ChaniException("Invalid Command: The description of a todo cannot be empty.\n" +
                                    "Follow this convention: todo <desc>");
                        }
                        String description = commandRest[1];
                        Task toDo = new ToDos(description);
                        tasks.add(toDo);
                        ui.showAddedTask(toDo, tasks.size());
                    } catch (ChaniException e) {
                        ui.showError(e.getMessage());
                    }
                    break;
                }
                case "deadline": {
                    try {
                        if (commandRest.length < 2 || commandRest[1].trim().isEmpty()) {
                            throw new ChaniException("Invalid Command: The description and by date are missing.\n" +
                                    "Use: deadline <desc> /by <date>");
                        }

                        String rest = commandRest[1];
                        String[] descBy = rest.split(" /by ", 2);
                        if (descBy.length < 2 || descBy[1].trim().isEmpty()) {
                            throw new ChaniException("Invalid Command: The by date is missing.\n" +
                                    "Use: deadline <desc> /by <date>");
                        }

                        Task deadline = new Deadline(descBy[0], descBy[1]);
                        tasks.add(deadline);
                        ui.showAddedTask(deadline, tasks.size());
                    } catch (ChaniException e) {
                        ui.showError(e.getMessage());
                    }
                    break;
                }
                case "event": {
                    String rest = commandRest[1];
                    String[] descriptionRest = rest.split(" /from ", 2);
                    String[] fromTo = descriptionRest[1].split(" /to ", 2);

                    Task event = new Event(descriptionRest[0], fromTo[0], fromTo[1]);
                    tasks.add(event);
                    ui.showAddedTask(event, tasks.size());
                    break;
                }
                case "delete": {
                    int taskId = Integer.parseInt(commandRest[1]);
                    Task toDelete = tasks.get(taskId - 1);  // ⚠️ careful: was missing -1
                    tasks.remove(toDelete);
                    ui.showDeletedTask(toDelete, tasks.size());
                    break;
                }
                default: {
                    try {
                        throw new ChaniException("OOPS!!! I'm sorry, but I don't know what that means :-(");
                    } catch (ChaniException e) {
                        ui.showError(e.getMessage());
                    }
                }
            }
        }
    }
}
