package fr.polytech.si3.ihm.model;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

import java.util.ArrayList;

public class ListeMagasin {

    private ObservableList<Magasin> listeMagasins;

    public ListeMagasin(){

        listeMagasins = FXCollections.observableArrayList(new ArrayList<Magasin>());
        listeMagasins.add(new Magasin("Nice : Uni","Nice","Alpes-Maritimes", "www.tboth-nice.com/"));
        listeMagasins.add(new Magasin("Antibes : Empire","Antibes","Alpes-Maritimes","www.tboth-antibes.com/"));
        listeMagasins.add(new Magasin("Cannes : Palais","Cannes","Alpes-Maritimes", "www.tboth-cannes.com/"));
        listeMagasins.add(new Magasin("Sein oder Haben","Strasbourg","Haut-Rhin", "www.tboth-strasbourg.com/"));
        listeMagasins.add(new Magasin("Paris : Centre TBOTH","Paris","Île-de-France", "www.tboth-paris.com/"));
        listeMagasins.add(new Magasin("Exemple","Lyon","Rhône-Alpes", "www.tboth-lyon.com/"));
    }

    public ObservableList<Magasin> getListeMagasins() {
        return listeMagasins;
    }
}
