package fr.polytech.si3.ihm.model;

import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;
import javafx.scene.paint.Color;

public class Info {

    private StringProperty titre;
    private StringProperty description;
    private Color color;
    private String imagePath;

    public Info(String titre, String description, Color color, String imagePath) {
        this.titre = new SimpleStringProperty(titre);
        this.description = new SimpleStringProperty(description);
        this.color = color;
        this.imagePath = imagePath;
    }

    public Color getColor() {
        return color;
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
