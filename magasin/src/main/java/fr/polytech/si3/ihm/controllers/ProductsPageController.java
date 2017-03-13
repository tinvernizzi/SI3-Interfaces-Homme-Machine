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
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collector;
import java.util.stream.Collectors;

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
        for (ProductCategory c : data) {
            displayCategory(c);
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

    public void search(boolean dvds, boolean cds, boolean books, boolean stages, int min, int max, Optional<String> searchName) {
        productGrid.getChildren().clear();
        List<ProductCategory> data = new ArrayList<>();
        if(dvds)data.add(database.getDvds());
        if(cds)data.add(database.getCds());
        if(books)data.add(database.getBooks());
        if(stages)data.add(database.getStages());

        for (ProductCategory c : data) {
            displayCategory(c,min,max,searchName);
        }

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

    void displayCategory(ProductCategory category, int min, int max, Optional<String> searchName){
        try {

            List<Product> validItems = new ArrayList<>();
            if(searchName.isPresent()){
                validItems = category.getListOfProduct().stream()
                        .filter(product -> product.getPriceInteger()>= min
                                &&
                                product.getPriceInteger()<=max
                                &&
                                product.getName().contains(searchName.get())
                        ).collect(Collectors.toList());
            }else{
                validItems = category.getListOfProduct().stream()
                        .filter(product -> product.getPriceInteger()>= min
                                &&
                                product.getPriceInteger()<=max)
                        .collect(Collectors.toList());
            }
            for (Product p : validItems) {
                addProduct(p);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    void displayCategory(ProductCategory category){
        displayCategory(category,0,(int) Integer.MAX_VALUE,Optional.empty());
    }
}
