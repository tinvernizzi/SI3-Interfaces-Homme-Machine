package fr.polytech.si3.ihm.controller;

import fr.polytech.si3.ihm.controller.elements.InfoSliderController;
import fr.polytech.si3.ihm.controller.elements.PromotionSliderController;
import fr.polytech.si3.ihm.controller.elements.SlideshowController;
import fr.polytech.si3.ihm.model.Info;
import fr.polytech.si3.ihm.model.ListeInfos;
import fr.polytech.si3.ihm.model.ListePromotions;
import fr.polytech.si3.ihm.model.Promotion;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.control.ListCell;
import javafx.scene.control.ListView;
import javafx.scene.layout.BorderPane;
import javafx.util.Callback;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.IOException;

public class HomeController extends Controller {

    private static final Logger log = LoggerFactory.getLogger(HomeController.class);

    @FXML
    private ListView<Promotion> slidePromos;

    @FXML
    private ListView<Info> slideInfos;

    @FXML
    private BorderPane slideshow;

    @FXML
    private void initialize() {
        displayHeader(this);
        displaySlideshow();
        displayPromotions();
        displayInfos();
        displayContact();
    }

    private void displaySlideshow() { String fxmlFile = "/fxml/elements/slideshow.fxml";
        FXMLLoader loader = new FXMLLoader();
        try {
            Parent rootNode = loader.load(getClass().getResourceAsStream(fxmlFile));
            ((SlideshowController) loader.getController()).start();

            slideshow.setCenter(rootNode);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private void displayPromotions() {
        this.slidePromos.setItems(new ListePromotions().getListePromotions());
        this.slidePromos.setCellFactory(
                new Callback<ListView<Promotion>, ListCell<Promotion>>() {
                    public ListCell<Promotion> call(ListView<Promotion> listView) {
                        return new ListCell<Promotion>() {
                            protected void updateItem(Promotion item, boolean empty) {
                                super.updateItem(item, empty);
                                if (item != null) {
                                    try {
                                        String fxmlFile = "/fxml/elements/home_slide_promotion_element.fxml";
                                        FXMLLoader loader = new FXMLLoader();
                                        Parent listElement = loader.load(getClass().getResourceAsStream(fxmlFile));
                                        ((PromotionSliderController) loader.getController()).initPromotion(item);
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

    private void displayInfos() {
        this.slideInfos.setItems(new ListeInfos().getListeInfos());
        this.slideInfos.setCellFactory(
                new Callback<ListView<Info>, ListCell<Info>>() {
                    public ListCell<Info> call(ListView<Info> listView) {
                        return new ListCell<Info>() {
                            protected void updateItem(Info item, boolean empty) {
                                super.updateItem(item, empty);
                                if (item != null) {
                                    try {
                                        String fxmlFile = "/fxml/elements/home_slide_info_element.fxml";
                                        FXMLLoader loader = new FXMLLoader();
                                        Parent listElement = loader.load(getClass().getResourceAsStream(fxmlFile));
                                        ((InfoSliderController) loader.getController()).initInfo(item);
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
