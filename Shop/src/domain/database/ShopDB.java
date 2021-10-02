package domain.database;

import domain.Game;
import domain.Movie;
import domain.Product;
import java.util.HashMap;

public class ShopDB {
    private HashMap<String, Product> products;

    public ShopDB(){
        this.products = new HashMap<>();
    }

    public void addProduct(String title, String id, String type){
        if (products.containsKey(id)){
            throw new IllegalArgumentException("Shop already contains a product with this ID");
        } else {
            Product product;
            switch(type){
                case "M":
                    product = new Movie(title);
                    break;
                case "G":
                    product = new Game(title);
                    break;
                default:
                    throw new IllegalArgumentException("Not a valid product type");
            }
            products.put(id, product);
        }
    }

    public Product getProduct(String id){
        if (products.containsKey(id)){
            return products.get(id);
        } else {
            throw new IllegalArgumentException("This id is currently not linked to a product");
        }
    }
}