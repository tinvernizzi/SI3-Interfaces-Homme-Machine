package fr.polytech.si3.ihm.controllers;

import javafx.fxml.FXML;
import javafx.scene.Node;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;

public class ProductsController implements Controller{
    @FXML
    public ImageView productButton;

    private MainController mainController;
    
    public void OnProductButtonClicked(MouseEvent mouseEvent) throws InterruptedException {
        mainController.setProductPage(this, "book");
    }

    public Node getAnchor(){
        return productButton;
    }

    public void start(MainController mainController) {
        this.mainController = mainController;
    }
}
