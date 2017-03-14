package fr.polytech.si3.ihm.controller.elements;

import fr.polytech.si3.ihm.model.Info;
import javafx.fxml.FXML;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.text.Text;

public class InfoListController {
    @FXML
    private Text description;

    @FXML
    private Text title;

    @FXML
    private ImageView image;

    @FXML
    private void initialize() {
    }
    public void initInfo(Info info) {
        this.description.setText(info.getDescription());
        this.title.setText(info.getTitre());
        this.image.setImage(new Image(info.getImagePath()));

        description.getParent().getParent().setStyle("-fx-background-color: #" + info.getColor() + ";");
    }
}
