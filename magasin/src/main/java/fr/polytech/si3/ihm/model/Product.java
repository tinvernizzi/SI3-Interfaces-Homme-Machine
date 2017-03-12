package fr.polytech.si3.ihm.model;

import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

public class Product {

    private String name;
    private int prix;
    private Image image;
    private String description;

    public Product(String name, int prix, String ImagePath, String description) {
        this.name = name;
        this.prix = prix;
        this.image = new Image(ImagePath);
        this.description = description;
    }

    public Image getImage() {
        return image;
    }

    public String getDescription() {
        return description;
    }

    public String getName() {
        return name;
    }

    public String getPrix() {
        return ((Integer)prix).toString();
    }

    public int getPriceInteger() {
        return prix;
    }
}
