package fr.polytech.si3.ihm.model;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

import java.util.ArrayList;

public class ListeInfos {

    private ObservableList<Info> listeInfos;

    public ListeInfos() {

        listeInfos = FXCollections.observableArrayList(new ArrayList<Info>());
        listeInfos.add(new Info("Best Sellers de 2016", "La liste des Best Sellers de l'année 2016 est enfin disponible !", "FFFFFF", "/images/information.png"));
        listeInfos.add(new Info("Ouverte Exceptionnelle", "Tous nos magasins seront exceptionnellement ouverts le Dimanche 30 Février", "DDDDDD", "/images/tboth.png"));
        listeInfos.add(new Info("Nouvelle gamme", "Nouvelle gamme de produits disponibles dès mai !", "FFFFFF", "/images/p_C.jpg"));
        listeInfos.add(new Info("Information 4", "Lorem Ipsum Lorem Ipsum Lorem Ipsum Lorem Ipsum Lorem Ipsum Lorem Ipsum ", "DDDDDD", "/images/information.png"));
    }

    public ObservableList<Info> getListeInfos() {
        return listeInfos;
    }

}
