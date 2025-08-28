import java.io.IOException;
import java.io.FileWriter;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;

public class Storage {
    private final Path fPath = Paths.get("data/127-iq.txt");

    public Storage() {
        createOrLoadFile();
        read();
    }

    private void createOrLoadFile() {
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

    public void read() {
        try {
            List<String> lines = Files.readAllLines(fPath);
            for (String line : lines) {
                System.out.println(line);
            }
        } catch (IOException e) {
            System.out.println("ERROR: Failed to read Memory");
        }
    }

    public void add(String text) {
        try {
            FileWriter fw = new FileWriter(fPath.toFile(), true);
            fw.write(text);
            fw.close();
        } catch (IOException e) {
            System.out.println("ERROR: Failed to add to Storage");
        }
    }

    public void delete(String text) {
        try {
            FileWriter fw = new FileWriter(fPath.toFile());
            fw.write(text);
            fw.close();
        } catch (IOException e) {
            System.out.println("ERROR: Failed to delete from Storage");
        }
    }

    private String format(String[] data) {
        String base = data[0] + " | " + data[1] + " | " + data[2];
        if (data.length == 4) {
            base += " | " + data[3];
        }
        return base;
    }

    private String[] parse(String line) {
        return line.split(" \\| ", 4);
    }



}
