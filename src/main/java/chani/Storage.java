package chani;

import chani.tasks.Task;
import chani.tasks.TaskRegistry;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Objects;

public class Storage {
    private final Path fPath;

    public Storage(String fPath) {
        this.fPath = Paths.get(fPath);
        createFileIfMissing();
    }

    private void createFileIfMissing() {
        try {
            Files.createDirectories(fPath.getParent());
            if (Files.notExists(fPath)) {
                Files.createFile(fPath);
            }
        } catch (IOException e) {
            System.out.println("ERROR: Failed to create or load 127-iq");
        }
    }

    public List<Task> load() {
        ArrayList<Task> TaskList = new ArrayList<>();
        try {
            List<String> lines = Files.readAllLines(fPath);

            lines.forEach((line) -> {
                String[] tokens = this.parse(line);
                String identifier = tokens[0];
                String[] args = Arrays.copyOfRange(tokens, 2, tokens.length);

                Task task = TaskRegistry.createTask(identifier, args);

                boolean marked = Objects.equals(tokens[1], "1");
                if (marked) {
                    task.markAsDone();
                }

                TaskList.add(task);
            });
        } catch (IOException e) {
            System.out.println("ERROR: Failed to read Memory");
            return new ArrayList<>();
        }
        return TaskList;
    }

    public void save(List<Task> tasks) {
        List<String> lines = new ArrayList<>();
        for (Task task : tasks) {
            String[] arr = task.toStringList().toArray(new String[0]);
            lines.add(format(arr));
        }

        try {
            Files.write(fPath, lines);
        } catch (IOException e) {
            System.out.println("ERROR: Failed to write to Memory");
        }

    }

    private String format(String[] data) {
        return String.join(" | ", data);
    }

    private String[] parse(String line) {
        return line.split(" \\| ");
    }

}
