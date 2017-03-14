package fr.polytech.si3.ihm.controllers;

import fr.polytech.si3.ihm.model.Product;
import fr.polytech.si3.ihm.model.ProductDatabase;
import fr.polytech.si3.ihm.model.Vendeur;
import fr.polytech.si3.ihm.statistics.MonthsPerformance;
import fr.polytech.si3.ihm.statistics.WeekPerformance;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.ListView;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.input.MouseEvent;

import java.util.ArrayList;
import java.util.Collection;

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

    @FXML
    private TableView<Vendeur> statVendeurs;

    @FXML
    private TableColumn<Vendeur, String> jour;

    @FXML
    private TableColumn<Vendeur, String> vendeur;

    @FXML
    private TableColumn<Vendeur, String> sales;


    public void displayLastWeekPerformance(MouseEvent mouseEvent) throws Exception {
        WeekPerformance graph = new WeekPerformance();
        graph.start();
    }

    public void display12MonthsPerformance(MouseEvent mouseEvent) throws Exception {
        MonthsPerformance graph = new MonthsPerformance();
        graph.start();
    }

    public void start(MainController mainController, ProductDatabase database) {
        ArrayList<String> productNameList = new ArrayList<>();

        for (int i = 0; i < database.getAllItems().size(); i++) {
            productNameList.add(database.getAllItems().get(i).getName());
        }

        listOfProducts.setEditable(true);

        ObservableList<String> list = FXCollections.observableArrayList(productNameList);
        listOfProducts.setItems(list);
    }

    @FXML
    public void clickedOnProduct(MouseEvent mouseEvent) {
        System.out.println("clicked on " + listOfProducts.getSelectionModel().getSelectedItem());
    }

    @Override
    public void start(MainController mainController) {
        ArrayList<String> productNameList = new ArrayList<>();

        productNameList.add("Aucun produits ajoutés");

        listOfProducts.setEditable(true);

        ObservableList<String> list = FXCollections.observableArrayList(productNameList);
        listOfProducts.setItems(list);
    }

}
