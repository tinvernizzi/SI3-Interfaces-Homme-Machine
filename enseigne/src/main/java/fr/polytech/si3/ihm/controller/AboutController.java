package fr.polytech.si3.ihm.controller;

import javafx.fxml.FXML;
import javafx.scene.text.Text;

public class AboutController extends Controller {

    public Text enseigneDescription;

    @FXML
    public void initialize() {
        displayHeader(this);
        displayContact();
    }
}
