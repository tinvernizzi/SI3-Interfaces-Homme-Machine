package fr.polytech.si3.ihm.controllers;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.input.MouseEvent;

/**
 * Created by Antoine on 3/1/2017.
 */
public class EnteteController implements Controller{
    @FXML
    public Button promotionsButton;

    private MainController mainController;

    @Override
    public void start(MainController mainController) {
        System.out.println("ente");
        this.mainController = mainController;
    }

    @FXML
    public void onPromotionButtonClicked(MouseEvent event) {
        if(mainController.isOnMainView()) {
            mainController.setScrollTo(mainController.getPromotionsController().getAnchor());
        }else{
            mainController.setMainPage(this);
        }
    }

    @FXML
    public void onContactButtonClicked(MouseEvent event) {
        if(mainController.isOnMainView()) {
            mainController.setScrollTo(mainController.getContactController().getAnchor());
        }else{
            mainController.setMainPage(this);
        }
    }

    @FXML
    public void onAccueilButtonClicked(MouseEvent mouseEvent) {
        if(!mainController.isOnMainView()) {
            mainController.setMainPage(this);
        }
    }

    @FXML
    public void OnProductsButtonClicked(MouseEvent mouseEvent) {
        if(mainController.isOnMainView()) {
            mainController.setScrollTo(mainController.getProductsController().getAnchor());
        }else{
            mainController.setMainPage(this);
        }
    }
}
