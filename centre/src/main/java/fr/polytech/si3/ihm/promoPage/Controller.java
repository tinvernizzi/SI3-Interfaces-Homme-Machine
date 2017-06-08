package fr.polytech.si3.ihm.promoPage;


import fr.polytech.si3.ihm.promotion.Model;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.control.ListCell;
import javafx.scene.control.ListView;
import javafx.util.Callback;

import java.io.IOException;


/**
 * Created by Almond on 12/03/2017.
 */
public class Controller {

    @FXML
    private ListView<Model> listView;

    public void initialize() {
        ObservableList<Model> promotions = FXCollections.observableArrayList(
                new Model("/images/products/coffret.jpg", "Coffret de 10 CD", "Offre spéciale à -50%", "Description\nSe relaxer avec la musique"),
                new Model("/images/products/yoga.jpg", "Le Yoga pour les nuls", "Offre spéciale à -20%", "Description\nSe développer mentalement avec le yoga "),
                new Model("/images/products/michel.jpg", "Michel Cymes", "Maintenant en stock\nOffre découverte -10%", "Description\nComprendre son corps"),
                new Model("/images/products/stage.jpg", "Stage de bien être", "Offre spéciale à -20%", "Description\nS'épanouir dans la nature")
        );

        listView.setItems(promotions);
        listView.setCellFactory(new Callback<ListView<Model>,
            ListCell<Model>>() {
                public ListCell<Model> call(ListView<Model> param) {
                    return new PromoCell();
                }
            }
        );
    }

    static class PromoCell extends ListCell<Model> {
        @Override
        public void updateItem(Model promo, boolean empty) {
            super.updateItem(promo, empty);

            if (promo != null) {
                super.updateItem(promo, empty);

                try {
                    String fxmlFile = "/fxml/promotion.fxml";
                    FXMLLoader loader = new FXMLLoader();
                    Parent listElement = loader.load(getClass().getResourceAsStream(fxmlFile));
                    ((fr.polytech.si3.ihm.promotion.Controller) loader.getController()).init(promo);
                    this.setGraphic(listElement);
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }
}
