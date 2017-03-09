package fr.polytech.si3.ihm.controllers;

import javafx.fxml.FXML;
import javafx.scene.Node;
import javafx.scene.control.Label;

/**
 * Created by user on 08/03/2017.
 */
public class ProductsPageController implements Controller{
    @FXML
    public Label title;

    @Override
    public void start(MainController mainController) {

    }

    public Node getAnchor() {
        return title;
    }
}
