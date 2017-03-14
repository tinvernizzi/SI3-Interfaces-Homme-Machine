package fr.polytech.si3.ihm.controller.elements;

import javafx.fxml.FXML;
import javafx.scene.text.Text;

public class ContactController {

    @FXML
    private Text address;

    @FXML
    private Text phone;

    @FXML
    private Text mailaddress;

    @FXML
    public void initialize() {
        address.setText("Addresse :\n13 Rue de Lorem\n06500 Nice");
        phone.setText("Tél. :\n+33 4 61 XX XX XX");
        mailaddress.setText("Adresse Mail :\ncontact@tobeortohave.com");
    }
}
