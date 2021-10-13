package ui;

import domain.CaesarMethod;
import domain.EncryptingContext;
import domain.MirroredMethod;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.FlowPane;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class EncryptingUI extends VBox {
    private EncryptingContext context;

    public EncryptingUI(Stage primaryStage){
        context = new EncryptingContext();
        VBox root = new VBox();
        Label text = new Label("Typ text");
        Label algo = new Label("Kies algo");

        TextField textField = new TextField();
        context.setText(textField.getText());

        ComboBox comboBox = new ComboBox();
        comboBox.getItems().addAll("Caesar", "Spiegel");

        if (comboBox.getAccessibleText().equals("Caesar")){
            context.setCoding(new CaesarMethod());
        } else if (comboBox.getAccessibleText().equals("Mirrored")){
            context.setCoding(new MirroredMethod());
        }
        Button code = new Button("Code");
        code.setOnAction(new Encrypt());
        Button decode = new Button("Decode");
        decode.setOnAction(new Decrypt());




        Scene mainScene = new Scene(root, 250, 500);
        primaryStage.setTitle("Encryption");
        primaryStage.setScene(mainScene);
    }

    class Encrypt implements EventHandler<ActionEvent> {
        @Override
        public void handle(ActionEvent event) {
            context.performEncryption();
        }
    }

    class Decrypt implements EventHandler<ActionEvent> {
        @Override
        public void handle(ActionEvent event){
            context.performDecryption();
        }
    }
}
