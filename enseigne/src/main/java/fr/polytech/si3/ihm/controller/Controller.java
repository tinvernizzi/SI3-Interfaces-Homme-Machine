package fr.polytech.si3.ihm.controller;

import fr.polytech.si3.ihm.controller.elements.ContactController;
import fr.polytech.si3.ihm.controller.elements.HeaderController;
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

    public void displayHeader() {
        String fxmlFile = "/fxml/elements/header.fxml";
        FXMLLoader loader = new FXMLLoader();
        try {
            // Load the Header FXML
            Parent rootNode = loader.load(getClass().getResourceAsStream(fxmlFile));
            ((HeaderController) loader.getController()).initialize();

            header.setCenter(rootNode);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void displayContact() {
        String fxmlFile = "/fxml/elements/contact.fxml";
        FXMLLoader loader = new FXMLLoader();
        try {
            // Load the Header FXML
            Parent rootNode = loader.load(getClass().getResourceAsStream(fxmlFile));
            ((ContactController) loader.getController()).initialize();

            contact.setCenter(rootNode);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
