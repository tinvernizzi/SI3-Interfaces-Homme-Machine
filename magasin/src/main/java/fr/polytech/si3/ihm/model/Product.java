package fr.polytech.si3.ihm.model;

import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

import static fr.polytech.si3.ihm.model.Category.NO_CATEGORY;

public class Product {

    private String name;
    private int prix;
    private Image image;
    private String description;
    private Category category;
    private Type type;

    public Product(String name, int prix, String ImagePath, String description,Type type,Category category) {
        this.name = name;
        this.prix = prix;
        this.image = new Image(ImagePath);
        this.description = description;
        this.type = type;
        this.category = category;
    }

    public Product(String name, int prix, String ImagePath, String description,Type type) {
        this.name = name;
        this.prix = prix;
        this.image = new Image(ImagePath);
        this.description = description;
        this.type = type;
        this.category = NO_CATEGORY;
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

    public Category getCategory() {
        return category;
    }

    public Type getType() {
        return type;
    }
}
