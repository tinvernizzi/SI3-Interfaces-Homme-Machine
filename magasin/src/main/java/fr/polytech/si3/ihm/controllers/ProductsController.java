package fr.polytech.si3.ihm.controllers;

import javafx.fxml.FXML;
import javafx.scene.Node;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;

import java.util.Optional;

import static fr.polytech.si3.ihm.model.Category.NEUROLOGIC;
import static fr.polytech.si3.ihm.model.Category.NO_CATEGORY;
import static fr.polytech.si3.ihm.model.Category.SCIENTIFIC;
import static fr.polytech.si3.ihm.model.Type.*;

public class ProductsController implements Controller{
    @FXML
    public ImageView productButton;
    public ImageView neuroProductButton;
    public ImageView scienceProductButton;
    public ImageView dvdButton;
    public ImageView cdButton;
    public ImageView stageButton;
    public ImageView bookButton;

    private MainController mainController;
    


    public Node getAnchor(){
        return productButton;
    }

    public void start(MainController mainController) {
        this.mainController = mainController;
    }

    public void OnProductButtonClicked(MouseEvent mouseEvent) throws InterruptedException {
        mainController.setProductPage(Optional.empty(), Optional.empty());
    }

    public void OnNeuroButtonClicked(MouseEvent mouseEvent) {
        mainController.setProductPage(Optional.empty(), Optional.of(NEUROLOGIC));

    }

    public void OnScienceButtonClicked(MouseEvent mouseEvent) {
        mainController.setProductPage(Optional.empty(),Optional.of(SCIENTIFIC));


    }

    public void OnDvdButtonClicked(MouseEvent mouseEvent) {
        mainController.setProductPage(Optional.of(DVD), Optional.empty());
    }

    public void OnCdButtonClicked(MouseEvent mouseEvent) {
        mainController.setProductPage(Optional.of(CD), Optional.empty());
    }

    public void OnBookButtonClicked(MouseEvent mouseEvent) {
        mainController.setProductPage(Optional.of(BOOK), Optional.empty());

    }

    public void OnStageButtonClicked(MouseEvent mouseEvent) {
        mainController.setProductPage(Optional.of(STAGE), Optional.empty());

    }
}
