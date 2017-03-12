package fr.polytech.si3.ihm.controllers;

import javafx.fxml.FXML;
import javafx.scene.control.CheckBox;
import javafx.scene.input.MouseEvent;

/**
 * Created by user on 12/03/2017.
 */
public class SearchController  implements Controller{

    @FXML
    public CheckBox dvdCheckBox;
    @FXML
    public CheckBox stageCheckBox;
    @FXML
    public CheckBox cdCheckBox;
    @FXML
    public CheckBox bookCheckBox;

    private MainController mainController;
    private ProductsPageController productPageController;

    @Override
    public void start(MainController mainController) {
        this.mainController = mainController;
    }

    public void start(MainController mainController, ProductsPageController productsPageViewController) {
        this.mainController = mainController;
        this.productPageController = productsPageViewController;
    }

    public void onSearchButtonClicked(MouseEvent mouseEvent) {
        System.out.println("search :"+dvdCheckBox.isSelected()+cdCheckBox.isSelected()+bookCheckBox.isSelected()+stageCheckBox.isSelected());
        productPageController.search(dvdCheckBox.isSelected(),cdCheckBox.isSelected(),bookCheckBox.isSelected(),stageCheckBox.isSelected());
    }


}
