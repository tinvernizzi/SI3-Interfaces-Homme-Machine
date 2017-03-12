package fr.polytech.si3.ihm.model;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Created by tanguy on 12/03/17.
 */
public class ProductDatabase {

    List<ProductCategory> dataBase;

    public ProductDatabase () {
        dataBase = new ArrayList<>();
        List<Product> bookProduct = Arrays.asList(
                new Product("Le Yoga Facile pour les Nuls", 16, "/images/produits/D1.jpg", "Par Sara Ivanhoe"),
                new Product("Vivez mieux et plus longtemps", 24, "/images/produits/L1.jpg", "Par Mychel Cymes"),
                new Product("Mon cahier yoga méditation", 12, "/images/produits/L2.jpg", "Par Agathe Thine"),
                new Product("Pratique du massage chinois", 18, "/images/produits/L3.jpg", "Par Dr. You-Wa Chen")
        );

        ProductCategory books = new ProductCategory("Book", bookProduct);
        dataBase.add(books);
    }

    public ProductCategory getBooks() {
        for(ProductCategory c : dataBase){
            if(c.name.equals("Book")) return c;
        }
        return null;
    }

    public List<ProductCategory> getAllItems() {
        return dataBase;
    }
}
