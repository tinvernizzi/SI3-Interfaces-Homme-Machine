package fr.polytech.si3.ihm.controllers;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;

import java.util.Optional;

/**
 * Created by Antoine on 3/1/2017.
 */
public class EnteteController implements Controller{

    @FXML
    public TextField barreRecherche;

    private MainController mainController;

    @Override
    public void start(MainController mainController) {
        this.mainController = mainController;
    }

    @FXML
    public void onPromotionButtonClicked(MouseEvent event) {
        if(mainController.isOnMainView()) {
            mainController.setScrollTo(mainController.getPromotionsController().getAnchor());
        }else{
            mainController.setMainPage();
        }
    }

    @FXML
    public void onContactButtonClicked(MouseEvent event) {
        if(mainController.isOnMainView()) {
            mainController.setScrollTo(mainController.getContactController().getAnchor());
        }else{
            mainController.setMainPage();
        }
    }

    @FXML
    public void onAccueilButtonClicked(MouseEvent mouseEvent) {
        if(!mainController.isOnMainView()) {
            mainController.setMainPage();
        }
    }

    @FXML
    public void OnProductsButtonClicked(MouseEvent mouseEvent) {
        if(mainController.isOnMainView()) {
            mainController.setScrollTo(mainController.getProductsController().getAnchor());
        }else{
            mainController.setMainPage();
        }
    }

    public void onSearchButtonClicked(MouseEvent mouseEvent) {
        mainController.setProductPage(Optional.of(barreRecherche.getCharacters().toString()), Optional.empty(),Optional.empty());
    }
}
