package fr.polytech.si3.ihm.model;

import java.util.Arrays;
import java.util.List;

/**
 * Created by tanguy on 12/03/17.
 */
public class ProductDatabase {

    ProductCategory books;

    public ProductDatabase () {
        List<Product> bookProduct = Arrays.asList(
                new Product("Le Yoga Facile pour les Nuls", 16, "/images/produits/D1.jpg", "Par Sara Ivanhoe"),
                new Product("Vivez mieux et plus longtemps", 24, "/images/produits/L1.jpg", "Par Mychel Cymes"),
                new Product("Mon cahier yoga méditation", 12, "/images/produits/L2.jpg", "Par Agathe Thine"),
                new Product("Pratique du massage chinois", 18, "/images/produits/L3.jpg", "Par Dr. You-Wa Chen")
        );

        books = new ProductCategory("Book", bookProduct);
    }

    public ProductCategory getBooks() {
        return books;
    }
}
