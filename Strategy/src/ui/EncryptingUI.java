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
import javafx.scene.text.Text;
import javafx.stage.Stage;

public class EncryptingUI extends VBox {
    private EncryptingContext context;
    private TextField textField;
    private ComboBox comboBox;
    private Text result;

    public EncryptingUI(Stage primaryStage){
        context = new EncryptingContext();
        Label text = new Label("Typ text");
        Label algo = new Label("Kies algo");

        textField = new TextField();

        comboBox = new ComboBox();
        comboBox.getItems().addAll("Caesar", "Spiegel");


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
            context.setText(textField.getText());
            if (comboBox.getValue().equals("Caesar")){
                context.setCoding(new CaesarMethod());
            } else if (comboBox.getValue().equals("Spiegel")){
                context.setCoding(new MirroredMethod());
            }
            result.setText(context.performEncryption());
        }
    }

    class Decrypt implements EventHandler<ActionEvent> {
        @Override
        public void handle(ActionEvent event){
            context.setText(textField.getText());
            if (comboBox.getValue().equals("Caesar")){
                context.setCoding(new CaesarMethod());
            } else if (comboBox.getValue().equals("Spiegel")){
                context.setCoding(new MirroredMethod());
            }
            result.setText(context.performDecryption());
        }
    }
}
