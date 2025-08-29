import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.List;


public class TaskList {
    private final ArrayList<Task> tasks;

    //take in a list of tasks, and for each, u want to convert them into the correct tasks
    //and store in TaskList
    public TaskList(List<Task> tasks) {
        this.tasks = new ArrayList<>(tasks);
    }

    public int size() {
        return tasks.size();
    }

    public Task get(int i) {
        return tasks.get(i-1);
    }

    public void remove(Task task) {
        tasks.remove(task);
    }

    public void add(Task task) {
        tasks.add(task);
    }



}
