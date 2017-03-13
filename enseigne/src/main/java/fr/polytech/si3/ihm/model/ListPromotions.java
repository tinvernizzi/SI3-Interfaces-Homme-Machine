package fr.polytech.si3.ihm.model;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.scene.paint.Color;

import java.util.ArrayList;

public class ListPromotions {

    private ObservableList<Promotion> listPromotions;

    public ListPromotions() {

        listPromotions = FXCollections.observableArrayList(new ArrayList<Promotion>());
        listPromotions.add(new Promotion("CD cool","Marque cool","-100% !", "FFFFFF","/images/p_C3.jpg"));
        listPromotions.add(new Promotion("CD cool","Marque cool","-100% !", "DDDDDD","/images/p_C1.jpg"));
        listPromotions.add(new Promotion("CD cool","Marque cool","-100% !", "FFFFFF","/images/p_C2.jpg"));
        listPromotions.add(new Promotion("Livre cool","Marque cool","-100% !", "DDDDDD","/images/p_L3.jpg"));
        listPromotions.add(new Promotion("DVD cool","Marque cool","-100% !", "FFFFFF","/images/p_D3.jpg"));
        listPromotions.add(new Promotion("Stage cool","Marque cool","-100% !", "DDDDDD","/images/p_S3.jpg"));
    }

    public ObservableList<Promotion> getListPromotions() {
        return listPromotions;
    }
}
