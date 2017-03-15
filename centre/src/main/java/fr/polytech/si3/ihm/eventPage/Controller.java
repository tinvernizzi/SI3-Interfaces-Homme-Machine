package fr.polytech.si3.ihm.eventPage;

import fr.polytech.si3.ihm.event.Model;
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
 * Created by Almond on 14/03/2017.
 */
public class Controller {

    @FXML
    private ListView<Model> listView;

    public void initialize() {
        ObservableList<Model> promotions = FXCollections.observableArrayList(
                new Model("/images/events/mall.jpg", "Anniversaire de votre centre Cap Sophia", "Fêtez notre 2ème anniversaire avec l'ensemble de nos partenaires et profitez de\nnombreuses offres exclusives proposées notamment par votre enseigne préférée To Be Or To Have"),
                new Model("/images/events/mazarine.jpg", "Exposition autour de Mazarine", "Les collections personnelles du cardinal Mazarine ont permis\nde fonder la bibliothèque portant son nom")
        );

        listView.setItems(promotions);
        listView.setCellFactory(new Callback<ListView<Model>,
            ListCell<Model>>() {
                public ListCell<Model> call(ListView<Model> param) {
                    return new Controller.EventCell();
                }
            }
        );
    }

    static class EventCell extends ListCell<Model> {
        @Override
        public void updateItem(Model event, boolean empty) {
            super.updateItem(event, empty);

            if (event != null) {
                super.updateItem(event, empty);

                try {
                    String fxmlFile = "/fxml/event.fxml";
                    FXMLLoader loader = new FXMLLoader();
                    Parent listElement = loader.load(getClass().getResourceAsStream(fxmlFile));
                    ((fr.polytech.si3.ihm.event.Controller) loader.getController()).init(event);
                    this.setGraphic(listElement);
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }
}

