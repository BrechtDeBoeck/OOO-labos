package domain;

import domain.database.ShopDB;

import javax.swing.*;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Scanner;

public class ReadData implements Data{
    @Override
    public void setDataAction(Shop shop) {
        ShopDB data = new ShopDB();
        File shopPath = new File(".\\src\\data\\shop.txt");

        // shop.txt exists?
        try {
            shopPath.createNewFile();
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e.getMessage());
        }

        try {
            Scanner scannerFile = new Scanner(shopPath);
            while (scannerFile.hasNextLine()) {
                String s = scannerFile.nextLine();
                String[] delen = s.split("\t");
                String id = delen[0];
                data.addProduct(Integer.parseInt(id), delen[1], delen[2]);
                switch (delen[3]){
                    case "Uitgeleend":
                        data.getProduct(id).setState(data.getProduct(id).getUitgeleend());
                        break;
                    case "Beschadigd":
                        data.getProduct(id).setState(data.getProduct(id).getBeschadigd());
                        break;
                    default:
                        data.getProduct(id).setState(data.getProduct(id).getUitleenbaar());
                }
            }
            shop.setDB(data);
        } catch (IllegalStateException | FileNotFoundException e) {
            JOptionPane.showMessageDialog(null, e.getMessage());
        }
    }
}
