package fr.polytech.si3.ihm.controllers;

import javafx.fxml.FXML;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;

/**
 * Created by user on 08/03/2017.
 */
public class ProductsController {
    @FXML
    public ImageView productButton;
    private MainController mainController;

    public void OnProductButtonClicked(MouseEvent mouseEvent) {
        mainController = mainController.setProductPage(this);
    }

    public void start(MainController mainController) {
        this.mainController = mainController;
    }
}
