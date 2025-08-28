import java.util.Scanner;

//TODO: create a parsed command

public class Parser {
    private final Scanner scanner;

    public Parser() {
        scanner = new Scanner(System.in);
    }

    public String[] parseCommandInput(){
        return readInput().split(" ", 2);
    }

    private String readInput() {
        return scanner.nextLine();
    }
}
