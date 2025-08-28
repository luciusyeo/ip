import java.util.HashMap;

public class TaskParser {
    HashMap<String, String> labelMap = new HashMap<>();

    public TaskParser() {
        labelMap.put("D", "deadline");
        labelMap.put("deadline", "deadline");
        labelMap.put("T", "todo");
        labelMap.put("todo", "todo");
        labelMap.put("E", "event");
        labelMap.put("event", "event");
    }
    
    public void createTask(String label) {
        String taskName = this.labelMap.get(label);

        switch()
    }
}
