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

    public double getPrice(String id, int days){
        double price = 0;
        if (this.shopDB.getProduct(id) instanceof Movie){
            price = 5;
            int daysLeft = days - 3;
            if (daysLeft > 0){
                price += (daysLeft * 2);
            }
        } else if (this.shopDB.getProduct(id) instanceof Game){
            price = days * 3;
        }
        return price;
    }
}