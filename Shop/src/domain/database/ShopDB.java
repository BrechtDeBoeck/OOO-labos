package domain.database;
import java.io.*;

import domain.*;
import java.util.*;


public class ShopDB {
    private HashMap<Integer, Product> products;
    private int pid = 1;

    public ShopDB() {
        this.products = new HashMap<>();
    }

    public void addProduct(String title, String type){
        if (products.containsKey(pid)) {
            throw new IllegalArgumentException("Shop already contains a product with this ID");
        } else {
            Product product;
            switch(type) {
                case "M":
                    product = new Movie(title);
                    break;
                case "G":
                    product = new Game(title);
                    break;
                case "CD":
                    product = new CD(title);
                    break;
                default:
                throw new IllegalArgumentException("Not a valid product type");
            }
            products.put(this.pid, product);
            this.pid++;
        }
    }

    public void addProduct(int id, String title, String type){
        if (products.containsKey(id)){
            throw new IllegalArgumentException("Shop already contains a product with this ID");
        } else {
            Product product;
            switch(type) {
                case "Movie":
                    product = new Movie(title);
                    break;
                case "Game":
                    product = new Game(title);
                    break;
                case "CD":
                    product = new CD(title);
                    break;
                default:
                    throw new IllegalArgumentException("Not a valid product type");
            }
            products.put(id, product);
        }
    }

    public Product getProduct(String id) {
        int pid = Integer.parseInt(id);
        if (products.containsKey(pid)){
            return products.get(pid);
        } else {
            throw new IllegalArgumentException("This id is currently not linked to a product");
        }
    }

    public ArrayList<HashMap.Entry<Integer, Product>> getProducts() {
        ArrayList<HashMap.Entry<Integer, Product>> result = new ArrayList<>();
        Iterator<HashMap.Entry<Integer, Product>> iterator = this.products.entrySet().iterator();
        while (iterator.hasNext()){
            HashMap.Entry<Integer, Product> entry = iterator.next();
            result.add(entry);
        }
        Collections.sort(result, new DBComparator());
        return result;
    }

    public void setLatestPid() {
        int pid = 0;

        if (!this.products.isEmpty()){
            for (HashMap.Entry<Integer, Product> entry: getProducts()){
                if (pid < entry.getKey()){
                    pid = entry.getKey();
                }
            }
        }

        this.pid = pid + 1;
    }
}