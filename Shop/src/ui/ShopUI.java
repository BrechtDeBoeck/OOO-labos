package ui;

import domain.Product;
import domain.Shop;
import domain.database.*;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Scanner;
import javax.swing.JOptionPane;

import static javafx.application.Platform.exit;

public class ShopUI {
    private Shop shop;

    public ShopUI(){
        this.shop = new Shop();
    }

    public void start(){
        int choice = -1;
        Shop shop = new Shop();
        String menu = "\n1. Add product" +
                "\n2. Show product" +
                "\n3. Show rental price" +
                "\n4. Show list of products" +
                "\n5. Loan product" +
                "\n\n0. Quit";

        Scanner myObj = new Scanner(System.in);

        while (choice != 0) {
            String choiceString = JOptionPane.showInputDialog(menu);
            choice = Integer.parseInt(choiceString);
            if (choice == 1){
                addProduct(shop);
            } else if (choice == 2) {
                showProduct(shop);
            } else if (choice == 3){
                showPrice(shop);
            } else if (choice == 4){
                listProducts(shop);
            } else if (choice == 5){
                loanProduct(shop);
            } else if (choice == 0){
                writeTxt(shop);
                System.exit(0);
            }
        }
    }

    public static void addProduct(Shop shop) {
        String title = JOptionPane.showInputDialog("Enter the title:");
        String type = JOptionPane.showInputDialog("Enter the type (M for movie/G for game/CD for CD):");

        shop.getDB().addProduct(title, type);
    }

    public static void loanProduct(Shop shop) {
        String id = JOptionPane.showInputDialog("Enter the id:");

        try {
            Product product = shop.getDB().getProduct(id);
            product.setUitgeleend();
            JOptionPane.showMessageDialog(null, product.toString() + " is nu uitgeleend");
        } catch (Exception exc) {
            JOptionPane.showMessageDialog(null, "Er is geen product gevonden");
        }
    }

    public static void showProduct(Shop shop){
        String id = JOptionPane.showInputDialog("Enter the id:");
        /*int idx = -1;
        boolean found = false;*/
        try {
            Product product = shop.getDB().getProduct(id);
            JOptionPane.showMessageDialog(null, product.toString());
        } catch (Exception exc) {
            JOptionPane.showMessageDialog(null, "Er is geen product gevonden");
        }
        /*for(int i = 0; i < shop.productIds.size() && !found; i++) {
            if(shop.productIds.get(i).equals(id)) {
                idx = i;
                found = true;
            }
        }
        if(found)
        {
            JOptionPane.showMessageDialog(null, shop.productTitles.get(idx));
        }*/
    }

    public static void showPrice(Shop shop){
        String id = JOptionPane.showInputDialog("Enter the id:");

        Product product = shop.getDB().getProduct(id);
        if (product != null){
            String daysString = JOptionPane.showInputDialog("Enter the number of days:");
            int days = Integer.parseInt(daysString);
            JOptionPane.showMessageDialog(null, "The total price would amount to $" + shop.getPrice(id, days));
        }
        /*int idx = -1;
        boolean found = false;
        for(int i = 0; i < shop.productIds.size() && !found; i++) {
            if(shop.productIds.get(i).equals(id)){
                idx = i;
                found = true;
            }
        }
        if(found){
            String daysString = JOptionPane.showInputDialog("Enter the number of days:");
            int days = Integer.parseInt(daysString);
            JOptionPane.showMessageDialog(null, shop.getPrice(idx,days));
        }*/
    }

    public static void listProducts(Shop shop){
        ArrayList<HashMap.Entry<Integer, Product>> list = shop.getDB().getProducts();
        String output = "";
        for (HashMap.Entry<Integer, Product> item: list){
            output += item.getKey() + ": " + item.getValue().toString() + "\n";
        }
        if (output.isEmpty()) output += "Er zijn nog geen producten";
        JOptionPane.showMessageDialog(null, output);
    }

    public static void writeTxt(Shop shop) {
        ArrayList<HashMap.Entry<Integer, Product>> list = shop.getDB().getProducts();
        final String outputFilePath = "C:\\Documents/shop.txt";
        File file = new File(outputFilePath);
        BufferedWriter bf = null;

        try {
            bf = new BufferedWriter(new FileWriter(file));
            for (HashMap.Entry<Integer, Product> item: list){
                bf.write(item.getKey() + ": " + item.getValue().toString());
                bf.newLine();
            }
        } catch (IOException e) {
        }
        finally {
            try {
                bf.close();
            } catch (Exception e) {
            }
        }
    }

    /*public static void readTxt() {
        System.out.println("\n\tReading from file");
        ArrayList<Persoon> personen = new ArrayList<>();
        final String inputFilePath = "C:\\Documents/shop.txt";
        File file = new File(inputFilePath);
        try {
            Scanner scannerFile = new Scanner(file);
            while (scannerFile.hasNextLine()) {
                String s = scannerFile.nextLine();
                String[] delen = s.split(" ");
            }
        } catch (IllegalStateException | FileNotFoundException ex) {
            System.out.println("Fout bij het inlezen " + ex);
        }
    }*/
}