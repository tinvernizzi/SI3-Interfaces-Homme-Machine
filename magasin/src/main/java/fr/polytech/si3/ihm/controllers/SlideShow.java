package fr.polytech.si3.ihm.controllers;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import fr.polytech.si3.ihm.model.SlideShowContent;
import javafx.animation.*;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Node;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Pane;
import javafx.scene.shape.Rectangle;
import javafx.util.Duration;

public class SlideShow {

    // Width and height of image in pixels
    private final double IMG_WIDTH = 1000;
    private final double IMG_HEIGHT = 400;

    private final int NUM_OF_IMGS;
    private final int SLIDE_FREQ = 4; // in secs
    private final Pane clipPane;
    private final SlideShowContent slideShowContent;
    private final SlideshowController slideShowController;

    private int actualImage = 1;
    HBox imgContainer;
    private Timeline mainAnim;
    private boolean animationIsFinished = true;

    public SlideShow(SlideShowContent slideShowContent, AnchorPane ac, SlideshowController slideshowController){
        this.clipPane = new Pane();
        this.slideShowContent = slideShowContent;
        this.slideShowController = slideshowController;
        // To center the slide show incase maximized
        clipPane.setMaxSize(IMG_WIDTH, IMG_HEIGHT);
        clipPane.setClip(new Rectangle(IMG_WIDTH, IMG_HEIGHT));
        this.imgContainer = new HBox();
        //image view
        List<Node> images = slideShowContent.getImages();
        NUM_OF_IMGS = images.size();
        imgContainer.getChildren().addAll(images);
        clipPane.getChildren().add(imgContainer);
        ac.getChildren().add(clipPane);
        swap(ac);
    }

    public void swap(AnchorPane ac) {
        //Adding clip pane behind
        ObservableList<Node> workingCollection = FXCollections.observableArrayList(
                ac.getChildren()
        );

        Collections.swap(workingCollection, 0,1);
        ac.getChildren().setAll(workingCollection);
    }

    //start animation
    public void startAnimation() {
        //slide action
        EventHandler<ActionEvent> slideAction = (ActionEvent t) -> {
            TranslateTransition trans = new TranslateTransition(Duration.seconds(1.5), imgContainer);
            trans.setByX(-IMG_WIDTH);
            trans.setInterpolator(Interpolator.EASE_BOTH);
            trans.play();
        };
        //eventHandler
        EventHandler<ActionEvent> resetAction = (ActionEvent t) -> {
            TranslateTransition trans = new TranslateTransition(Duration.seconds(1), imgContainer);
            trans.setByX((NUM_OF_IMGS - 1) * IMG_WIDTH);
            trans.setInterpolator(Interpolator.EASE_BOTH);
            trans.play();
        };

        List<KeyFrame> keyFrames = new ArrayList<>();
        for (int i = 1; i <= NUM_OF_IMGS; i++) {
            if (i == NUM_OF_IMGS) {
                keyFrames.add(new KeyFrame(Duration.seconds(i * SLIDE_FREQ), resetAction));
            } else {
                keyFrames.add(new KeyFrame(Duration.seconds(i * SLIDE_FREQ), slideAction));
            }
        }
        //add timeLine
        this.mainAnim = new Timeline(keyFrames.toArray(new KeyFrame[NUM_OF_IMGS]));

        mainAnim.setCycleCount(Timeline.INDEFINITE);
        mainAnim.playFromStart();
    }

    public void goRight() {
        if(actualImage+1<=NUM_OF_IMGS) {
            translate(-1);
        }
    }

    public void goLeft() {
        if(actualImage-1>0){
            translate(1);
        }
    }

    public void translate(int sign){
        if(animationIsFinished) {
            mainAnim.stop();
            setAnimationIsFinished(false);
            actualImage-=sign;
            EventHandler<ActionEvent> slideAction = (ActionEvent t) -> {
                TranslateTransition  trans = new TranslateTransition(Duration.seconds(0.5), imgContainer);
                trans.setByX(sign*IMG_WIDTH);
                trans.setInterpolator(Interpolator.EASE_BOTH);
                trans.play();
            };
            List<KeyFrame> keyFrames = new ArrayList<>();
            keyFrames.add(new KeyFrame(Duration.seconds(0.1), slideAction));
            Animation anim = new Timeline(keyFrames.toArray(new KeyFrame[0]));
            anim.setCycleCount(1);
            anim.setOnFinished(e -> setAnimationIsFinished(true));

            anim.play();
        }
    }

    public void setAnimationIsFinished(boolean animationIsFinished) {
        this.animationIsFinished = animationIsFinished;
    }

}
