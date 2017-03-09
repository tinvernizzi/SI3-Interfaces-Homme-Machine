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
public class InterfaceAdminButtonController implements Controller{

    @FXML
    private Button button;
    private MainController mainController;

    public void changeToAdminInterface(MouseEvent mouseEvent) throws IOException {
        mainController.setAdminPage();
    }

    @Override
    public void start(MainController mainController) {
        this.mainController = mainController;
    }
}
