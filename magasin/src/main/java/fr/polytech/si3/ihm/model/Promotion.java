package fr.polytech.si3.ihm.model;

/**
 * Created by user on 14/03/2017.
 */
public class Promotion {
    private final int initialPrice;
    private int promoPrice;

    public int getPromoPrice() {
        return promoPrice;
    }

    public Promotion(int price, int promoPrice){
        this.initialPrice = price;
        this.promoPrice = promoPrice;
    }
}
