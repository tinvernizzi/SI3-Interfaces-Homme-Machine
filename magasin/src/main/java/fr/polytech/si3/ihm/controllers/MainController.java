package fr.polytech.si3.ihm.controllers;

import fr.polytech.si3.ihm.model.Category;
import fr.polytech.si3.ihm.model.ProductDatabase;
import fr.polytech.si3.ihm.model.Type;
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

    public ProductDatabase getProductDatabase() {
        return productDatabase;
    }

    private ProductDatabase productDatabase;


    public void initialize() {
        productDatabase = new ProductDatabase();
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

    public void setProductPage(ProductsController productsController, Optional<Type> type, Optional<Category> category) {
        isOnMainView = false;
        this.productsViewController = productsController;
        content.getChildren().clear();
        searchViewController = (SearchController) addContent("/fxml/plugins/search.fxml");
        productsPageViewController = (ProductsPageController) addContent("/fxml/page_NosProduits.fxml");
        productsPageViewController.start(this);
        searchViewController.start(this,productsPageViewController,type,category);

        setScrollTo(productsPageViewController.getAnchor());
    }

    public void setAdminPage(InterfaceAdminButtonController controller) {
        isOnMainView = false;
        this.interfaceAdminButtonViewController = controller;
        content.getChildren().clear();
        administrationPageController = (AdministrationPageController) addContent("/fxml/administration.fxml");
        administrationPageController.start(this);
    }

    public void setMainPage(EnteteController controller) {
        this.isOnMainView = true;
        this.enteteViewController = controller;
        content.getChildren().clear();
        slideshowViewController = (SlideshowController) addContent("/fxml/plugins/slideshow.fxml");
        slideshowViewController.start(this);
        promotionsViewController =(PromotionsController) addContent("/fxml/plugins/promotions.fxml");
        promotionsViewController.start(this);
        productsViewController =(ProductsController) addContent("/fxml/plugins/nos_produits.fxml");
        productsViewController.start(this);
        if (contactViewController == null) {
            contactViewController = (ContactController) addContent("/fxml/plugins/contact.fxml");
            System.out.println(contactViewController.getAdress());
        }
        else {
            addContent("/fxml/plugins/contact.fxml");
            System.out.println(contactViewController.getAdress());
        }
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

    public ContactController getContactViewController() {
        return contactViewController;
    }
}
