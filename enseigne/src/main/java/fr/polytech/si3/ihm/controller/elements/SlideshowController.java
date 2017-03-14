package fr.polytech.si3.ihm.controller.elements;

import fr.polytech.si3.ihm.model.ImageSlide;
import javafx.fxml.FXML;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;

/**
 * Created by Antoine on 3/1/2017.
 */
public class SlideshowController {


    @FXML
    public AnchorPane anchorPane;

    @FXML
    public ImageView rightArrow;

    @FXML
    public ImageView leftArrow;

    private ImageSlide slider;


    public void clickOnLeftArrow() {
        slider.goLeft();
    }

    public void clickOnRightArrow() {
        slider.goRight();
    }

    @FXML
    public void start() {
        this.slider = new ImageSlide(anchorPane);
        slider.startAnimation();
    }
}
