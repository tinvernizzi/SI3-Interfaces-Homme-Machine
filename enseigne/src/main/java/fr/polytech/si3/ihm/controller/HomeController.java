package fr.polytech.si3.ihm.controller;

import fr.polytech.si3.ihm.model.ListPromotions;
import fr.polytech.si3.ihm.model.Promotion;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.control.ListCell;
import javafx.scene.control.ListView;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.util.Callback;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.IOException;
import java.util.Collections;

import static java.lang.Thread.sleep;

public class HomeController
{
    private static final Logger log = LoggerFactory.getLogger(HomeController.class);

    @FXML
    private BorderPane header;

    @FXML
    private ListView<Promotion> slidePromos;

    @FXML
    private void initialize() {
        displayHeader();
        displayPromotions();
    }

    private void displayPromotions() {
        this.slidePromos.setItems(new ListPromotions().getListPromotions());
        this.slidePromos.setCellFactory(
                new Callback<ListView<Promotion>, ListCell<Promotion>>() {
                    public ListCell<Promotion> call(ListView<Promotion> listView) {
                        return new ListCell<Promotion>() {
                            protected void updateItem(Promotion item, boolean empty) {
                                super.updateItem(item, empty);
                                if (item != null) {
                                    try {
                                        String fxmlFile = "/fxml/elements/home_list_promotion_element.fxml";
                                        FXMLLoader loader = new FXMLLoader();
                                        Parent listElement = loader.load(getClass().getResourceAsStream(fxmlFile));
                                        ((PromotionController) loader.getController()).initPromotion(item);
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
    }


    private void displayHeader() {
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
}
