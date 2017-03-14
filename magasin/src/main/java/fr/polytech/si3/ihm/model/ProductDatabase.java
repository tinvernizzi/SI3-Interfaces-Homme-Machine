package fr.polytech.si3.ihm.model;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

import static fr.polytech.si3.ihm.model.Type.*;

/**
 * Created by tanguy on 12/03/17.
 */
public class ProductDatabase {

    List<Product> dataBase;

    public ProductDatabase () {
        dataBase = new ArrayList<>();
        List<Product> products = Arrays.asList(
                new Product("Vivez mieux et plus longtemps", 24, "/images/produits/L1.jpg", "Par Mychel Cymes",BOOK,Category.SCIENTIFIC),
                new Product("Mon cahier yoga méditation", 12, "/images/produits/L2.jpg", "Par Agathe Thine",BOOK),
                new Product("Pratique du massage chinois", 18, "/images/produits/L3.jpg", "Par Dr. You-Wa Chen",BOOK),
                new Product("Le Yoga Facile pour les Nuls", 80, "/images/produits/D1.jpg", "Par Sara Ivanhoe",DVD),
                new Product("Massages chinois traditionnels", 16, "/images/produits/D2.jpg", "Par Li Xuejon",DVD),
                new Product("Bien être au réveil", 50, "/images/produits/D3.jpg", "Inspiré du yoga",DVD,Category.NEUROLOGIC),
                new Product("Coffret ZEN", 43, "/images/produits/C1.jpg", "Musiques & ambiances zen - 10 CD",CD),
                new Product("Relaxation", 67, "/images/produits/C2.jpg", "Par les indispensables",CD),
                new Product("Méditation et relaxation", 21, "/images/produits/C3.jpg", "2 CD",CD),
                new Product("Stage 1", 400, "/images/produits/S1.jpg", "",STAGE),
                new Product("Stage 2", 1000, "/images/produits/S2.jpg", "",STAGE),
                new Product("Stage 3", 546, "/images/produits/S3.jpg", "",STAGE)
        );

        dataBase.addAll(products);
    }



    public List<Product> getAllItems() {
        return dataBase;
    }

    public List<Product> getDvds() {
        return getProductsByType(DVD);
    }

    public List<Product> getCds() {
        return getProductsByType(CD);
    }

    public List<Product> getBooks() {
        return getProductsByType(BOOK);
    }

    public List<Product> getStages() {
        return getProductsByType(STAGE);
    }

    private List<Product> getProductsByType(Type type) {
        List<Product> productCategory = new ArrayList<>();
        for(Product p : dataBase){
            if(p.getType().equals(type)) productCategory.add(p);
        }
        return productCategory;
    }

    public List<Product> getCategory(Category categoryName){
        List<Product> productCategory = new ArrayList<>();
        for(Product p : dataBase){
            if(p.getCategory().equals(categoryName)) productCategory.add(p);
        }
        return productCategory;
    }

    public List<Product> getItemsBetween(List<Product> list, int min, int max) {
        List<Product> validItems = new ArrayList<>();
        return validItems = list.stream()
                .filter(product -> product.getPriceInteger()>= min
                        &&
                        product.getPriceInteger()<=max
                ).collect(Collectors.toList());
    }

    public List<Product> getItemsByName(List<Product> list, String searchName) {
        List<Product> validItems = new ArrayList<>();
        return validItems = list.stream()
                .filter(product ->
                        product.getName().contains(searchName)
                ).collect(Collectors.toList());
    }

    public List<Product> removeItemsWithCategory(List<Product> list,Category category) {
        List<Product> validItems = new ArrayList<>();
        return validItems = list.stream()
                .filter(product ->
                        !product.getCategory().equals(category)
                ).collect(Collectors.toList());
    }
}
