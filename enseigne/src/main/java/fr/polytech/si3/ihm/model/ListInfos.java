package fr.polytech.si3.ihm.model;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.scene.paint.Color;

import java.util.ArrayList;

public class ListInfos {

    private ObservableList<Info> listInfos;

    public ListInfos() {

        listInfos = FXCollections.observableArrayList(new ArrayList<Info>());
        listInfos.add(new Info("Ouverte Exceptionnelle","A tous les magasins à Nice", Color.BLUE,"/images/information.png"));
        listInfos.add(new Info("Dernier Produits","Nouveaux livres, DVD", Color.BLUE,"/images/information.png"));
        listInfos.add(new Info("BestSellers","Best Sellers à 2016", Color.BLUE,"/images/information.png"));
    }

    public ObservableList<Info> getListInfos() {
        return listInfos;
    }

}
