package fr.polytech.si3.ihm.controllers;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import javafx.animation.Interpolator;
import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.animation.TranslateTransition;
import javafx.application.Application;
import static javafx.application.Application.launch;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Pane;
import javafx.scene.layout.StackPane;
import javafx.scene.shape.Rectangle;
import javafx.stage.Stage;
import javafx.util.Duration;

public class ImageSlide {

    // Width and height of image in pixels
    private final double IMG_WIDTH = 1000;
    private final double IMG_HEIGHT = 400;

    private final int NUM_OF_IMGS = 3;
    private final int SLIDE_FREQ = 4; // in secs
    private final Pane clipPane;

    HBox imgContainer;

    public ImageSlide(AnchorPane ac){
        /*//root code
        StackPane root = new StackPane();
        */
        clipPane = new Pane();
        // To center the slide show incase maximized
        clipPane.setMaxSize(IMG_WIDTH, IMG_HEIGHT);
        clipPane.setClip(new Rectangle(IMG_WIDTH, IMG_HEIGHT));
        this.imgContainer = new HBox();
        //image view
        ImageView imgGreen = new ImageView("/images/annonce_commande_final.png");
        ImageView imgBlue = new ImageView("/images/annonce_neuro_final.png");
        ImageView imgRose = new ImageView("/images/annonce_science_final.png");

        imgContainer.getChildren().addAll(imgGreen, imgBlue, imgRose);
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
        //error occured on (ActionEvent t) line
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
        Timeline anim = new Timeline(keyFrames.toArray(new KeyFrame[NUM_OF_IMGS]));

        anim.setCycleCount(Timeline.INDEFINITE);
        anim.playFromStart();
    }
}
