package fr.polytech.si3.ihm.controllers;

import fr.polytech.si3.ihm.model.Product;
import fr.polytech.si3.ihm.model.ProductDatabase;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.Node;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Antoine on 3/7/2017.
 */
public class PromotionsController implements Controller{
    @FXML
    public Label mainTitle;

    @FXML
    public ListView promoList;
    private ProductDatabase database;

    public Node getNode() {
        return mainTitle;
    }

    public void start(MainController mainController, ProductDatabase database) {
        this.database = database;
        System.out.println("hello"+ promoList);
        fillPromoList();
    }

    private void fillPromoList() {
        List<Product> promoProducts = database.getPromoProducts();
        ObservableList<Product> list = FXCollections.observableArrayList(promoProducts);
        promoList.setPrefHeight(188 * promoProducts.size());
        promoList.setItems(list);
    }

    public Node getAnchor() {
        return mainTitle;
    }

    @Override
    public void start(MainController mainController) {

    }
}
