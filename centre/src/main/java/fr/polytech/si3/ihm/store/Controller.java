package fr.polytech.si3.ihm.store;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.stage.Stage;

import java.io.IOException;
import java.net.URL;
import java.nio.file.Paths;

/**
 * Created by Almond on 15/03/2017.
 */
public class Controller {
    @FXML
    private Label description;

    @FXML
    private Button buttonOut;

    @FXML
    void toStore(ActionEvent event) throws IOException {
        // Todo
        //URL fxmlurl = Paths.get("/Users/Didi/Desktop/Projets/IHM/JavaFX/SI3-Interfaces-Homme-Machine/magasin/src/main/resources/fxml/MainView.fxml").toUri().toURL();
        //Parent root = FXMLLoader.load(fxmlurl);
        //Stage primaryStage = (Stage) buttonOut.getScene().getWindow();
        //primaryStage.setScene(new Scene(root));
        //primaryStage.show();
    }

    public void initialize() {
        description.setText("Lorem ipsum dolor sit amet, consectetur adipiscing elit, sed do\n" +
                "eiusmod tempor incididunt ut labore et dolore magna aliqua.\n" +
                "Ut enim ad minim veniam, quis nostrud exercitation ullamco laboris\n" +
                "nisi ut aliquip ex ea commodo consequat. Duis aute irure dolor in\n" +
                "reprehenderit in voluptate velit esse cillum dolore eu fugiat nulla pariatur.\n" +
                "Excepteur sint occaecat cupidatat non proident, sunt in culpa qui officia\n" +
                "deserunt mollit anim id est laborum."
        );
    }
}
