public class Chani {
    private Storage storage;
    private TaskList tasks;
    private Ui ui;

    public Chani(String fPath) {
        this.ui = new Ui("Chani");
        this.storage = new Storage(fPath);
        tasks = new TaskList(storage.load());
    }

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

    public static void main(String[] args) {
        new Chani("data/127-iq.txt").run();
    }
}
