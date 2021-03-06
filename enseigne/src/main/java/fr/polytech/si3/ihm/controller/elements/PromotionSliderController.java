package fr.polytech.si3.ihm.controller.elements;

import fr.polytech.si3.ihm.model.Promotion;
import javafx.fxml.FXML;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.VBox;
import javafx.scene.text.Text;

public class PromotionSliderController {

    @FXML
    private Text produit;

    @FXML
    private Text marque;

    @FXML
    private Text offre;

    @FXML
    private ImageView image;

    @FXML
    private void initialize() {
    }

    public void initPromotion(Promotion promotion) {
        this.produit.setText(promotion.getProduit());
        this.marque.setText(promotion.getMarque());
        this.offre.setText(promotion.getOffre());
        this.image.setImage(new Image(promotion.getImagePath()));

        produit.getParent().setStyle("-fx-background-color: #" + promotion.getColor() + ";");
    }
}
