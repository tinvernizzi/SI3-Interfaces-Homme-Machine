package fr.polytech.si3.ihm.controllers;

import fr.polytech.si3.ihm.model.*;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.geometry.Bounds;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.control.ScrollPane;
import javafx.scene.layout.VBox;

import java.io.IOException;
import java.io.InputStream;
import java.util.Optional;

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
    @FXML
    private Parent interfaceAdminButtonView;
    @FXML
    private InterfaceAdminButtonController interfaceAdminButtonViewController;

    private boolean isOnMainView = true;

    private ProductsPageController productsPageViewController;
    private SearchController searchViewController;
    private AdministrationPageController administrationPageController;
    private SlideShowContent slideShowContent;
    private ProductDatabase productDatabase;
    private Contact contact;

    public void initialize() {
        //init of model
        this.contact = new Contact();
        this.productDatabase = new ProductDatabase();
        this.slideShowContent = new SlideShowContent();

        //init of all controllers
        contactViewController.start(this);
        slideshowViewController.start(this);
        enteteViewController.start(this);
        promotionsViewController.start(this);
        productsViewController.start(this);
        interfaceAdminButtonViewController.start(this);
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

    public void setProductPage(Optional<String> searchName,Optional<Type> type, Optional<Category> category) {
        isOnMainView = false;
        content.getChildren().clear();
        searchViewController = (SearchController) addContent("/fxml/plugins/search.fxml");
        productsPageViewController = (ProductsPageController) addContent("/fxml/page_NosProduits.fxml");
        productsPageViewController.start(this);
        searchViewController.start(this,productsPageViewController,searchName,type,category);

        setScrollTo(productsPageViewController.getAnchor());
    }

    public void setAdminPage() {
        isOnMainView = false;
        content.getChildren().clear();
        administrationPageController = (AdministrationPageController) addContent("/fxml/administration.fxml");
        administrationPageController.start(this);
    }

    public void setMainPage() {
        this.isOnMainView = true;
        content.getChildren().clear();
        slideshowViewController = (SlideshowController) addContent("/fxml/plugins/slideshow.fxml");
        slideshowViewController.start(this);
        promotionsViewController =(PromotionsController) addContent("/fxml/plugins/promotions.fxml");
        promotionsViewController.start(this);
        productsViewController =(ProductsController) addContent("/fxml/plugins/nos_produits.fxml");
        productsViewController.start(this);
        contactViewController = (ContactController) addContent("/fxml/plugins/contact.fxml");
        contactViewController.start(this);
        interfaceAdminButtonViewController = (InterfaceAdminButtonController) addContent("/fxml/plugins/interfaceAdminButton.fxml");
        interfaceAdminButtonViewController.start(this);
        setScrollTo(slideshowView);
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

    public VBox getContent() {
        return content;
    }

    public Contact getContactInformations() {
        return contact;
    }

    public SlideShowContent getSlideShowContent() {
        return slideShowContent;
    }

    public ProductDatabase getProductDatabase() {
        return productDatabase;
    }
}
