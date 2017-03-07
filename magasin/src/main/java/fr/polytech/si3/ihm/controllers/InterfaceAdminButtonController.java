package fr.polytech.si3.ihm.controllers;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;

import java.io.IOException;

/**
 * Created by tanguy on 02/03/17.
 */
public class InterfaceAdminButtonController {

    @FXML
    private Button button;

    public void changeToAdminInterface(MouseEvent mouseEvent) throws IOException {
        Stage stage;
        Parent root;

        stage = (Stage) button.getScene().getWindow();
        stage.close();

        String fxmlFile = "/fxml/Main.fxml";
        FXMLLoader loader = new FXMLLoader();
        root = loader.load(getClass().getResourceAsStream(fxmlFile));

        Scene scene = new Scene(root);
        stage.setScene(scene);
        stage.show(); //TODO : dont work

    }
}
