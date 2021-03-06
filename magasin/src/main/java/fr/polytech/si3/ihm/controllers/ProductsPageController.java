package fr.polytech.si3.ihm.controllers;

import fr.polytech.si3.ihm.model.Category;
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

    @Override
    public void start(MainController mainController) {
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
        singleProductController.setProductInformations(product);
    }

    public void display(List<Product> data) {
        productGrid.getChildren().clear();
        for (Product p : data) {
            try {
                addProduct(p);
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}
