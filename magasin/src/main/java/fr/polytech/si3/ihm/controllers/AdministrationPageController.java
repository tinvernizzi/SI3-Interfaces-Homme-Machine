package fr.polytech.si3.ihm.controllers;

import fr.polytech.si3.ihm.statistics.MonthsPerformance;
import fr.polytech.si3.ihm.statistics.WeekPerformance;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.input.MouseEvent;

/**
 * Created by tanguy on 12/03/17.
 */
public class AdministrationPageController implements Controller {

    @FXML
    public Button lastWeekPerf;

    @FXML
    public Button lastMonthsPerf;

    public void displayLastWeekPerformance(MouseEvent mouseEvent) throws Exception {
        WeekPerformance graph = new WeekPerformance();
        graph.start();
    }

    public void display12MonthsPerformance(MouseEvent mouseEvent) throws Exception {
        MonthsPerformance graph = new MonthsPerformance();
        graph.start();
    }

    @Override
    public void start(MainController mainController) {

    }
}
