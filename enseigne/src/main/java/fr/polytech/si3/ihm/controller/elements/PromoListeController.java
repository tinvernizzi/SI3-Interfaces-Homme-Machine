package fr.polytech.si3.ihm.controller.elements;

import fr.polytech.si3.ihm.model.Promotion;
import javafx.fxml.FXML;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.text.Text;

/**
 * Created by user on 13/03/2017.
 */
public class PromoListeController {
    @FXML
    private Text description;

    @FXML
    private Text title;

    @FXML
    private ImageView image;

    @FXML
    private void initialize() {
    }
    public void initPromotion(Promotion promotion) {
        this.description.setText(promotion.getDescription());
        this.title.setText(promotion.getTitle());
        this.image.setImage(new Image(promotion.getImagePath()));
    }
}
