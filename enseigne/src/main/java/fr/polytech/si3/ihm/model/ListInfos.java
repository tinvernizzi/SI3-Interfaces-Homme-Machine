package fr.polytech.si3.ihm.model;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

import java.util.ArrayList;

public class ListInfos {

    private ObservableList<Info> listInfos;

    public ListInfos() {

        listInfos = FXCollections.observableArrayList(new ArrayList<Info>());
    }

    public ObservableList<Info> getListInfos() {
        return listInfos;
    }

}
