package chani;

import chani.tasks.Task;

import java.util.ArrayList;
import java.util.List;


public class TaskList {
    private final ArrayList<Task> tasks;

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

    public List<Task> find(String keyword) {
        List<Task> matches = new ArrayList<>();
        for (Task task : tasks) {
            if (task.getDescription().contains(keyword)) {
                matches.add(task);
            }
        }
        return matches;
    }

    public List<Task> getAllTasks() {
        return tasks;
    }
}
