package fr.polytech.si3.ihm.promotion;

import javafx.beans.property.SimpleStringProperty;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

/**
 * Created by Almond on 06/03/2017.
 */
public class Model {
    private ImageView image;
    private SimpleStringProperty title;
    private SimpleStringProperty reduction;
    private SimpleStringProperty description;

    public Model(String path, String title, String reduction, String description) {
        this.image = new ImageView(path);
        this.reduction = new SimpleStringProperty(reduction);
        this.title = new SimpleStringProperty(title);
        this.description = new SimpleStringProperty(description);
    }

    public Image getImage() {
        return image.getImage();
    }

    public String getReduction() {
        return reduction.get();
    }

    public String getDescription() {
        return description.get();
    }

    public String getTitle() {
        return title.get();
    }

    public SimpleStringProperty reductionProperty() {
        return reduction;
    }

    public SimpleStringProperty descriptionProperty() {
        return description;
    }

    public SimpleStringProperty titleProperty() {
        return title;
    }
}
