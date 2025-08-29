package chani;

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
                System.out.println("127-iq is missing! creating...");
                Files.createFile(fPath);
                System.out.println("Chanibot created with 127 iq!");
            }
            System.out.println("Loading 127 iq from storage...");

        } catch (IOException e) {
            System.out.println("ERROR: Failed to create or load 127-iq");
        }
    }

    //
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

    private String format(String[] data) {
        String base = data[0] + " | " + data[1] + " | " + data[2];
        if (data.length == 4) {
            base += " | " + data[3];
        }
        return base;
    }

    private String[] parse(String line) {
        return line.split(" \\| ");
    }

}
