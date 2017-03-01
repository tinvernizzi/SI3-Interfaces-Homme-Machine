package fr.polytech.si3.ihm.controllers;

import javafx.fxml.FXML;
import javafx.scene.Parent;

/**
 * Created by Antoine on 3/1/2017.
 */
public class MainView {
    @FXML
    private Parent slideshowView; //embeddedElement
    @FXML
    private SlideshowView slideshowViewController; // $embeddedElement+Controller

    public void initialize() {
        System.out.println(slideshowViewController);
        System.out.println(slideshowView);
        slideshowViewController.test("It works"); //Console print "It works"
    }
}
