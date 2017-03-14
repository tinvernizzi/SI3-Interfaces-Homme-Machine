package fr.polytech.si3.ihm.promotion;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.image.ImageView;
import javafx.stage.Stage;

import java.io.IOException;

/**
 * Created by Almond on 14/03/2017.
 */
public class Controller {
    @FXML
    private ImageView image;

    @FXML
    private Label title;

    @FXML
    private Label reduction;

    @FXML
    private Label description;

    @FXML
    private Button button;

    @FXML
    void toBoutique(ActionEvent event) throws IOException {
        Parent root = FXMLLoader.load(getClass().getResource("/fxml/templateBoutique.fxml"));
        Stage primaryStage = (Stage) button.getScene().getWindow();
        primaryStage.setTitle("Boutique");
        primaryStage.setScene(new Scene(root));
        primaryStage.show();
    }

    public void init(Model promo) {
        image.setImage(promo.getImage());
        title.setText(promo.getTitle());
        reduction.setText(promo.getReduction());
        description.setText(promo.getDescription());
    }
}
