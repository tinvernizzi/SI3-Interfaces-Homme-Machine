package fr.polytech.si3.ihm.event;

import javafx.beans.property.SimpleStringProperty;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

/**
 * Created by Almond on 14/03/2017.
 */
public class Model {
    private ImageView image;
    private SimpleStringProperty title;
    private SimpleStringProperty description;

    public Model(String path, String title, String description) {
        this.image = new ImageView(path);
        this.title = new SimpleStringProperty(title);
        this.description = new SimpleStringProperty(description);
    }

    public Image getImage() {
        return image.getImage();
    }

    public String getDescription() {
        return description.get();
    }

    public String getTitle() {
        return title.get();
    }

}
