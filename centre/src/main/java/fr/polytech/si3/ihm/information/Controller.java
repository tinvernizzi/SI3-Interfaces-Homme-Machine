package fr.polytech.si3.ihm.information;

/**
 * Created by Almond on 12/03/2017.
 */

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Hyperlink;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;

public class Controller {
    @FXML
    private TableView<Model> tableHours;

    @FXML
    private TableColumn<Model, String> opDate;

    @FXML
    private TableColumn<Model, String> opHour;

    @FXML
    private TableView<Model> tableExcept;

    @FXML
    private TableColumn<Model, String> exDate;

    @FXML
    private TableColumn<Model, String> exHour;

    @FXML
    private Hyperlink mailAddress;

    @FXML
    public void initialize() {
        final ObservableList<Model> openingHours = FXCollections.observableArrayList(
                new Model("Lun", "09:00 à 19:00"),
                new Model("Mar", "09:00 à 19:00"),
                new Model("Mer", "09:00 à 19:00"),
                new Model("Jeu", "09:00 à 19:00"),
                new Model("Ven", "09:00 à 19:00"),
                new Model("Sam", "09:00 à 19:00"),
                new Model("Dim", "10:00 à 18:00")
        );

        opDate.setCellValueFactory(new PropertyValueFactory<Model, String>("day"));
        opHour.setCellValueFactory(new PropertyValueFactory<Model, String>("openingHour"));

        tableHours.setItems(openingHours);
        tableHours.getColumns().addAll(opDate, opHour);

        final ObservableList<Model> exceptionalOpening = FXCollections.observableArrayList(
                new Model("Lun 17 avr - Pâques", "11:00 à 19h00"),
                new Model("Jeu 25 mai - Ascension", "11:00 à 19h00"),
                new Model("Dim 28 mai - Fête des mères", "11:00 à 19h00")
        );

        exDate.setCellValueFactory(new PropertyValueFactory<Model, String>("day"));
        exHour.setCellValueFactory(new PropertyValueFactory<Model, String>("openingHour"));

        tableExcept.setItems(exceptionalOpening);
        tableExcept.getColumns().addAll(exDate, exHour);
    }

    @FXML
    void toMail(ActionEvent event) {

    }

}

