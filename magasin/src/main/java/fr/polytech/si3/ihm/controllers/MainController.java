package fr.polytech.si3.ihm.controllers;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.JavaFXBuilderFactory;
import javafx.geometry.Bounds;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ScrollPane;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

import java.io.IOException;

/**
 * Created by Antoine on 3/1/2017.
 */
public class MainController {

    @FXML
    public VBox content;
    @FXML
    public ScrollPane scrollPane;
    @FXML
    private Parent contactView;
    @FXML
    private ContactController contactViewController;
    @FXML
    private Parent slideshowView;
    @FXML
    private SlideshowController slideshowViewController;
    @FXML
    private Parent enteteView;
    @FXML
    private EnteteController enteteViewController;
    @FXML
    private Parent promotionsView;
    @FXML
    private PromotionsController promotionsViewController;


    public void initialize() {
        contactViewController.start();
        slideshowViewController.start(this);
        enteteViewController.start(this,contactViewController);
    }

    public void setScrollTo(Node node) {
        Bounds bounds = node.localToScene(node.getBoundsInLocal());
        double h = scrollPane.getContent().getBoundsInLocal().getHeight();
        double y = (bounds.getMaxY() +
                bounds.getMinY()) / 2.0;
        double v = scrollPane.getViewportBounds().getHeight();
        System.out.println(h+" "+v+" "+y);
        System.out.println(scrollPane.getVmax() * ((y * v) / (h - v)));
        scrollPane.setVvalue(scrollPane.getVmax() * ((y - 0.5 * v) / (h - v)));
    }
}
