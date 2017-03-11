package fr.polytech.si3.ihm.controller.elements;

import fr.polytech.si3.ihm.model.Info;
import fr.polytech.si3.ihm.model.Promotion;
import javafx.fxml.FXML;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.text.Text;

public class InfoSliderController {

    @FXML
    private Text titre;

    @FXML
    private Text description;

    @FXML
    private ImageView image;

    @FXML
    private void initialize() {
    }

    public void initInfo(Info info) {
        this.titre.setText(info.getTitre());
        this.description.setText(info.getDescription());
        this.image.setImage(new Image(info.getImagePath()));
    }
}
