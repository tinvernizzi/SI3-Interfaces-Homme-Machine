package fr.polytech.si3.ihm.model;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

import java.util.ArrayList;

public class ListInfos {

    private ObservableList<Info> listInfos;

    public ListInfos() {

        listInfos = FXCollections.observableArrayList(new ArrayList<Info>());
        listInfos.add(new Info("Information 1", "Nouvelle gamme de\nproduits disponibles en mai !", "FFFFFF", "/images/information.png"));
        listInfos.add(new Info("Information 2", "Fermeture exceptionnelle\ndu service après-vente en avril", "DDDDDD", "/images/tboth.png"));
        listInfos.add(new Info("Information 3", "Nouvel arrivage de CD\nen juin", "FFFFFF", "/images/p_C.jpg"));
        listInfos.add(new Info("Information 4", "J'avais plus d'idées", "DDDDDD", "/images/information.png"));
    }

    public ObservableList<Info> getListInfos() {
        return listInfos;
    }

}
