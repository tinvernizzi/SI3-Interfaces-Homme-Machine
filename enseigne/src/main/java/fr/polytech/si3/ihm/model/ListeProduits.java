package fr.polytech.si3.ihm.model;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

import java.util.ArrayList;

public class ListeProduits {

    private ObservableList<Produit> listeProduits;

    public ListeProduits() {
        listeProduits = FXCollections.observableArrayList(new ArrayList<Produit>());
        listeProduits.add(new Produit("CD : Coffret zen", "/images/p_C1.jpg",0));
        listeProduits.add(new Produit("CD : Relaxation", "/images/p_C2.jpg",0));
        listeProduits.add(new Produit("CD : Méditation", "/images/p_C3.jpg",0));
        listeProduits.add(new Produit("DVD : Yoga", "/images/p_D1.jpg",1));
        listeProduits.add(new Produit("DVD : Massage", "/images/p_D2.jpg",1));
        listeProduits.add(new Produit("DVD : Bien-être", "/images/p_D3.jpg",1));
        listeProduits.add(new Produit("Livre : Vivez mieux", "/images/p_L1.jpg",2));
        listeProduits.add(new Produit("Livre : Yoga", "/images/p_L2.jpg",2));
        listeProduits.add(new Produit("Livre : Massage", "/images/p_L3.jpg",2));
        listeProduits.add(new Produit("Stage : Découverte", "/images/p_S1.jpg",3));
        listeProduits.add(new Produit("Stage : Bien-être", "/images/p_S2.jpg",3));
        listeProduits.add(new Produit("Stage : Nature", "/images/p_S3.jpg",3));
    }

    public ObservableList<Produit> getListeProduits() {
        return listeProduits;
    }
}
