package fr.polytech.si3.ihm.controller;

import fr.polytech.si3.ihm.controller.elements.InfoListController;
import fr.polytech.si3.ihm.model.Info;
import fr.polytech.si3.ihm.model.ListeInfos;
import javafx.beans.value.ObservableValue;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.control.ListCell;
import javafx.scene.control.ListView;
import javafx.util.Callback;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.IOException;

public class InfoController extends Controller {

    private static final Logger log = LoggerFactory.getLogger(InfoController.class);

    @FXML
    private ListView<Info> listeinfo;

    @FXML
    public void initialize() {
        displayHeader(this);
        displayContact();
        displayInfos();
    }

    private void displayInfos() {
        ObservableList<Info> liste = new ListeInfos().getListeInfos();
        this.listeinfo.setPrefHeight(188 * liste.size());
        this.listeinfo.setItems(liste);
        this.listeinfo.setCellFactory(
                new Callback<ListView<Info>, ListCell<Info>>() {
                    public ListCell<Info> call(ListView<Info> listView) {
                        return new ListCell<Info>() {
                            protected void updateItem(Info item, boolean empty) {
                                super.updateItem(item, empty);
                                if (item != null) {
                                    try {
                                        String fxmlFile = "/fxml/elements/info_list_info_element.fxml";
                                        FXMLLoader loader = new FXMLLoader();
                                        Parent listElement = loader.load(getClass().getResourceAsStream(fxmlFile));
                                        ((InfoListController) loader.getController()).initInfo(item);
                                        this.setGraphic(listElement);
                                    } catch (IOException e) {
                                        e.printStackTrace();
                                    }
                                }
                            }
                        };
                    }
                }
        );
    }
}
