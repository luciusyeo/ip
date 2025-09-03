package chani;

import chani.commands.Command;

/**
 * Represents the main chatbot class
 */
public class Chani {
    private Storage storage;
    private TaskList tasks;
    private Ui ui;

    /**
     * Class Constructor.
     *
     * @param fPath txt file path for storage.
     */
    public Chani(String fPath) {
        this.ui = new Ui("Chani");
        this.storage = new Storage(fPath);
        tasks = new TaskList(storage.load());
    }

    /**
     * Runs ChaniBot.
     */
    public void run() {
        ui.showWelcome();
        boolean isExit = false;

        while (!isExit) {
            try {
                String fullCommand = ui.readCommand();
                ui.showLine();
                Command c = Parser.parse(fullCommand);
                c.execute(tasks, ui, storage);
                isExit = c.isExit();

            } catch (ChaniException e) {
                ui.showError(e.getMessage());
            } finally {
                ui.showLine();
            }
        }
    }

    /**
     * Returns gui message for Chani bot
     * @param input text to return.
     * @return Chani bot's message.
     * @throws IllegalArgumentException If zone is <= 0.
     */
    public String getResponse(String input) {
        return "Duke heard: " + input;
    }

    public static void main(String[] args) {
        new Chani("data/127-iq.txt").run();
    }
}
