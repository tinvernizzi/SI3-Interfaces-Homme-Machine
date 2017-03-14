package fr.polytech.si3.ihm.model;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

import java.util.ArrayList;

public class ListeInfos {

    private ObservableList<Info> listeInfos;

    public ListeInfos() {

        listeInfos = FXCollections.observableArrayList(new ArrayList<Info>());
        listeInfos.add(new Info("Information 1", "Nouvelle gamme de produits disponibles en mai !", "FFFFFF", "/images/information.png"));
        listeInfos.add(new Info("Information 2", "Fermeture exceptionnelle du S.A.V. en avril", "DDDDDD", "/images/tboth.png"));
        listeInfos.add(new Info("Information 3", "Nouvel arrivage de CD en juin", "FFFFFF", "/images/p_C.jpg"));
        listeInfos.add(new Info("Information 4", "Lorem Ipsum Lorem Ipsum Lorem Ipsum Lorem Ipsum Lorem Ipsum Lorem Ipsum ", "DDDDDD", "/images/information.png"));
        listeInfos.add(new Info("Ouverte Exceptionnelle","A tous les magasins à Nice", "AABBFF","/images/information.png"));
        listeInfos.add(new Info("Dernier Produits","Nouveaux livres, DVD", "AABBFF","/images/information.png"));
        listeInfos.add(new Info("BestSellers","Best Sellers à 2016", "AABBFF","/images/information.png"));
    }

    public ObservableList<Info> getListeInfos() {
        return listeInfos;
    }

}
