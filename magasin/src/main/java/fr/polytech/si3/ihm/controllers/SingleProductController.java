package fr.polytech.si3.ihm.controllers;

import fr.polytech.si3.ihm.model.Product;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.image.ImageView;

/**
 * Created by tanguy on 11/03/17.
 */
public class SingleProductController {

    @FXML
    public Label description;

    @FXML
    public Label conditionPromo;

    @FXML
    public Label marque;

    @FXML
    public ImageView productLogo;

    @FXML
    public Label isAPromo;

    public SingleProductController() {

    }

    public void setProductInformations(Product product) {
        productLogo.setImage(product.getImage());
        description.setText(product.getDescription());
        marque.setText(product.getName());
        this.conditionPromo.setText(product.getPrix() + "€");
        if (product.isOnPromotion()) {
            this.isAPromo.setText("PROMO");
        }else{
            this.isAPromo.setText("");
        }
    }

}
