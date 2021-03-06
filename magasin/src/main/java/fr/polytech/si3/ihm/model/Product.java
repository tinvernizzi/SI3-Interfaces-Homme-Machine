package fr.polytech.si3.ihm.model;

import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

import java.util.Optional;

import static fr.polytech.si3.ihm.model.Category.NO_CATEGORY;

public class Product {

    private String name;
    private int prix;
    private Image image;
    private String description;
    private Category category;
    private Type type;
    private Optional<Promotion> promotion = Optional.empty();

    public Product(String name, int prix, String ImagePath, String description,Type type,Category category) {
        this.name = name;
        this.prix = prix;
        this.image = new Image(ImagePath);
        this.description = description;
        this.type = type;
        this.category = category;
    }

    public Product(String name, int prix, String ImagePath, String description,Type type) {
        this.name = name;
        this.prix = prix;
        this.image = new Image(ImagePath);
        this.description = description;
        this.type = type;
        this.category = NO_CATEGORY;
    }

    public Image getImage() {
        return image;
    }

    public String getDescription() {
        return description;
    }

    public String getName() {
        return name;
    }

    public String getPrix() {
        if(promotion.isPresent()) {
            return promotion.get().getPromoPrice()+"";
        } else return prix+"";
    }

    public int getPrixOutsideOfPromotion() {
        return prix;
    }

    public int getPriceInteger() {
        return prix;
    }

    public Category getCategory() {
        return category;
    }

    public Type getType() {
        return type;
    }

    public void setPromotion(int promoPrice){
        this.promotion = Optional.of(new Promotion(prix,promoPrice));
    }

    public void removePromotion(){
        this.promotion = Optional.empty();
    }

    public boolean isOnPromotion() {
        return promotion.isPresent();
    }

    public void setPrix(int prix) {
        this.prix = prix;
    }
}
