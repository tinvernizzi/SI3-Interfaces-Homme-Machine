package fr.polytech.si3.ihm.controllers;

import fr.polytech.si3.ihm.model.Schedule;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.image.ImageView;
import javafx.scene.layout.BorderPane;
import javafx.scene.text.Font;
import javafx.stage.Stage;

import java.io.IOException;

import static java.lang.Double.MAX_VALUE;

/**
 * Created by Antoine on 3/7/2017.
 */
public class ContactController implements Controller{
    @FXML
    public Label phone;
    @FXML
    public Label webPage;
    @FXML
    public ImageView map;
    @FXML
    public TableView schedules;
    @FXML
    public BorderPane contactView;
    @FXML
    public Label address;
    @FXML
    public TableColumn date;
    @FXML
    public TableColumn hour;
    @FXML
    public Label title;

    @Override
    public void start(MainController mainController) {
        //Set schedules
        final ObservableList<Schedule> openingHours = FXCollections.observableArrayList(
                new Schedule("Lun", "09:00 à 19:00"),
                new Schedule("Mar", "09:00 à 19:00"),
                new Schedule("Mer", "09:00 à 19:00"),
                new Schedule("Jeu", "09:00 à 19:00"),
                new Schedule("Ven", "09:00 à 19:00"),
                new Schedule("Sam", "09:00 à 12:00"),
                new Schedule("Dim", "Fermé")
        );

        date.setCellValueFactory(new PropertyValueFactory<Schedule, String>("day"));
        hour.setCellValueFactory(new PropertyValueFactory<Schedule, String>("openingHour"));
        schedules.setItems(openingHours);
        //settings of tableView
        schedules.setEditable(false);
        schedules.setMouseTransparent(true);
        schedules.setColumnResizePolicy(TableView.CONSTRAINED_RESIZE_POLICY);

        //set others infos
        address.setText("06600 Antibes");
        phone.setText("06.72.98.21.21");
        webPage.setText("www.tobeortohave.com");
    }

    public Node getAnchor() {
        return address;
    }
}
