package fr.polytech.si3.ihm.controllers;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.input.MouseEvent;

/**
 * Created by Antoine on 3/1/2017.
 */
public class EnteteController {
    @FXML
    public Button promotionsButton;
    private MainController mainController;
    private ContactController contactController;

    @FXML
    public void promotionButtonClicked(MouseEvent event) {
        System.out.println(contactController.getNode());
        mainController.setScrollTo(contactController.getNode());
    }

    public void start(MainController mainController, ContactController contactController) {
        this.mainController = mainController;
        this.contactController = contactController;
    }
}
