package fr.polytech.si3.ihm.controllers;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;

/**
 * Created by Antoine on 3/1/2017.
 */
public class MainController {

    @FXML
    private Parent contactView;
    @FXML
    private ContactController contactViewController;

    @FXML
    private Parent slideshowView;
    @FXML
    private SlideshowController slideshowViewController;


    public void initialize() {
        contactViewController.start();
        slideshowViewController.start();
    }
}
