package domain.database;

import domain.Product;
import java.util.HashMap;

public class ShopDB {
    private HashMap<String, Product> products;

    public ShopDB(){
        this.products = new HashMap<>();
    }
}