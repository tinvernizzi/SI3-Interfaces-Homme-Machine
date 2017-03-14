package fr.polytech.si3.ihm.model;

import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;
import javafx.scene.paint.Color;

public class Promotion {

    private StringProperty produit;
    private StringProperty marque;
    private StringProperty offre;
    private Color color;
    private String imagePath;
    private String description;
    private String title;

    public Promotion(String produit, String marque, String offre, Color color, String imagePath) {
        this.produit = new SimpleStringProperty(produit);
        this.marque = new SimpleStringProperty(marque);
        this.offre = new SimpleStringProperty(offre);
        this.color = color;
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

    public Color getColor() {
        return color;
    }

    public String getDescription(){ return this.description;}

    public String getTitle(){ return  this.title;}

    public String getImagePath() {
        return imagePath;
    }

    public StringProperty getProduitProperty() {
        return produit;
    }

    public StringProperty getMarqueProperty() {
        return marque;
    }

    public StringProperty getOffreProperty() {
        return offre;
    }
}
