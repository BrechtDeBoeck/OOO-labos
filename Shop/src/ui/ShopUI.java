package ui;

import domain.Product;
import domain.Shop;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Scanner;
import javax.swing.JOptionPane;

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
            }
        }
    }

    public static void addProduct(Shop shop) {
        String title = JOptionPane.showInputDialog("Enter the title:");
        String id = JOptionPane.showInputDialog("Enter the id:");
        String type = JOptionPane.showInputDialog("Enter the type (M for movie/G for game/CD for CD):");

        shop.getDB().addProduct(title, id, type);
    }

    public static void showProduct(Shop shop){
        String id = JOptionPane.showInputDialog("Enter the id:");
        /*int idx = -1;
        boolean found = false;*/

        Product product = shop.getDB().getProduct(id);
        if (product != null){
            JOptionPane.showMessageDialog(null, product.toString());
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
        ArrayList<HashMap.Entry<String, Product>> list = shop.getDB().getProducts();
        String output = "";
        for (HashMap.Entry<String, Product> item: list){
            output += item.getKey() + ": " + item.getValue().toString() + "\n";
        }
        if (output.isEmpty()) output += "Er zijn nog geen producten";
        JOptionPane.showMessageDialog(null, output);
    }
}

/*
    public static void SchrijfTestNamen() {
        System.out.println("\n\tWriting plain names");
        File namen = new File("Namen.txt");
        try {
            PrintWriter writer = new PrintWriter("namen");
            writer.println("Rudi Swennen");
            writer.println("Elke Steegmans");
            writer.close();
        } catch (FileNotFoundException ex) {
            throw new IllegalStateException("Fout bij wegschrijven " + ex);
        }
    }

    public static void SchrijfVanArray() {
        System.out.println("\n\tWriting from array");
        ArrayList<String> lijst = new ArrayList<>();
        lijst.add("Rudi Swennen");
        lijst.add("Elke Steegmans");
        File namen = new File("Namen.txt");

        try {
            PrintWriter writer = new PrintWriter("namen");
            for (String s : lijst) {
                writer.println(s);
            }
            writer.close();
        } catch (FileNotFoundException ex) {
            throw new IllegalStateException("Fout bij wegschrijven " + ex);
        }
    }

    public static void LeesVanBestand() {
        System.out.println("\n\tReading from file");
        ArrayList<Persoon> personen = new ArrayList<>();
        File personenFile = new File("Personen.txt");
        try {
            Scanner scannerFile = new Scanner(personenFile);
            while (scannerFile.hasNextLine()) {
                String s = scannerFile.nextLine();
                String[] delen = s.split("/");
                Persoon persoon = new Persoon(delen[1], delen[0]);
                personen.add(persoon);
            }
            System.out.println();
            for (Persoon p : personen) {
                System.out.println("\tPersoon " + p.getVoornaam() + " " + p.getNaam());
            }
        } catch (IllegalStateException | FileNotFoundException ex) {
            System.out.println("Fout bij het inlezen " + ex);
        }
    }
*/