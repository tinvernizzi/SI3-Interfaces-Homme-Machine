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
        List<Product> bookProducts = Arrays.asList(
                new Product("Vivez mieux et plus longtemps", 24, "/images/produits/L1.jpg", "Par Mychel Cymes"),
                new Product("Mon cahier yoga méditation", 12, "/images/produits/L2.jpg", "Par Agathe Thine"),
                new Product("Pratique du massage chinois", 18, "/images/produits/L3.jpg", "Par Dr. You-Wa Chen")
        );
        ProductCategory books = new ProductCategory("Book", bookProducts);

        List<Product> dvdProducts = Arrays.asList(
                new Product("Le Yoga Facile pour les Nuls", 16, "/images/produits/D1.jpg", "Par Sara Ivanhoe"),
                new Product("Massages chinois traditionnels", 16, "/images/produits/D2.jpg", "Par Li Xuejon"),
                new Product("Bien être au réveil", 16, "/images/produits/D3.jpg", "Inspiré du yoga")
        );
        ProductCategory dvds = new ProductCategory("DVD", dvdProducts);

        List<Product> cdProducts = Arrays.asList(
                new Product("Coffret ZEN", 16, "/images/produits/C1.jpg", "Musiques & ambiances zen - 10 CD"),
                new Product("Relaxation", 16, "/images/produits/C2.jpg", "Par les indispensables"),
                new Product("Méditation et relaxation", 16, "/images/produits/C3.jpg", "2 CD")
        );
        ProductCategory cds = new ProductCategory("CD", cdProducts);

        List<Product> stageProducts = Arrays.asList(
                new Product("Stage 1", 16, "/images/produits/S1.jpg", ""),
                new Product("Stage 2", 16, "/images/produits/S2.jpg", ""),
                new Product("Stage 3", 16, "/images/produits/S3.jpg", "")
        );
        ProductCategory stages = new ProductCategory("Stage", stageProducts);


        dataBase.add(books);
        dataBase.add(dvds);
        dataBase.add(cds);
        dataBase.add(stages);

    }



    public List<ProductCategory> getAllItems() {
        return dataBase;
    }

    public ProductCategory getDvds() {
        return getCategory("DVD");
    }

    public ProductCategory getCds() {
        return getCategory("CD");
    }

    public ProductCategory getBooks() {
        return getCategory("Book");
    }

    public ProductCategory getStages() {
        return getCategory("Stage");
    }

    public ProductCategory getCategory(String categoryName){
        for(ProductCategory c : dataBase){
            if(c.name.equals(categoryName)) return c;
        }
        return null;
    }
}
