package fr.polytech.si3.ihm.controller.elements;

import fr.polytech.si3.ihm.model.Produit;
import javafx.fxml.FXML;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.text.Text;

public class ProductGridController {

    @FXML
    public ImageView image;

    @FXML
    public Text titre;

    public void initProduit(Produit produit) {
        this.titre.setText(produit.getName());
        this.titre.setStyle("-fx-text-alignment: center; -fx-font-size: 18");
        this.image.setImage(new Image(produit.getImagePath()));
    }

    public void initialize() {
    }
}
