package fr.polytech.si3.ihm.model;

import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;

public class Produit {

    private StringProperty name;
    private String imagePath;
    private int type;

    public Produit(String name, String imagePath, int type) {
        this.name = new SimpleStringProperty(name);
        this.imagePath = imagePath;
        this.type = type;
    }

    public String getName() {
        return name.get();
    }

    public String getImagePath() {
        return imagePath;
    }

    public int getType() {
        return type;
    }

}
