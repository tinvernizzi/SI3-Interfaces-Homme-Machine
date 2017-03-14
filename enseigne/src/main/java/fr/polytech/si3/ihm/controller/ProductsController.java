package fr.polytech.si3.ihm.controller;

import fr.polytech.si3.ihm.controller.elements.ProductGridController;
import fr.polytech.si3.ihm.model.ListeProduits;
import fr.polytech.si3.ihm.model.Produit;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.layout.GridPane;

import java.io.IOException;

public class ProductsController extends Controller {

    @FXML
    public GridPane gridDisplay;

    @FXML
    public void initialize() {
        displayHeader(this);
        displayProductGrid();
        displayContact();
    }

    public void displayProductGrid() {

        ListeProduits listeProduits = new ListeProduits();
        int i = 0, j = 0;
        for (Produit p : listeProduits.getListeProduits()) {
            String fxmlFile = "/fxml/elements/products_grid_produit_element.fxml";
            FXMLLoader loader = new FXMLLoader();
            try {
                Parent rootNode = loader.load(getClass().getResourceAsStream(fxmlFile));
                ((ProductGridController) loader.getController()).initProduit(p);

                gridDisplay.add(rootNode, i, j);
            } catch (IOException e) {
                e.printStackTrace();
            }
            i++;
            j += ((i%=4) == 0 ? 1 : 0);
        }
    }
}
