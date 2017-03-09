package fr.polytech.si3.ihm.header;

/**
 * Created by Almond on 09/03/2017.
 */
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.image.ImageView;
import javafx.stage.Stage;

import java.io.IOException;


public class Controller {

    @FXML
    private ImageView logo;

    @FXML
    private Label homePageCapSophia;

    @FXML
    private TextField textFieldResearch;

    @FXML
    private Button buttonOk;

    @FXML
    private Button buttonEvenements;

    @FXML
    private Button buttonEnseignes;

    @FXML
    private Button buttonPromotions;

    @FXML
    private Button buttonInformation;

    private Stage window;

    @FXML
    void toEnseignes(ActionEvent event) throws IOException {

        System.out.println("Click");
        Parent root = FXMLLoader.load(getClass().getResource("/fxml/listeBoutique.fxml"));
        Stage primaryStage = (Stage) buttonEnseignes.getScene().getWindow();
        primaryStage.setTitle("Liste des boutiques du centre");
        primaryStage.setScene(new Scene(root));
        primaryStage.show();
    }

    @FXML
    void toEvenements(ActionEvent event) {

    }

    @FXML
    void toInformation(ActionEvent event) {

    }

    @FXML
    void toPromotions(ActionEvent event) {

    }

}
