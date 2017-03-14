package fr.polytech.si3.ihm.controller;

import fr.polytech.si3.ihm.controller.elements.PromotionListeController;
import fr.polytech.si3.ihm.model.ListePromotions;
import fr.polytech.si3.ihm.model.Promotion;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.control.ListCell;
import javafx.scene.control.ListView;
import javafx.util.Callback;

import java.io.IOException;

public class PromoController extends Controller {

    @FXML
    private ListView<Promotion> listepromo;

    @FXML
    public void initialize() {
        displayPromotions();
        displayHeader(this);
        displayContact();
    }

    private void displayPromotions() {
        ObservableList<Promotion> liste = new ListePromotions().getListePromotions();
        this.listepromo.setPrefHeight(188 * liste.size());
        this.listepromo.setItems(liste);
        this.listepromo.setCellFactory(
                new Callback<ListView<Promotion>, ListCell<Promotion>>() {
                    public ListCell<Promotion> call(ListView<Promotion> listView) {
                        return new ListCell<Promotion>() {
                            protected void updateItem(Promotion item, boolean empty) {
                                super.updateItem(item, empty);
                                if (item != null) {
                                    try {
                                        String fxmlFile = "/fxml/elements/promo_list_promo_element.fxml";
                                        FXMLLoader loader = new FXMLLoader();
                                        Parent listElement = loader.load(getClass().getResourceAsStream(fxmlFile));
                                        ((PromotionListeController) loader.getController()).initPromotion(item);
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
}
