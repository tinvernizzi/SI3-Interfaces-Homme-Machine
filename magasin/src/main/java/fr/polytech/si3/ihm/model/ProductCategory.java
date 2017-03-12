package fr.polytech.si3.ihm.model;

import javafx.collections.ObservableList;
import javafx.scene.image.ImageView;

import java.util.List;

/**
 * Created by tanguy on 08/03/17.
 */
public class ProductCategory {

    String name;
    private List<Product> listOfProduct;

    public ProductCategory(String name, List<Product> listOfProducts) {
        this.name = name;
        this.listOfProduct = listOfProducts;
    }

    public List<Product> getListOfProduct() {
        return listOfProduct;
    }
}
