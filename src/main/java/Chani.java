import java.time.format.DateTimeParseException;
import java.util.ArrayList;

enum Input {
    COMMAND(0),
    ARGUMENTS(1);

    private final int index;

    Input(int index) {
        this.index = index;
    }

    public int get() {
        return index;
    }
}

public class Chani {
    private Storage storage;
    private TaskList tasks;
    private Ui ui;
    static Parser parser = new Parser();

    public Chani(String fPath) {
        this.ui = new Ui("Chani");
        this.storage = new Storage(fPath);
        tasks = new TaskList(storage.load());
    }

    public void run() {
        ui.showGreeting();
        while (true) {
            String[] inputSplit = parser.parseCommandInput();
            String command = inputSplit[Input.COMMAND.get()];
            String arguments = inputSplit[Input.ARGUMENTS.get()];

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
                    int taskId = Integer.parseInt(arguments);
                    Task taskToMark = tasks.get(taskId - 1);
                    taskToMark.markAsDone();
                    ui.showMarkedTask(taskToMark);
                    break;
                }
                case "unmark": {
                    int taskId = Integer.parseInt(arguments);
                    Task taskToUnMark = tasks.get(taskId - 1);
                    taskToUnMark.markAsUnDone();
                    ui.showUnmarkedTask(taskToUnMark);
                    break;
                }
                case "todo": {
                    try {
                        if (inputSplit.length < 2 || arguments.trim().isEmpty()) {
                            throw new ChaniException("Invalid Command: The description of a todo cannot be empty.\n" +
                                    "Follow this convention: todo <desc>");
                        }
                        Task toDo = new ToDoTask(arguments);
                        tasks.add(toDo);
                        ui.showAddedTask(toDo, tasks.size());
                    } catch (ChaniException e) {
                        ui.showError(e.getMessage());
                    }
                    break;
                }
                case "deadline": {
                    try {
                        if (inputSplit.length < 2 || arguments.trim().isEmpty()) {
                            throw new ChaniException("Invalid Command: The description and by date are missing.\n" +
                                    "Use: deadline <desc> /by <yyyy-mm-dd>");
                        }

                        String[] descBy = arguments.split(" /by ", 2);
                        if (descBy.length < 2 || descBy[1].trim().isEmpty()) {
                            throw new ChaniException("Invalid Command: The by date is missing.\n" +
                                    "Use: deadline <desc> /by <yyyy-mm-dd>");
                        }

                        try {
                            Task deadline = new DeadlineTask(descBy[0], descBy[1]);
                            tasks.add(deadline);
                            ui.showAddedTask(deadline, tasks.size());
                        } catch (DateTimeParseException e) {
                            throw new ChaniException("Invalid Date: use <yyyy-mm-dd>");
                        }
                    } catch (ChaniException e) {
                        ui.showError(e.getMessage());
                    }
                    break;
                }
                case "event": {
                    String[] descriptionRest = arguments.split(" /from ", 2);
                    String[] fromTo = descriptionRest[1].split(" /to ", 2);

                    Task event = new EventTask(descriptionRest[0], fromTo[0], fromTo[1]);
                    tasks.add(event);
                    ui.showAddedTask(event, tasks.size());
                    break;
                }
                case "delete": {
                    int taskId = Integer.parseInt(arguments);
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


    public static void main(String[] args) {
        new Chani("data/127-iq.txt").run();
    }
}
