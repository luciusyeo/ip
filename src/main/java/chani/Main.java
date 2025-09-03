package chani;

import java.io.IOException;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

/**
 * A GUI for Chani using FXML.
 */
public class Main extends Application {

    private Chani chani = new Chani("data/127-iq.txt");

    @Override
    public void start(Stage stage) {
        try {
            FXMLLoader fxmlLoader = new FXMLLoader(Main.class.getResource("/view/MainWindow.fxml"));
            AnchorPane ap = fxmlLoader.load();
            Scene scene = new Scene(ap);
            stage.setScene(scene);
            fxmlLoader.<chani.gui.MainWindow>getController().setChani(chani); // inject the Chani instance
            stage.show();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
