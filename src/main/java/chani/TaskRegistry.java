package chani;

import java.util.HashMap;

// registry.put("D", new chani.DeadlineTaskFactory());

public class TaskRegistry {
    private static final HashMap<String, TaskFactory> registry = new HashMap<>();

    static {
        DeadlineTaskFactory deadlineFactory = new DeadlineTaskFactory();
        TodoTaskFactory toDoFactory = new TodoTaskFactory();
        EventTaskFactory eventFactory = new EventTaskFactory();

        // chani.Storage
        registry.put("d", deadlineFactory);
        registry.put("t", toDoFactory);
        registry.put("e", eventFactory);

        // CLI
        registry.put("deadline", deadlineFactory);
        registry.put("todo", toDoFactory);
        registry.put("event", eventFactory);
    }

    public TaskRegistry() {

    }

    public static Task createTask(String identifier, String... args) {
        TaskFactory factory = registry.get(identifier.toLowerCase());
        if (factory == null) {
            throw new IllegalArgumentException("Unknown task type: " + identifier);
        }
        return factory.create(args);
    }
}
