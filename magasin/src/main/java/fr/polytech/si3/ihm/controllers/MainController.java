package fr.polytech.si3.ihm.controllers;

import fr.polytech.si3.ihm.Promotions;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.geometry.Bounds;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.ScrollPane;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

import java.io.IOException;
import java.io.InputStream;

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
    @FXML
    private Parent productsView;
    @FXML
    private ProductsController productsViewController;

    private boolean isOnMainView = true;
    private ProductsPageController productsPageViewController;


    public void initialize() {
        contactViewController.start(this);
        slideshowViewController.start(this);
        enteteViewController.start(this);
        productsViewController.start(this);
    }

    public void setScrollTo(Node node) {
        Bounds bounds = node.localToScene(node.getBoundsInLocal());
        double h = scrollPane.getContent().getBoundsInLocal().getHeight();
        double y = (bounds.getMaxY() +
                bounds.getMinY()) / 2.0;
        double v = scrollPane.getViewportBounds().getHeight();
        scrollPane.setVvalue(scrollPane.getVmax() * ((y - 0.5 * v) / (h - v)));
    }

    public Controller addContent(String fxmlPath){
        InputStream fxmlURL = getClass().getResourceAsStream(fxmlPath);
        FXMLLoader loader = new FXMLLoader();
        try {
            Parent rootNode = loader.load(fxmlURL);
            content.getChildren().add(rootNode);
            return (Controller)loader.getController();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }

    public boolean isOnMainView() {
        return isOnMainView;
    }

    public void setProductPage(ProductsController productsController) {
        isOnMainView = false;
        this.productsViewController = productsController;
        content.getChildren().clear();
        productsPageViewController = (ProductsPageController) addContent("/fxml/page_NosProduits.fxml");
        setScrollTo(productsPageViewController.getAnchor());
    }

    public void setMainPage(EnteteController controller) {
        this.isOnMainView = true;
        this.enteteViewController = controller;
        content.getChildren().clear();
        slideshowViewController = (SlideshowController) addContent("/fxml/plugins/slideshow.fxml");
        slideshowViewController.start(this);
        promotionsViewController =(PromotionsController) addContent("/fxml/plugins/promotions.fxml");
        productsViewController.start(this);
        productsViewController =(ProductsController) addContent("/fxml/plugins/nos_produits.fxml");
        productsViewController.start(this);
        contactViewController = (ContactController) addContent("/fxml/plugins/contact.fxml");
        contactViewController.start(this);
        setScrollTo(slideshowView);
    }

    public void setAdminPage() {
    }

    public ContactController getContactController() {
        return contactViewController;
    }

    public ProductsController getProductsController() {
        return productsViewController;
    }

    public PromotionsController getPromotionsController() {
        return promotionsViewController;
    }
}
