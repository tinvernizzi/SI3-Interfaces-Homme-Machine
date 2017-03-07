package fr.polytech.si3.ihm;

import fr.polytech.si3.ihm.statistics.MoyenDeVenteGraph;
import javafx.fxml.FXML;
import javafx.scene.web.WebEngine;
import javafx.scene.web.WebView;

import java.io.FileWriter;
import java.io.IOException;

public class StatisticsView {

    @FXML
    private WebView statsViewer;

    public void StatisticsView() throws IOException {

        FileWriter htmlFile1 = new FileWriter("statistics.html");

        htmlFile1.write(" <!DOCTYPE html>\n" +
                "<meta charset ='UTF-8'>" +
                "<script src=\"https://code.highcharts.com/highcharts.js\"></script>\n" +
                "<script src=\"https://code.highcharts.com/modules/exporting.js\"></script>\n" +
                "\n" +
                "<div><a href='Benchmark1.html'>Drone Usage</a> / <a href='Benchmark2.html'>Turns required by each schedule to complete each order with average</a> / <a href='Benchmark3.html'>Score per order</a></div>"+
                "<div id=\"container\" style=\"min-width: 310px; height: 600px; margin: 0 auto\"><script src=\"highcharts1.js\"></script> </div>\n" +
                "\n");

        htmlFile1.close();
    }

    public void generateStatistics() throws IOException {
        WebEngine engine = statsViewer.getEngine();
        MoyenDeVenteGraph graph = new MoyenDeVenteGraph();
        graph.generateJavaScript();
        engine.load("/home/tanguy/IdeaProjects/si3IHM/magasin/highcharts1.js");
    }
}
