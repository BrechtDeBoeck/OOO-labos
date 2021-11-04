package domain;

import javax.swing.*;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;

public class WriteData implements Data{
    @Override
    public void setDataAction(Shop shop) {
        ArrayList<HashMap.Entry<Integer, Product>> list = shop.getDB().getProducts();
        File shopPath = new File("./Shop/src/data/shop.txt");

        // shop.txt exists?
        try {
            shopPath.createNewFile();
        } catch (Exception ignored) {}

        BufferedWriter bf = null;

        try {
            bf = new BufferedWriter(new FileWriter(shopPath));
            for (HashMap.Entry<Integer, Product> item: list){
                if (item.getValue().getState() != item.getValue().getVerwijderd()) {
                    bf.write(item.getKey() + "\t" + item.getValue().getTitle() + "\t" + item.getValue().getClass().getSimpleName());
                    bf.newLine();
                }
            }
        } catch (IOException e) {
            JOptionPane.showMessageDialog(null, e.getMessage());
        } finally {
            try {
                bf.close();
            } catch (Exception e) {
                JOptionPane.showMessageDialog(null, e.getMessage());
            }
        }
    }
}
