package fr.polytech.si3.ihm.controllers;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.input.MouseEvent;

/**
 * Created by Antoine on 3/1/2017.
 */
public class EnteteController {
    @FXML
    public Button promotionsButton;
    private MainController mainController;
//    private ContactController contactController;

    @FXML
    public void promotionButtonClicked(MouseEvent event) {
        if(!mainController.isOnMainView()){
//            mainController.resetMainView();
        }
//        mainController.setScrollTo(contactController.getNode());
        mainController.addContent("/fxml/plugins/slideshow.fxml");
    }

    public void start(MainController mainController) {
        this.mainController = mainController;
//        this.contactController = contactController;
    }

    public void OnAccueilButtonClicked(MouseEvent mouseEvent) {
        if(!mainController.isOnMainView()) {
            mainController = mainController.setMainPage(this);
        }
    }
}
