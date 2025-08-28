import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.List;


public class TaskList {
    private ArrayList<Task> tasks;

    //take in a list of tasks, and for each, u want to convert them into the correct tasks
    //and store in TaskList
    public TaskList(List<Task> tasks) {
        this.tasks = new ArrayList<>(tasks);
    }


}
