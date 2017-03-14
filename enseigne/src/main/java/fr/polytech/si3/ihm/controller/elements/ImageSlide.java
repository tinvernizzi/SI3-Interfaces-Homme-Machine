package fr.polytech.si3.ihm.controller.elements;

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

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

@SuppressWarnings("Duplicates")
class ImageSlide {

    private final int NUM_OF_IMGS = 4;

    // Width and height of image in pixels
    private final double IMG_WIDTH = 1000;

    private int currentImage = 1;
    private HBox imgContainer;
    private Timeline mainAnim;
    private boolean animationIsFinished = true;

    ImageSlide(AnchorPane ac){
        Pane clipPane = new Pane();
        double IMG_HEIGHT = 300;
        clipPane.setMaxSize(IMG_WIDTH, IMG_HEIGHT);
        clipPane.setClip(new Rectangle(IMG_WIDTH, IMG_HEIGHT));
        this.imgContainer = new HBox();

        ImageView first = new ImageView("/images/neuro.png");
        ImageView second = new ImageView("/images/sciences.png");
        ImageView third = new ImageView("/images/neuro.png");
        ImageView fourth = new ImageView("/images/sciences.png");
        imgContainer.getChildren().addAll(first, second, third, fourth);
        clipPane.getChildren().add(imgContainer);
        ac.getChildren().add(clipPane);

        swap(ac);

    }

    private void swap(AnchorPane ac) {
        ObservableList<Node> workingCollection = FXCollections.observableArrayList(ac.getChildren());
        Collections.swap(workingCollection, 0,1);
        ac.getChildren().setAll(workingCollection);
    }

    void startAnimation() {

        EventHandler<ActionEvent> slideAction = (ActionEvent t) -> {
            TranslateTransition trans = new TranslateTransition(Duration.seconds(1.5), imgContainer);
            trans.setByX(-IMG_WIDTH);
            trans.setInterpolator(Interpolator.EASE_BOTH);
            trans.play();
        };

        EventHandler<ActionEvent> resetAction = (ActionEvent t) -> {
            TranslateTransition trans = new TranslateTransition(Duration.seconds(1), imgContainer);
            trans.setByX((NUM_OF_IMGS - 1) * IMG_WIDTH);
            trans.setInterpolator(Interpolator.EASE_BOTH);
            trans.play();
        };

        List<KeyFrame> keyFrames = new ArrayList<>();
        for (int i = 1; i <= NUM_OF_IMGS; i++) {
            int SLIDE_FREQ = 4;
            if (i == NUM_OF_IMGS) {
                keyFrames.add(new KeyFrame(Duration.seconds(i * SLIDE_FREQ), resetAction));
            } else {
                keyFrames.add(new KeyFrame(Duration.seconds(i * SLIDE_FREQ), slideAction));
            }
        }

        this.mainAnim = new Timeline(keyFrames.toArray(new KeyFrame[NUM_OF_IMGS]));

        mainAnim.setCycleCount(Timeline.INDEFINITE);
        mainAnim.playFromStart();
    }

    void goRight() {
        if(currentImage < NUM_OF_IMGS)
            translate(-1);
        else
            translate(NUM_OF_IMGS -1);
    }

    void goLeft() {
        if(currentImage > 1)
            translate(1);
        else
            translate(1 - NUM_OF_IMGS);
    }

    private void translate(int sign){
        mainAnim.stop();
        if(animationIsFinished) {
            setAnimationIsFinished(false);
            currentImage -=sign;
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

    private void setAnimationIsFinished(boolean animationIsFinished) {
        this.animationIsFinished = animationIsFinished;
    }

}
