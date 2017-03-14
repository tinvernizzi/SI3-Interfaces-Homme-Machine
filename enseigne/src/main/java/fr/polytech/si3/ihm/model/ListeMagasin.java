package fr.polytech.si3.ihm.model;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

import java.util.ArrayList;

/**
 * Created by user on 14/03/2017.
 */
public class ListeMagasin {

    private ObservableList<Magasin> listeMagasins;

    public ListeMagasin(){

        listeMagasins = FXCollections.observableArrayList(new ArrayList<Magasin>());
        listeMagasins.add(new Magasin("NiceUni","Nice","Alpes-Maritimes"));
        listeMagasins.add(new Magasin("AntibesEmpire","Antibes","Alpes-Maritimes"));
        listeMagasins.add(new Magasin("CannesPalais","Cannes","Alpes-Maritimes"));
    }

    public ObservableList<Magasin> getListeMagasins() {
        return listeMagasins;
    }
}
