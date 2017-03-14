package fr.polytech.si3.ihm.controller;

import fr.polytech.si3.ihm.model.Magasin;
import javafx.fxml.FXML;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;

public class ShopsController extends Controller{

    @FXML
    private TableView<Magasin> magasins;

    @FXML
    private TableColumn<Magasin, String> nom;

    @FXML
    private TableColumn<Magasin, String> ville;

    @FXML
    private TableColumn<Magasin, String> region;

    @FXML
    private TableColumn<Magasin, String> site;

    @FXML
    public void initialize() {
        displayMagasins();
        displayHeader(this);
        displayContact();
    }

    private void displayMagasins() {

        // set the table size

        // load the shops in the table

    }
}
