package domain;

import domain.database.*;

public class Shop {
    private ShopDB shopDB;

    public Shop() {
        this.shopDB = new ShopDB();
    }

    public ShopDB getDB() {
        return this.shopDB;
    }

    public void setDB(ShopDB shopDB){
        this.shopDB = shopDB;
    }

    public double getPrice(String id, int days) {
        Product product = this.shopDB.getProduct(id);
        product.days = days;
        return product.getPrice(days);
    }

    private String isUitgeleend(String id){
        Product product = this.shopDB.getProduct(id);
        if (product.getState() == product.getUitgeleend()){
            return "product is uitgeleend";
        }
        return "product is nog beschikbaar en nog niet uitgeleend";
    }
}