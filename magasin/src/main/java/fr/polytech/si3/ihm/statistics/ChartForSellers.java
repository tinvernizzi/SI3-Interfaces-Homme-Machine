package fr.polytech.si3.ihm.statistics;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.chart.*;
import javafx.stage.Stage;


public class ChartForSellers extends Application {

    public void display12MonthsPerformance(Stage stage) {
        stage.setTitle("Performances des vendeurs sur les 12 derniers mois");
        final CategoryAxis xAxis = new CategoryAxis();
        final NumberAxis yAxis = new NumberAxis();
        xAxis.setLabel("Mois");
        yAxis.setLabel("Ventes en euros");
        final LineChart<String,Number> lineChart =
                new LineChart<String,Number>(xAxis,yAxis);

        lineChart.setTitle("Performances des vendeurs, 2016");

        XYChart.Series series1 = new XYChart.Series();
        series1.setName("Lorem");

        series1.getData().add(new XYChart.Data("Jan", 2300));
        series1.getData().add(new XYChart.Data("Feb", 1400));
        series1.getData().add(new XYChart.Data("Mar", 1500));
        series1.getData().add(new XYChart.Data("Apr", 2400));
        series1.getData().add(new XYChart.Data("May", 3400));
        series1.getData().add(new XYChart.Data("Jun", 3600));
        series1.getData().add(new XYChart.Data("Jul", 2200));
        series1.getData().add(new XYChart.Data("Aug", 4500));
        series1.getData().add(new XYChart.Data("Sep", 4300));
        series1.getData().add(new XYChart.Data("Oct", 1700));
        series1.getData().add(new XYChart.Data("Nov", 2900));
        series1.getData().add(new XYChart.Data("Dec", 2500));

        XYChart.Series series2 = new XYChart.Series();
        series2.setName("Ipsum");
        series2.getData().add(new XYChart.Data("Jan", 3300));
        series2.getData().add(new XYChart.Data("Feb", 3400));
        series2.getData().add(new XYChart.Data("Mar", 2500));
        series2.getData().add(new XYChart.Data("Apr", 4400));
        series2.getData().add(new XYChart.Data("May", 3900));
        series2.getData().add(new XYChart.Data("Jun", 1600));
        series2.getData().add(new XYChart.Data("Jul", 5500));
        series2.getData().add(new XYChart.Data("Aug", 5400));
        series2.getData().add(new XYChart.Data("Sep", 4800));
        series2.getData().add(new XYChart.Data("Oct", 2700));
        series2.getData().add(new XYChart.Data("Nov", 3700));
        series2.getData().add(new XYChart.Data("Dec", 2900));

        XYChart.Series series3 = new XYChart.Series();
        series3.setName("Dolor");
        series3.getData().add(new XYChart.Data("Jan", 4400));
        series3.getData().add(new XYChart.Data("Feb", 3500));
        series3.getData().add(new XYChart.Data("Mar", 3600));
        series3.getData().add(new XYChart.Data("Apr", 3300));
        series3.getData().add(new XYChart.Data("May", 3100));
        series3.getData().add(new XYChart.Data("Jun", 2600));
        series3.getData().add(new XYChart.Data("Jul", 2450));
        series3.getData().add(new XYChart.Data("Aug", 2500));
        series3.getData().add(new XYChart.Data("Sep", 4300));
        series3.getData().add(new XYChart.Data("Oct", 4400));
        series3.getData().add(new XYChart.Data("Nov", 4500));
        series3.getData().add(new XYChart.Data("Dec", 4400));

        Scene scene  = new Scene(lineChart,800,600);
        lineChart.getData().addAll(series1, series2, series3);

        stage.setScene(scene);
        stage.show();
    }

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


    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) throws Exception {
        this.display12MonthsPerformance(primaryStage);
    }
}