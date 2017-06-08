package fr.polytech.si3.ihm.controllers;

import fr.polytech.si3.ihm.model.Contact;
import fr.polytech.si3.ihm.model.Schedule;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
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
import javafx.scene.layout.HBox;
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
    @FXML
    public HBox content;

    private List<Schedule> openingHours;
    
    @Override
    public void start(MainController mainController) {
        Contact contact = mainController.getContactInformations();

        //Set schedules
        openingHours = contact.getSchedules();
        ObservableList<Schedule> horaires = FXCollections.observableArrayList(openingHours);
        date.setCellValueFactory(new PropertyValueFactory<Schedule, String>("day"));
        hour.setCellValueFactory(new PropertyValueFactory<Schedule, String>("openingHour"));
        schedules.setItems(horaires);
        //settings of tableView
        schedules.setEditable(false);
        schedules.setMouseTransparent(true);
        schedules.setColumnResizePolicy(TableView.CONSTRAINED_RESIZE_POLICY);

        //set others infos
        address.setText(contact.getAdress());
        phone.setText(contact.getPhoneNumber());
        webPage.setText(contact.getWebPage());


        try {
            String fxmlFile = "/fxml/plugins/map.fxml";
            FXMLLoader loader = new FXMLLoader();
            Parent map = loader.load(getClass().getResourceAsStream(fxmlFile));
//            ((GMapsController) loader.getController()).mapInitialized();
            content.getChildren().add(map);
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    public Node getAnchor() {
        return address;
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
