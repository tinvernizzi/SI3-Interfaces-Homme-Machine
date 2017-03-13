package fr.polytech.si3.ihm.model;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

import java.util.ArrayList;

public class ListePromotions {

    private ObservableList<Promotion> listePromotions;

    public ListePromotions() {

        listePromotions = FXCollections.observableArrayList(new ArrayList<Promotion>());
        listePromotions.add(new Promotion("CD cool","Marque cool","-100% !", "FFFFFF","/images/p_C3.jpg"));
        listePromotions.add(new Promotion("CD cool","Marque cool","-100% !", "DDDDDD","/images/p_C1.jpg"));
        listePromotions.add(new Promotion("CD cool","Marque cool","-100% !", "FFFFFF","/images/p_C2.jpg"));
        listePromotions.add(new Promotion("Livre cool","Marque cool","-100% !", "DDDDDD","/images/p_L3.jpg"));
        listePromotions.add(new Promotion("DVD cool","Marque cool","-100% !", "FFFFFF","/images/p_D3.jpg"));
        listePromotions.add(new Promotion("Stage cool","Marque cool","-100% !", "DDDDDD","/images/p_S3.jpg"));
    }

    public ObservableList<Promotion> getListePromotions() {
        return listePromotions;
    }
}
