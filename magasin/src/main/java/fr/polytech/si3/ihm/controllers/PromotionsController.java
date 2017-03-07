package fr.polytech.si3.ihm.controllers;

import javafx.fxml.FXML;
import javafx.scene.Node;
import javafx.scene.control.Label;
import javafx.scene.input.MouseEvent;

/**
 * Created by Antoine on 3/7/2017.
 */
public class PromotionsController {
    @FXML
    public Label mainTitle;

    public Node getNode() {
        return mainTitle;
    }

    public void changeDisplayedPromotions(MouseEvent event) {
    }
}
