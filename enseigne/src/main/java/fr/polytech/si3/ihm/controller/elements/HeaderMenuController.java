package fr.polytech.si3.ihm.controller.elements;

import fr.polytech.si3.ihm.MainApp;
import fr.polytech.si3.ihm.controller.*;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;

import java.io.IOException;

public class HeaderMenuController {

    private final static String stylesheet = MainApp.getStyleSheet();

    @FXML
    private Button homeButton;

    @FXML
    private Button promoButton;

    @FXML
    private Button infoButton;

    @FXML
    private Button productButton;

    @FXML
    private Button shopsButton;

    @FXML
    private Button aboutButton;

    @FXML
    public void initialize(Controller currentController) {

        if (currentController instanceof HomeController) {
            homeButton.getStyleClass().remove("headerButton");
            homeButton.getStyleClass().add("headerCurrentButton");
        } else if (currentController instanceof PromoController) {
            promoButton.getStyleClass().remove("headerButton");
            promoButton.getStyleClass().add("headerCurrentButton");
        } else if (currentController instanceof InfoController) {
            infoButton.getStyleClass().remove("headerButton");
            infoButton.getStyleClass().add("headerCurrentButton");
        } else if (currentController instanceof ProductsController) {
            productButton.getStyleClass().remove("headerButton");
            productButton.getStyleClass().add("headerCurrentButton");
        } else if (currentController instanceof ShopsController) {
            shopsButton.getStyleClass().remove("headerButton");
            shopsButton.getStyleClass().add("headerCurrentButton");
        } else if (currentController instanceof AboutController) {
            aboutButton.getStyleClass().remove("headerButton");
            aboutButton.getStyleClass().add("headerCurrentButton");
        }

        homeButton.setOnMouseClicked(new EventHandler<MouseEvent>() {
            public void handle(MouseEvent event) {
                FXMLLoader loader = new FXMLLoader();
                try {
                    Stage stage = (Stage) homeButton.getScene().getWindow();
                    Parent rootNode = loader.load(getClass().getResourceAsStream("/fxml/home.fxml"));
                    Scene scene = new Scene(rootNode);
                    scene.getStylesheets().add(stylesheet);
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
                    Parent rootNode = loader.load(getClass().getResourceAsStream("/fxml/promo.fxml"));
                    Scene scene = new Scene(rootNode);
                    scene.getStylesheets().add(stylesheet);
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
                    Parent rootNode = loader.load(getClass().getResourceAsStream("/fxml/info.fxml"));
                    Scene scene = new Scene(rootNode);
                    scene.getStylesheets().add(stylesheet);
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
                    scene.getStylesheets().add(stylesheet);
                    stage.setScene(scene);
                    stage.show();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        });

        shopsButton.setOnMouseClicked(new EventHandler<MouseEvent>() {
            public void handle(MouseEvent event) {
                FXMLLoader loader = new FXMLLoader();
                try {
                    Stage stage = (Stage) shopsButton.getScene().getWindow();
                    Parent rootNode = loader.load(getClass().getResourceAsStream("/fxml/shops.fxml"));
                    Scene scene = new Scene(rootNode);
                    scene.getStylesheets().add(stylesheet);
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
                    scene.getStylesheets().add(stylesheet);
                    stage.setScene(scene);
                    stage.show();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        });
    }
}
