package fr.polytech.si3.ihm.controllers;

import fr.polytech.si3.ihm.model.Product;
import fr.polytech.si3.ihm.model.ProductCategory;
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

    @Override
    public void start(MainController mainController) {

    }

    public void initializeData(String category) {
        productGrid.getChildren().clear();

        List<Product> bookProduct = Arrays.asList(
                new Product("Le Yoga Facile pour les Nuls", 16, "/images/produits/D1.jpg", ""),
                new Product("Le Yoga Facile pour les Bons", 16, "/images/produits/L1.jpg", ""),
                new Product("Le Yoga Facile pour les Nuls", 16, "/images/produits/L2.jpg", "")
        );

        ProductCategory book = new ProductCategory("Book", bookProduct);

        try {
            addProduct(bookProduct.get(0));
            addProduct(bookProduct.get(1));
            addProduct(bookProduct.get(0));
            addProduct(bookProduct.get(1));
            addProduct(bookProduct.get(0));
            addProduct(bookProduct.get(1));
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
}
