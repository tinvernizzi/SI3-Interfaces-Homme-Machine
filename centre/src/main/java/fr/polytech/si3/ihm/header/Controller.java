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
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;

import java.io.IOException;


public class Controller {

    @FXML
    private ImageView logo;

    @FXML
    private Label homePage;

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

    @FXML
    void toHomePage(MouseEvent event) throws IOException {
        Parent root = FXMLLoader.load(getClass().getResource("/fxml/homePage.fxml"));
        Stage primaryStage = (Stage) buttonEnseignes.getScene().getWindow();
        primaryStage.setScene(new Scene(root));
        primaryStage.show();
    }

    @FXML
    void toEnseignes(ActionEvent event) throws IOException {
        Parent root = FXMLLoader.load(getClass().getResource("/fxml/listeBoutique.fxml"));
        Stage primaryStage = (Stage) buttonEnseignes.getScene().getWindow();
        primaryStage.setTitle("Liste des boutiques du centre");
        primaryStage.setScene(new Scene(root));
        primaryStage.show();
    }

    @FXML
    void toEvenements(ActionEvent event) throws IOException {
        Parent root = FXMLLoader.load(getClass().getResource("/fxml/evenement.fxml"));
        Stage primaryStage = (Stage) buttonEvenements.getScene().getWindow();
        primaryStage.setTitle("Evènements en cours");
        primaryStage.setScene(new Scene(root));
        primaryStage.show();
    }

    @FXML
    void toInformation(ActionEvent event) throws IOException {
        Parent root = FXMLLoader.load(getClass().getResource("/fxml/information.fxml"));
        Stage primaryStage = (Stage) buttonInformation.getScene().getWindow();
        primaryStage.setTitle("Informations");
        primaryStage.setScene(new Scene(root));
        primaryStage.show();
    }

    @FXML
    void toPromotions(ActionEvent event) throws IOException {
        Parent root = FXMLLoader.load(getClass().getResource("/fxml/promotion.fxml"));
        Stage primaryStage = (Stage) buttonPromotions.getScene().getWindow();
        primaryStage.setTitle("Promotions en cours");
        primaryStage.setScene(new Scene(root));
        primaryStage.show();
    }

}
