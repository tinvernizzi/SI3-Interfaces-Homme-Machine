package fr.polytech.si3.ihm.controllers;

import javafx.fxml.FXML;
import javafx.scene.Node;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.scene.input.MouseEvent;

/**
 * Created by Antoine on 3/7/2017.
 */
public class PromotionsController implements Controller{
    @FXML
    public Label mainTitle;

    @FXML
    public ListView listepromo;

    public Node getNode() {
        return mainTitle;
    }

    @Override
    public void start(MainController mainController) {
        System.out.println("hello"+listepromo);
        fillPromoList();
    }

    private void fillPromoList() {

    }

    public Node getAnchor() {
        return mainTitle;
    }
}
