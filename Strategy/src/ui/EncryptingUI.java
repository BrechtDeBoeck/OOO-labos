package ui;

import domain.*;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.FlowPane;
import javafx.scene.layout.VBox;
import javafx.scene.text.Text;
import javafx.stage.Stage;

import java.util.Locale;

public class EncryptingUI extends VBox {
    private EncryptionFacade encryptionFacade;
    private TextField textField;
    private ComboBox comboBox;
    private Text result;

    public EncryptingUI(Stage primaryStage){
        encryptionFacade = new EncryptionFacade();
        Label text = new Label("Typ text");
        Label algo = new Label("Kies algo");

        EncryptionFacade facade = new EncryptionFacade();
        // TODO: Complete (?)

        textField = new TextField();

        comboBox = new ComboBox();
        comboBox.getItems().addAll("Caesar", "Spiegel", "Random");


        Button code = new Button("Code");
        code.setOnAction(new Encrypt());
        Button decode = new Button("Decode");
        decode.setOnAction(new Decrypt());

        result = new Text();



        VBox root = new VBox(text, textField, algo, comboBox, code, decode, result);
        Scene mainScene = new Scene(root, 250, 250);
        primaryStage.setTitle("Encryption");
        primaryStage.setScene(mainScene);
    }

    class Encrypt implements EventHandler<ActionEvent> {
        @Override
        public void handle(ActionEvent event) {
            String text = textField.getText();
            String method = ((String) comboBox.getValue()).toUpperCase();
            result.setText(encryptionFacade.encrypt(text, method));
        }
    }

    class Decrypt implements EventHandler<ActionEvent> {
        @Override
        public void handle(ActionEvent event){
            String text = textField.getText();
            String method = ((String) comboBox.getValue()).toUpperCase();
            result.setText(encryptionFacade.decrypt(text, method));
        }
    }
}
