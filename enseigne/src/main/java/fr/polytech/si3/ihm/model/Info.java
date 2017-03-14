package fr.polytech.si3.ihm.model;

import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;
import javafx.scene.paint.Color;

public class Info {

    private StringProperty titre;
    private StringProperty description;
    private StringProperty color;
    private String imagePath;

    public Info(String titre, String description, String color, String imagePath) {
        this.titre = new SimpleStringProperty(titre);
        this.description = new SimpleStringProperty(description);
        this.color = new SimpleStringProperty(color);
        this.imagePath = imagePath;
    }

    public String getColor() {
        return color.get();
    }

    public String getImagePath() {
        return imagePath;
    }

    public String getDescription() {
        return description.get();
    }

    public String getTitre() {
        return titre.get();
    }
}
