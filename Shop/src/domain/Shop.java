package domain;

import domain.database.*;

public class Shop {
    private ShopDB shopDB;

    public Shop(){
        this.shopDB = new ShopDB();
    }

    public ShopDB getDB(){
        return this.shopDB;
    }

    /*public double getPrice(String id, int days){

    }*/
}