package fr.polytech.si3.ihm;

import javafx.beans.property.SimpleStringProperty;
import javafx.scene.image.ImageView;

/**
 * Created by Almond on 06/03/2017.
 */
public class ModelPromo {
    private ImageView image;
    private SimpleStringProperty title;
    private SimpleStringProperty description;

    public ModelPromo(ImageView image, String title, String description) {
        this.image = new ImageView();
        this.title = new SimpleStringProperty(title);
        this.description = new SimpleStringProperty(description);
    }
}
