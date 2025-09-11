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
     * @param fPath txt file path for storage.
     */
    public Chani(String fPath) {
        this.storage = new Storage(fPath);
        this.ui = new Ui("Chani");
        tasks = new TaskList(storage.load());
    }

    /**
     * Returns gui message for Chani bot.
     * @param input text to return.
     * @return Chani bot's message.
     */
    public String getResponse(String input) {
        String chatLabel = "Chani: ";
        String response;
        try {
            Command c = Parser.parse(input);
            response = c.execute(tasks, ui, storage);
        } catch (ChaniException | NumberFormatException | IndexOutOfBoundsException e) {
            response = e.getMessage();
        }
        return chatLabel + response;
    }

    /**
     * Returns gui greeting for Chani bot.
     * @return greeting message.
     */
    public String getGreeting() {
        return ui.showWelcome();
    }
}
