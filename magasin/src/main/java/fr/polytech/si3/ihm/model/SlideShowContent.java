package fr.polytech.si3.ihm.model;

import javafx.scene.Node;
import javafx.scene.image.ImageView;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by user on 14/03/2017.
 */
public class SlideShowContent {
    private List<Node> images;

    public SlideShowContent() {
        this.images = new ArrayList<>();
        images.add(new ImageView("/images/annonce_commande_final.png"));
        images.add(new ImageView("/images/annonce_neuro_final.png"));
        images.add(new ImageView("/images/annonce_science_final.png"));
    }

    public List<Node> getImages() {
        return images;
    }
}
