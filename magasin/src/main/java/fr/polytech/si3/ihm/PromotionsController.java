package fr.polytech.si3.ihm;

import javafx.fxml.FXML;
import javafx.scene.image.Image;
import javafx.scene.layout.VBox;

public class PromotionsController {

    @FXML
    private javafx.scene.image.ImageView promo1;

    @FXML
    private javafx.scene.image.ImageView promo2;

    @FXML
    private javafx.scene.image.ImageView promo3;

    @FXML
    private javafx.scene.image.ImageView promo4;

    @FXML
    public void changeDisplayedPromotions() {
        Image promoTemp = promo1.getImage();
        promo1.setImage(promo2.getImage());
        promo2.setImage(promo3.getImage());
        promo3.setImage(promo4.getImage());
        promo4.setImage(promoTemp);
    }
}
