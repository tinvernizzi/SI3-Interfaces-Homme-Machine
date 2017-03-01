package fr.polytech.si3.ihm;

import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.IOException;

public class HomeController
{
    private static final Logger log = LoggerFactory.getLogger(HomeController.class);

    @FXML
    private Button homeButton;

    @FXML
    private Button promoButton;

    @FXML
    private Button infoButton;

    @FXML
    private Button productButton;

    @FXML
    private Button aboutButton;

    @FXML
    public void initialize() {

        assert homeButton != null;

        homeButton.setOnMouseClicked(new EventHandler<MouseEvent>() {
            public void handle(MouseEvent event) {
                String fxmlFile = "/fxml/home.fxml";
                FXMLLoader loader = new FXMLLoader();
                try {
                    Stage stage=(Stage) homeButton.getScene().getWindow();
                    Parent rootNode = (Parent) loader.load(getClass().getResourceAsStream(fxmlFile));

                    Scene scene = new Scene(rootNode);
                    stage.setScene(scene);
                    stage.show();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        });
    }
}
