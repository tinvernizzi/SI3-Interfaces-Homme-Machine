package fr.polytech.si3.ihm.controller;

import fr.polytech.si3.ihm.controller.elements.InfoListController;
import fr.polytech.si3.ihm.model.Info;
import fr.polytech.si3.ihm.model.ListInfos;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.control.ListCell;
import javafx.scene.control.ListView;
import javafx.util.Callback;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.IOException;

/**
 * Created by Elliot on 11/03/2017.
 */
public class InfoController extends Controller {

    private static final Logger log = LoggerFactory.getLogger(InfoController.class);

    @FXML
    private ListView<Info> infos;

    @FXML
    public void initialize() {
        displayHeader();
        displayContact();
        displayInfos();
    }

    private void displayInfos() {
        this.infos.setItems(new ListInfos().getListInfos());
        this.infos.setCellFactory(
                new Callback<ListView<Info>, ListCell<Info>>() {
                    public ListCell<Info> call(ListView<Info> listView) {
                        return new ListCell<Info>() {
                            protected void updateItem(Info item, boolean empty) {
                                super.updateItem(item, empty);
                                if (item != null) {
                                    try {
                                        String fxmlFile = "/fxml/elements/info_list.fxml";
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
