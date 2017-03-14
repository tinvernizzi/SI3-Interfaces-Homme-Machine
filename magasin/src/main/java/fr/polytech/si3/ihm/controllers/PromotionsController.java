package fr.polytech.si3.ihm.controllers;

import fr.polytech.si3.ihm.model.Product;
import fr.polytech.si3.ihm.model.ProductDatabase;
import fr.polytech.si3.ihm.model.Promotion;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.control.Label;
import javafx.scene.control.ListCell;
import javafx.scene.control.ListView;
import javafx.util.Callback;

import java.io.IOException;
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
        promoList.setPrefHeight(320);
        promoList.setEditable(false);
        promoList.setCellFactory(
                new Callback<ListView<Product>, ListCell<Product>>() {
                    public ListCell<Product> call(ListView<Product> listView) {
                        return new ListCell<Product>() {
                            protected void updateItem(Product item, boolean empty) {
                                if (item != null) {
                                    try {
                                        String fxmlFile = "/fxml/plugins/product.fxml";
                                        FXMLLoader loader = new FXMLLoader();
                                        Parent listElement = loader.load(getClass().getResourceAsStream(fxmlFile));
                                        ((SingleProductController) loader.getController()).setProductInformations(item);
                                        this.setGraphic(listElement);
                                    } catch (IOException e) {
                                        e.printStackTrace();
                                    }
                                }
                            }
                        };
                    }
                }
        );
        promoList.setItems(list);
    }

    public Node getAnchor() {
        return mainTitle;
    }

    @Override
    public void start(MainController mainController) {

    }
}
