package fr.polytech.si3.ihm.controllers;

import fr.polytech.si3.ihm.model.SlideShowContent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.HBox;

/**
 * Created by Antoine on 3/1/2017.
 */
public class SlideshowController implements  Controller{


    @FXML
    public AnchorPane anchorPane;
    @FXML
    public HBox bubbles;
    @FXML
    private Button button;

    private SlideShow slideShow;
    private SlideShowContent slideShowContent;

    @FXML
    void clickOnButton(MouseEvent event){
    }

    public void clickOnLeftArrow(MouseEvent event) {
        slideShow.goLeft();
    }

    public void clickOnRightArrow(MouseEvent event) {
        slideShow.goRight();
    }

    @FXML
    public void start(MainController mainController) {
        this.slideShow = new SlideShow(mainController.getSlideShowContent(),anchorPane,this);
        this.slideShowContent = mainController.getSlideShowContent();
        slideShow.startAnimation();
    }

    public void onClickOnContactField(MouseEvent mouseEvent) {
        System.out.println("carte");
    }
}
