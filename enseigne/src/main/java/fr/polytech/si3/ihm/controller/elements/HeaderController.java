package fr.polytech.si3.ihm.controller.elements;

import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;

import java.io.IOException;

public class HeaderController {

    @FXML
    private Button homeButton;

    @FXML
    private Button promoButton;

    @FXML
    private Button infoButton;

    @FXML
    private Button productButton;

    @FXML
    private Button aboutButton;

    @FXML
    public void initialize() {

        assert homeButton != null;
        assert promoButton != null;
        assert infoButton != null;
        assert productButton != null;
        assert aboutButton != null;

        homeButton.setOnMouseClicked(new EventHandler<MouseEvent>() {
            public void handle(MouseEvent event) {
                FXMLLoader loader = new FXMLLoader();
                try {
                    Stage stage = (Stage) homeButton.getScene().getWindow();
                    Parent rootNode = loader.load(getClass().getResourceAsStream("/fxml/home.fxml"));
                    Scene scene = new Scene(rootNode);
                    stage.setScene(scene);
                    stage.show();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        });

        promoButton.setOnMouseClicked(new EventHandler<MouseEvent>() {
            public void handle(MouseEvent event) {
                FXMLLoader loader = new FXMLLoader();
                try {
                    Stage stage = (Stage) promoButton.getScene().getWindow();
                    Parent rootNode = loader.load(getClass().getResourceAsStream("/fxml/promos.fxml"));
                    Scene scene = new Scene(rootNode);
                    stage.setScene(scene);
                    stage.show();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        });

        infoButton.setOnMouseClicked(new EventHandler<MouseEvent>() {
            public void handle(MouseEvent event) {
                FXMLLoader loader = new FXMLLoader();
                try {
                    Stage stage = (Stage) infoButton.getScene().getWindow();
                    Parent rootNode = loader.load(getClass().getResourceAsStream("/fxml/infos.fxml"));
                    Scene scene = new Scene(rootNode);
                    stage.setScene(scene);
                    stage.show();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        });

        productButton.setOnMouseClicked(new EventHandler<MouseEvent>() {
            public void handle(MouseEvent event) {
                FXMLLoader loader = new FXMLLoader();
                try {
                    Stage stage = (Stage) productButton.getScene().getWindow();
                    Parent rootNode = loader.load(getClass().getResourceAsStream("/fxml/products.fxml"));
                    Scene scene = new Scene(rootNode);
                    stage.setScene(scene);
                    stage.show();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        });

        aboutButton.setOnMouseClicked(new EventHandler<MouseEvent>() {
            public void handle(MouseEvent event) {
                FXMLLoader loader = new FXMLLoader();
                try {
                    Stage stage = (Stage) aboutButton.getScene().getWindow();
                    Parent rootNode = loader.load(getClass().getResourceAsStream("/fxml/about.fxml"));
                    Scene scene = new Scene(rootNode);
                    stage.setScene(scene);
                    stage.show();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        });
    }

}
