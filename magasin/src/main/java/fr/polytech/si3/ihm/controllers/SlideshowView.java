package fr.polytech.si3.ihm.controllers;

import javafx.fxml.FXML;
import javafx.scene.input.MouseEvent;

/**
 * Created by Antoine on 3/1/2017.
 */
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.image.ImageView;
import javafx.scene.layout.VBox;

public class SlideshowView {

    @FXML
    private ImageView image0;

    @FXML
    private ImageView image1;

    @FXML
    private ImageView image2;

    @FXML
    private VBox menu;

    @FXML
    private ImageView leftArrow;

    @FXML
    private ImageView rightArrow;

    @FXML
    private Button button;

    @FXML
    private Label scheduleTitle;

    @FXML
    private Label scheduleTimes;

    @FXML
    private Label locationTitle;

    @FXML
    private Label LocationDescription;

    @FXML
    private ImageView bubble0;

    @FXML
    private ImageView bubble1;

    @FXML
    private ImageView bubble2;

    @FXML
    private ImageView bubble3;

    @FXML
    void OnMouseCliked(MouseEvent event) {
        System.out.println("Cliked!");
    }

    public void test(String s) {
        System.out.println(s);
    }
}
