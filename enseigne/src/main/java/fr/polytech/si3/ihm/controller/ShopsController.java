package fr.polytech.si3.ihm.controller;

import fr.polytech.si3.ihm.model.ListeMagasin;
import fr.polytech.si3.ihm.model.Magasin;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;

public class ShopsController extends Controller{

    @FXML
    private TableView<Magasin> magasinsTable;

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
        ObservableList<Magasin> magasin=new ListeMagasin().getListeMagasins();
        nom.setCellValueFactory(cellData -> cellData.getValue().getNameProperty());
        ville.setCellValueFactory(cellData -> cellData.getValue().getCityProperty());
        region.setCellValueFactory(cellData -> cellData.getValue().getRegionProperty());

        magasinsTable.setItems(magasin);

    }
}
