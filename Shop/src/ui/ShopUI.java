package ui;

import domain.*;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Scanner;
import javax.swing.JOptionPane;

public class ShopUI {
    private Shop shop;
    private Data data;

    public ShopUI(){
        this.shop = new Shop();
    }

    public void start() {
        int choice = -1;
        Shop shop = new Shop();
        String menu = "\n1. Add product" +
                "\n2. Remove product" +
                "\n3. Loan product" +
                "\n4. Product loaned?" +
                "\n5. Return product" +
                "\n6. Repair product" +
                "\n7. Show product" +
                "\n8. Show rental price" +
                "\n9. Show list of products" +
                "\n\n0. Quit";

        Scanner myObj = new Scanner(System.in);

        setData(new ReadData());
        data.setDataAction(shop);

        while (choice != 0) {
            String choiceString = JOptionPane.showInputDialog(menu);
            choice = Integer.parseInt(choiceString);
            if (choice == 1){
                addProduct(shop);
            } else if (choice == 2) {
                removeProduct(shop);
            } else if (choice == 3){
                loanProduct(shop);
            } else if (choice == 4){
                isUitgeleend(shop);
            } else if (choice == 5){
                returnProduct(shop);
            }else if (choice == 6) {
                repairProduct(shop);
            } else if (choice == 7) {
                showProduct(shop);
            } else if (choice == 8) {
                showPrice(shop);
            } else if (choice == 9){
                listProducts(shop);
            } else if (choice == 0){
                setData(new WriteData());
                data.setDataAction(shop);
                System.exit(0);
            }
        }
    }

    public static void addProduct(Shop shop) {
        String title = JOptionPane.showInputDialog("Enter the title:");
        String type = JOptionPane.showInputDialog("Enter the type (M for movie/G for game/CD for CD):");

        shop.getDB().addProduct(title, type);
    }

    public static void removeProduct(Shop shop){
        String id = JOptionPane.showInputDialog("Enter the id:");

        try {
            Product product = shop.getDB().getProduct(id);
            JOptionPane.showMessageDialog(null, product.removeProduct());
        } catch (Exception exc){
            JOptionPane.showMessageDialog(null, "Er is geen product gevonden");
        }
    }

    public static void loanProduct(Shop shop) {
        String id = JOptionPane.showInputDialog("Enter the id:");
        int days = Integer.parseInt(JOptionPane.showInputDialog("Enter the amount of days you wish to rent: "));

        try {
            Product product = shop.getDB().getProduct(id);
            JOptionPane.showMessageDialog(null, product.loanProduct(days));
        } catch (Exception exc) {
            JOptionPane.showMessageDialog(null, "Er is geen product gevonden");
        }
    }

    public static void isUitgeleend (Shop shop){
        String id = JOptionPane.showInputDialog("Enter the id:");

        try {
            Product product = shop.getDB().getProduct(id);
            if (product.getState() == product.getUitgeleend()){
                JOptionPane.showMessageDialog(null,product.getTitle() + "Product met dit ID is momenteel uitgeleend");
            }
            else {
                JOptionPane.showMessageDialog(null, "product met dit ID is nog niet uitgeleend");
            }


        } catch (Exception exc){
            JOptionPane.showMessageDialog(null,"Geen product gevonden");
        }
    }

    public static void returnProduct(Shop shop){
        String id = JOptionPane.showInputDialog("Enter the id: ");
        String isBeschadigd = JOptionPane.showInputDialog("Is the product damaged? (Yes/No): ");

        try {
            Product product = shop.getDB().getProduct(id);
            if (isBeschadigd.equals("Yes")){
                JOptionPane.showMessageDialog(null, product.returnProduct(true));
            } else if (isBeschadigd.equals("No")){
                JOptionPane.showMessageDialog(null, product.returnProduct(false));
            }
        } catch (Exception exc){
            JOptionPane.showMessageDialog(null, "Er is geen product gevonden");
        }
    }

    public static void repairProduct(Shop shop){
        String id = JOptionPane.showInputDialog("Enter the id: ");

        try {
            Product product = shop.getDB().getProduct(id);
            JOptionPane.showMessageDialog(null, product.repairProduct());
        } catch (Exception exc){
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

    public static void showPrice(Shop shop) {
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

    public void setData(Data data) {
        this.data = data;
    }
}