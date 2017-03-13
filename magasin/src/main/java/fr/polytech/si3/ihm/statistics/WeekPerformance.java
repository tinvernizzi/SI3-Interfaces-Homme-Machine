package fr.polytech.si3.ihm.statistics;

import javafx.scene.Scene;
import javafx.scene.chart.*;
import javafx.stage.Stage;

public class WeekPerformance extends VendorsGraph {

    public void displayLastWeekPerformance(Stage stage) {
        stage.setTitle("Performances des vendeurs la semaine dernière, semaine 08");
        final CategoryAxis xAxis = new CategoryAxis();
        final NumberAxis yAxis = new NumberAxis();
        xAxis.setLabel("Jour");
        yAxis.setLabel("Ventes en euros");
        final StackedBarChart<String,Number> lineChart =
                new StackedBarChart<String,Number>(xAxis,yAxis);

        lineChart.setTitle("Performances des vendeurs la semaine dernière, semaine 08");

        XYChart.Series series1 = new XYChart.Series();
        series1.setName("Lorem");

        series1.getData().add(new XYChart.Data("LUN", 230));
        series1.getData().add(new XYChart.Data("MAR", 140));
        series1.getData().add(new XYChart.Data("MER", 150));
        series1.getData().add(new XYChart.Data("JEU", 240));

        XYChart.Series series2 = new XYChart.Series();
        series2.setName("Ipsum");
        series2.getData().add(new XYChart.Data("LUN", 330));
        series2.getData().add(new XYChart.Data("MAR", 340));
        series2.getData().add(new XYChart.Data("VEN", 390));
        series2.getData().add(new XYChart.Data("SAM", 160));

        XYChart.Series series3 = new XYChart.Series();
        series3.setName("Dolor");
        series3.getData().add(new XYChart.Data("MER", 360));
        series3.getData().add(new XYChart.Data("JEU", 330));
        series3.getData().add(new XYChart.Data("VEN", 310));
        series3.getData().add(new XYChart.Data("SAM", 260));

        Scene scene  = new Scene(lineChart,800,600);
        lineChart.getData().addAll(series1, series2, series3);

        stage.setScene(scene);
        stage.show();
    }

    public void start() throws Exception {
        Stage stage = new Stage();
        this.displayLastWeekPerformance(stage);
    }
}