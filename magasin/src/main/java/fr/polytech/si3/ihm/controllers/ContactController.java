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
import java.util.ArrayList;
import java.util.List;

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

    ArrayList<Schedule> openingHours;
    
    @Override
    public void start(MainController mainController) {
        openingHours = new ArrayList<Schedule>();

        openingHours.add((new Schedule("Lun", "09:00 à 19:00")));
        openingHours.add((new Schedule("Mar", "09:00 à 19:00")));
        openingHours.add((new Schedule("Mer", "09:00 à 19:00")));
        openingHours.add((new Schedule("Jeu", "09:00 à 19:00")));
        openingHours.add((new Schedule("Ven", "09:00 à 19:00")));
        openingHours.add((new Schedule("Sam", "09:00 à 12:00")));
        openingHours.add((new Schedule("Dim", "Fermé")));

        //Set schedules
        ObservableList<Schedule> horaires = FXCollections.observableArrayList(openingHours);

        date.setCellValueFactory(new PropertyValueFactory<Schedule, String>("day"));
        hour.setCellValueFactory(new PropertyValueFactory<Schedule, String>("openingHour"));
        schedules.setItems(horaires);
        //settings of tableView
        schedules.setEditable(false);
        schedules.setMouseTransparent(true);
        schedules.setColumnResizePolicy(TableView.CONSTRAINED_RESIZE_POLICY);

        //set others infos

        address.setText(mainController.getContactInformations().getAdress());
        phone.setText(mainController.getContactInformations().getPhoneNumber());
        webPage.setText(mainController.getContactInformations().getPhoneNumber());
    }

    public Node getAnchor() {
        return address;
    }

    public String getWebPage() {
        return webPage.getText();
    }

    public String getPhoneNumber() {
        return phone.getText();
    }

    public String getAdress() {
        return address.getText();
    }

    public void setWebPage(String webPage) {
        this.webPage.setText(webPage);
    }

    public void setPhoneNumber(String phoneNumber) {
        phone.setText(phoneNumber);
    }

    public void setAdress(String adress) {
        address.setText(adress);
    }

    public List<Schedule> getHoraires() {
        return openingHours;
    }

    public void setHoraires(List<Schedule> listSchedules) {
        final ObservableList<Schedule> openingHours = FXCollections.observableArrayList(listSchedules);

        date.setCellValueFactory(new PropertyValueFactory<Schedule, String>("day"));
        hour.setCellValueFactory(new PropertyValueFactory<Schedule, String>("openingHour"));
        schedules.setItems(openingHours);
        //settings of tableView
        schedules.setEditable(false);
        schedules.setMouseTransparent(true);
        schedules.setColumnResizePolicy(TableView.CONSTRAINED_RESIZE_POLICY);
    }
}
