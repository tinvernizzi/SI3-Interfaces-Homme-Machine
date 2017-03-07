package fr.polytech.si3.ihm.controllers;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.scene.image.ImageView;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;

import java.io.IOException;

/**
 * Created by Antoine on 3/7/2017.
 */
public class ContactController {
    @FXML
    public Label phone;
    @FXML
    public Label webPage;
    @FXML
    public ImageView map;
    @FXML
    public ListView schedules;
    @FXML
    public BorderPane contactView;
    @FXML
    public Label address;

    void start(){
        //Set schedules
        ObservableList<String> items = FXCollections.observableArrayList (
                "Lundi - 8h à 19h", "Mardi - 8h à 19h", "Mercredi - 8h à 13h", "Jeudi - 8h à 19h", "Vendredi - 8h à 13h", "Samedi - 8h à 12h", "Dimanche - fermé");
        schedules.setItems(items);
        schedules.setEditable(false);
        schedules.setMouseTransparent(true);
        //set others infos
        address.setText("06600 Antibes");
        phone.setText("06.72.98.21.21");
        webPage.setText("www.tobeortohave.com");
    }

    public Node getNode() {
        return address;
    }
}
