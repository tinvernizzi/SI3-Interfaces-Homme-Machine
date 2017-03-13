package fr.polytech.si3.ihm.model;

import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;
import javafx.scene.paint.Color;

public class Promotion {

    private StringProperty produit;
    private StringProperty marque;
    private StringProperty offre;
    private StringProperty color;
    private String imagePath;

    public Promotion(String produit, String marque, String offre, String color, String imagePath) {
        this.produit = new SimpleStringProperty(produit);
        this.marque = new SimpleStringProperty(marque);
        this.offre = new SimpleStringProperty(offre);
        this.color = new SimpleStringProperty(color);
        this.imagePath = imagePath;
    }

    public String getProduit() {
        return produit.get();
    }

    public String getMarque() {
        return marque.get();
    }

    public String getOffre() {
        return offre.get();
    }

    public String getColor() {
        return color.get();
    }

    public String getImagePath() {
        return imagePath;
    }
}
