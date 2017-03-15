package fr.polytech.si3.ihm.homePage;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.stage.Stage;

import java.io.IOException;

/**
 * Created by Almond on 06/03/2017.
 */
public class Controller {
    @FXML
    private Label eventType;

    @FXML
    private Label title;

    @FXML
    private Label description;

    @FXML
    void toEvenement(ActionEvent event) throws IOException {
        Parent root = FXMLLoader.load(getClass().getResource("/fxml/eventPage.fxml"));
        Stage primaryStage = (Stage) eventType.getScene().getWindow();
        primaryStage.setTitle("Evènements en cours");
        primaryStage.setScene(new Scene(root));
        primaryStage.show();
    }

    public void initialize() {
        eventType.setText("Evènement");
        title.setText("Anniversaire de votre centre Cap Sophia");
        description.setText("Fêtez notre 2ème anniversaire avec l'ensemble de nos partenaires et\nprofitez de nombreuses offres exclusives proposées notamment par votre\nenseigne préférée To Be Or To Have");
    }
}
