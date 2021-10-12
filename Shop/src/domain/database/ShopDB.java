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

    /*public class PrintWriter { //info van een arraylist naar bestand
        public static void main (String[] args) {

            File producten = new File("shop.txt");
            try {
                PrintWriter writer = new PrintWriter(producten);
                for (String s: ) {writer.println(s);}
                writer.close();
            }  catch (FileNotFoundException ex) {
                throw new IllegalStateException();
            }
        }
    }*/
}