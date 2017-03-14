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
    private String description;
    private String title;

    public Promotion(String produit, String marque, String offre, String color, String imagePath) {
        this.produit = new SimpleStringProperty(produit);
        this.marque = new SimpleStringProperty(marque);
        this.offre = new SimpleStringProperty(offre);
        this.color = new SimpleStringProperty(color);
        this.imagePath = imagePath;
        this.title=produit+" "+offre;
        this.description= produit+" de "+marque+" vous offre "+offre;
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

    public String getDescription(){ return this.description;}

    public String getTitle(){ return  this.title;}

    public String getImagePath() {
        return imagePath;
    }
}
