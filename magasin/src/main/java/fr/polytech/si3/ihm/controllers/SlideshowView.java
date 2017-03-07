package fr.polytech.si3.ihm.controllers;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
/**
 * Created by Antoine on 3/1/2017.
 */
public class SlideshowView {


    @FXML
    public AnchorPane anchorPane;

    @FXML
    private ImageView leftArrow;

    @FXML
    private ImageView rightArrow;

    @FXML
    private Button button;
    private ImageSlide slider;

    /*@FXML
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
    private ImageView bubble3;*/

    @FXML
    void clickOnButton(MouseEvent event){
        System.out.println("button clicked");
    }

    public void test(String s) {
        System.out.println(s);
    }

    public void clickOnLeftArrow(MouseEvent event) {
        System.out.println("left");
        slider.goLeft();
    }

    public void clickOnRightArrow(MouseEvent event) {
        System.out.println("right");
        slider.goRight();
    }

    public void start() {
        this.slider = new ImageSlide(anchorPane);
        slider.startAnimation();
    }
}
