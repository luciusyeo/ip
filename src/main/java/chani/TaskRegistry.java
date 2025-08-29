package chani;

import java.util.HashMap;

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
        TaskFactory factory = getFactory(identifier);
        if (factory == null) {
            throw new IllegalArgumentException("Unknown task type: " + identifier);
        }
        return factory.create(args);
    }

    private static TaskFactory getFactory(String identifier) {
        return registry.get(identifier.toLowerCase());
    }
}
