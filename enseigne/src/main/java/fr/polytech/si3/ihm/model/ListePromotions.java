package fr.polytech.si3.ihm.model;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

import java.util.ArrayList;

public class ListePromotions {

    private ObservableList<Promotion> listePromotions;

    public ListePromotions() {

        listePromotions = FXCollections.observableArrayList(new ArrayList<Promotion>());
        listePromotions.add(new Promotion("CD Relaxation","Les Indispensables","-15%", "FFFFFF","/images/p_C2.jpg"));
        listePromotions.add(new Promotion("Livre Massage","Docteur Chen","-30%", "DDDDDD","/images/p_L3.jpg"));
        listePromotions.add(new Promotion("DVD Bien-être","-","2 pour le prix d'1", "FFFFFF","/images/p_D3.jpg"));listePromotions.add(new Promotion("Stage nature","Clairière des saveurs","-50%", "DDDDDD","/images/p_S3.jpg"));
    }

    public ObservableList<Promotion> getListePromotions() {
        return listePromotions;
    }
}
