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
        return this.shopDB.getProduct(id).getPrice(days);
    }
}