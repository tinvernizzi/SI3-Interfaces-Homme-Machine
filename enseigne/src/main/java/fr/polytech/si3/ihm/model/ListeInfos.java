package fr.polytech.si3.ihm.model;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

import java.util.ArrayList;

public class ListeInfos {

    private ObservableList<Info> listeInfos;

    public ListeInfos() {

        listeInfos = FXCollections.observableArrayList(new ArrayList<Info>());
        listeInfos.add(new Info("Information 1", "Nouvelle gamme de\nproduits disponibles en mai !", "FFFFFF", "/images/information.png"));
        listeInfos.add(new Info("Information 2", "Fermeture exceptionnelle\ndu S.A.V. en avril", "DDDDDD", "/images/tboth.png"));
        listeInfos.add(new Info("Information 3", "Nouvel arrivage de CD\nen juin", "FFFFFF", "/images/p_C.jpg"));
        listeInfos.add(new Info("Information 4", "J'avais plus d'idées", "DDDDDD", "/images/information.png"));
    }

    public ObservableList<Info> getListeInfos() {
        return listeInfos;
    }

}
