package fr.polytech.si3.ihm.controller;

import fr.polytech.si3.ihm.controller.elements.PromoListeController;
import fr.polytech.si3.ihm.controller.elements.PromotionSliderController;
import fr.polytech.si3.ihm.model.ListPromotions;
import fr.polytech.si3.ihm.model.Promotion;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.control.ListCell;
import javafx.scene.control.ListView;
import javafx.scene.image.ImageView;
import javafx.scene.text.Text;
import javafx.util.Callback;

import java.io.IOException;

public class PromoController extends Controller {

    @FXML
    private ListView<Promotion> promos;

    @FXML
     public void initialize() {
         displayHeader(this);
         displayContact();
         displayPromotions();
     }
    private void displayPromotions() {
        this.promos.setItems(new ListPromotions().getListPromotions());
        this.promos.setCellFactory(
                new Callback<ListView<Promotion>, ListCell<Promotion>>() {
                    public ListCell<Promotion> call(ListView<Promotion> listView) {
                        return new ListCell<Promotion>() {
                            protected void updateItem(Promotion item, boolean empty) {
                                super.updateItem(item, empty);
                                if (item != null) {
                                    try {
                                        String fxmlFile = "/fxml/elements/promo_list.fxml";
                                        FXMLLoader loader = new FXMLLoader();
                                        Parent listElement = loader.load(getClass().getResourceAsStream(fxmlFile));
                                        ((PromoListeController) loader.getController()).initPromotion(item);
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
