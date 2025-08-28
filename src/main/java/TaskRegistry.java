import java.util.HashMap;

// registry.put("D", new DeadlineTaskFactory());

public class TaskRegistry {
    private static final HashMap<String, TaskFactory> registry = new HashMap<>();

    public TaskRegistry() {
        //Storage
        registry.put("d", new DeadlineTaskFactory());
        registry.put("t", new TodoTaskFactory());
        registry.put("e", new EventTaskFactory());

        //CLI
        registry.put("deadline", new DeadlineTaskFactory());
        registry.put("todo", new TodoTaskFactory());
        registry.put("event", new EventTaskFactory());
    }

    public static Task createTask(String identifier, String... args) {
        TaskFactory factory = registry.get(identifier.toLowerCase());
        if (factory == null) {
            throw new IllegalArgumentException("Unknown task type: " + identifier);
        }
        return factory.create(args);
    }
}
