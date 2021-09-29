package domain;

import domain.database.*;

public class Shop {
    private ShopDB shopDB;

    public Shop(){
        this.shopDB = new ShopDB();
    }
}