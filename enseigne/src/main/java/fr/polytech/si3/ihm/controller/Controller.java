package fr.polytech.si3.ihm.controller;

import fr.polytech.si3.ihm.controller.elements.ContactController;
import fr.polytech.si3.ihm.controller.elements.HeaderMenuController;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.layout.BorderPane;

import java.io.IOException;

public class Controller {

    @FXML
    private BorderPane header;

    @FXML
    private BorderPane contact;

    void displayHeader(Controller currentController) {
        String fxmlFile = "/fxml/elements/header.fxml";
        FXMLLoader loader = new FXMLLoader();
        try {
            Parent rootNode = loader.load(getClass().getResourceAsStream(fxmlFile));
            ((HeaderMenuController) loader.getController()).initialize(currentController);

            header.setCenter(rootNode);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    void displayContact() {
        String fxmlFile = "/fxml/elements/contact.fxml";
        FXMLLoader loader = new FXMLLoader();
        try {
            Parent rootNode = loader.load(getClass().getResourceAsStream(fxmlFile));
            ((ContactController) loader.getController()).initialize();

            contact.setCenter(rootNode);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
