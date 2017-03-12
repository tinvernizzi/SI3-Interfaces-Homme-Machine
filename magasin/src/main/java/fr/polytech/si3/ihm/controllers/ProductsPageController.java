package fr.polytech.si3.ihm.controllers;

import fr.polytech.si3.ihm.model.Product;
import fr.polytech.si3.ihm.model.ProductCategory;
import fr.polytech.si3.ihm.model.ProductDatabase;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.control.Label;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.TilePane;

import java.io.IOException;
import java.net.URL;
import java.util.Arrays;
import java.util.List;

/**
 * Created by user on 08/03/2017.
 */
public class ProductsPageController implements Controller{
    @FXML
    public Label title;

    @FXML
    public TilePane productGrid;
    private ProductDatabase database;

    @Override
    public void start(MainController mainController) {
        this.database = new ProductDatabase();
        displayAll();
    }

    public void displayAll() {
        productGrid.getChildren().clear();

        List<ProductCategory> data = database.getAllItems();

        try {
            for (ProductCategory c : data) {
                List<Product> products = c.getListOfProduct();
                for(int i = 0; i< products.size(); i++) addProduct(products.get(i));
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public Node getAnchor() {
        return title;
    }

    private void addProduct(Product product) throws IOException {

        final URL fxmlURL = getClass().getResource("/fxml/plugins/product.fxml");

        final FXMLLoader fxmlLoader = new FXMLLoader(fxmlURL);
        Node node = fxmlLoader.load();
        productGrid.getChildren().add(node);
        SingleProductController singleProductController = fxmlLoader.getController();
        singleProductController.setProductInformations(product, false);
    }

    public void search(boolean dvds, boolean cds, boolean books, boolean stages) {
        productGrid.getChildren().clear();
        if(dvds)displayDvds();
        if(cds)displayCds();
        if(books)displayBooks();
        if(stages)displayStages();
    }

    private void displayStages() {
        ProductCategory data = database.getStages();
        displayCategory(data);
    }

    private void displayCds() {
        ProductCategory data = database.getCds();
        displayCategory(data);
    }

    private void displayBooks() {
        ProductCategory data = database.getBooks();
        displayCategory(data);
    }

    private void displayDvds() {
        ProductCategory data = database.getDvds();
        displayCategory(data);
    }

    void displayCategory(ProductCategory category){
        try {
            for (int i = 0; i < category.getListOfProduct().size(); i++) {
                addProduct(category.getListOfProduct().get(i));
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
