package fr.polytech.si3.ihm.controllers;

import javafx.scene.input.MouseEvent;

/**
 * Created by user on 12/03/2017.
 */
public class SearchController  implements Controller{
    private MainController mainController;

    @Override
    public void start(MainController mainController) {
        this.mainController = mainController;
    }

    public void onSearchButtonClicked(MouseEvent mouseEvent) {
        System.out.println("search :");
    }
}
