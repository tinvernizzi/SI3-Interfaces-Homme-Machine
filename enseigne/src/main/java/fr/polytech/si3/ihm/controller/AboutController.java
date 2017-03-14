package fr.polytech.si3.ihm.controller;

import javafx.fxml.FXML;
import javafx.scene.text.Text;

public class AboutController extends Controller {

    public Text enseigneDescription;

    @FXML
    public void initialize() {
        displayHeader(this);
        displayContact();
        String description = "Lorem ipsum dolor sit amet, consectetur adipiscing elit. Curabitur neque orci, pharetra quis porttitor sit amet, maximus eget arcu. Phasellus non tortor vel mauris cursus convallis sed at nulla. Praesent venenatis semper volutpat. Phasellus et erat eu ipsum convallis volutpat. Fusce non purus in enim pharetra molestie. Curabitur fermentum venenatis dolor congue aliquam. Suspendisse ut vulputate dolor. Sed tincidunt gravida nunc eget bibendum. Praesent elementum mi vitae urna elementum commodo. Nullam tempus lacus sed fermentum placerat.";
        enseigneDescription.setText(description);
    }
}
