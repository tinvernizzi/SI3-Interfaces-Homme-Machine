package fr.polytech.si3.ihm.controllers;

import fr.polytech.si3.ihm.model.*;
import fr.polytech.si3.ihm.statistics.MeansOfSaleGraph;
import fr.polytech.si3.ihm.statistics.MonthsPerformance;
import fr.polytech.si3.ihm.statistics.WeekPerformance;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.scene.input.MouseEvent;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

/**
 * Created by tanguy on 12/03/17.
 */
public class AdministrationPageController implements Controller {

    @FXML
    public Button lastWeekPerf;

    @FXML
    public Button lastMonthsPerf;

    @FXML
    public ListView<String> listOfProducts;
    public Label produitSelect;
    public CheckBox isOnPromo;
    public TextField normalPrice;
    public TextField reducPrice;
    public Button registerButton;
    public Button lastMonthsMeansOfSale;
    public TextField webPage;
    public TextField phoneNumber;
    public TextField adress;
    public Button buttonRegister;
    public TextField jeudi;
    public TextField vendredi;
    public TextField mercredi;
    public TextField dimanche;
    public TextField mardi;
    public TextField samedi;
    public TextField lundi;

    @FXML
    private TableView<Vendeur> statVendeurs;

    @FXML
    private TableColumn<Vendeur, String> jour;

    @FXML
    private TableColumn<Vendeur, String> vendeur;

    @FXML
    private TableColumn<Vendeur, String> sales;
    private ProductDatabase database;
    private Product itemCurrentlySelected;
    private Contact contact;


    public void displayLastWeekPerformance(MouseEvent mouseEvent) throws Exception {
        WeekPerformance graph = new WeekPerformance();
        graph.start();
    }

    public void display12MonthsPerformance(MouseEvent mouseEvent) throws Exception {
        MonthsPerformance graph = new MonthsPerformance();
        graph.start();
    }

    public void start(MainController mainController) {
        this.database = mainController.getProductDatabase();
        this.contact = mainController.getContactInformations();
        
        ArrayList<String> productNameList = new ArrayList<>();

        List<Product> allItems = database.getAllItems();

        for (int i = 0; i < allItems.size(); i++) {
            productNameList.add(allItems.get(i).getName());
        }

        listOfProducts.setEditable(true);

        ObservableList<String> list = FXCollections.observableArrayList(productNameList);
        listOfProducts.setItems(list);

        webPage.setText(mainController.getContactInformations().getWebPage());
        phoneNumber.setText(mainController.getContactInformations().getPhoneNumber());
        adress.setText(mainController.getContactInformations().getAdress());

        List<Schedule> schedules = mainController.getContactInformations().getSchedules();
        lundi.setText(schedules.get(0).getOpeningHour());
        mardi.setText(schedules.get(1).getOpeningHour());
        mercredi.setText(schedules.get(2).getOpeningHour());
        jeudi.setText(schedules.get(3).getOpeningHour());
        vendredi.setText(schedules.get(4).getOpeningHour());
        samedi.setText(schedules.get(5).getOpeningHour());
        dimanche.setText(schedules.get(6).getOpeningHour());
    }

    @FXML
    public void clickedOnProduct(MouseEvent mouseEvent) {
        itemCurrentlySelected = database.getItemsByName(database.getAllItems(), listOfProducts.getSelectionModel().getSelectedItem()).get(0);
        isOnPromo.setSelected(itemCurrentlySelected.isOnPromotion());
        if (itemCurrentlySelected.isOnPromotion()) {
            normalPrice.setText(itemCurrentlySelected.getPrixOutsideOfPromotion() + "");
            reducPrice.setText(itemCurrentlySelected.getPrix());
        }
        else {
            normalPrice.setText(itemCurrentlySelected.getPrixOutsideOfPromotion() + "");
            reducPrice.setText("0");
        }
    }

    public void clickToRegisterProduct(MouseEvent mouseEvent) {
        itemCurrentlySelected.setPrix(Integer.parseInt(normalPrice.getText()));
        if (isOnPromo.isSelected()) {
            itemCurrentlySelected.setPromotion(Integer.parseInt(reducPrice.getText()));
        }
        else {
            itemCurrentlySelected.removePromotion();
        }
    }

    public void displayMeansOfSale(MouseEvent mouseEvent) throws Exception {
        MeansOfSaleGraph graph = new MeansOfSaleGraph();
        graph.start();
    }


    public void clickToRegisterContact(MouseEvent mouseEvent) {
        contact.setWebPage(webPage.getText());
        contact.setPhoneNumber(phoneNumber.getText());
        contact.setAdress(adress.getText());
        ArrayList<Schedule> openingHours = new ArrayList<>();

        openingHours.add((new Schedule("Lun", lundi.getText())));
        openingHours.add((new Schedule("Mar", mardi.getText())));
        openingHours.add((new Schedule("Mer", mercredi.getText())));
        openingHours.add((new Schedule("Jeu", jeudi.getText())));
        openingHours.add((new Schedule("Ven", vendredi.getText())));
        openingHours.add((new Schedule("Sam", samedi.getText())));
        openingHours.add((new Schedule("Dim", dimanche.getText())));
        contact.setSchedule(openingHours);
    }
}
