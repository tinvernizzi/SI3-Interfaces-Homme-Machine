package fr.polytech.si3.ihm.statistics;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.chart.*;
import javafx.stage.Stage;

/**
 * Created by tanguy on 14/03/17.
 */
public class MeansOfSaleGraph extends VendorsGraph {


    public void start() throws Exception {
        Stage stage = new Stage();
        this.displayMeansOfSaleGraph(stage);
    }

    private void displayMeansOfSaleGraph(Stage stage) {
        Scene scene = new Scene(new Group());
        stage.setTitle("Moyens de vente sur le mois dernier");
        stage.setWidth(500);
        stage.setHeight(500);

        ObservableList<PieChart.Data> pieChartData =
                FXCollections.observableArrayList(
                        new PieChart.Data("Internet, livraison", 13),
                        new PieChart.Data("Internet, récupération", 25),
                        new PieChart.Data("Vente en magasin", 10),
                        new PieChart.Data("Autres", 30));
        final PieChart chart = new PieChart(pieChartData);
        chart.setTitle("Imported Fruits");

        ((Group) scene.getRoot()).getChildren().add(chart);
        stage.setScene(scene);
        stage.show();
    }
}
