package view;

import controller.EncryptingController;
import domain.*;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.Pane;
import javafx.scene.layout.VBox;
import javafx.scene.text.Text;
import javafx.stage.Stage;

public class EncryptingView extends VBox {
    private Stage stage;
    private TextField textField;
    private ComboBox comboBox;
    private Text result;

    public EncryptingView(EncryptingController encryptingController) {
        Label text = new Label("Typ text");
        Label algo = new Label("Kies algo");

        EncryptionFacade facade = new EncryptionFacade();
        // TODO: Complete (?)

        textField = new TextField();

        comboBox = new ComboBox();
        comboBox.getItems().addAll("Caesar", "Spiegel", "Random");


        Button code = new Button("Code");
        code.setOnAction(new EncryptingView.Encrypt());
        Button decode = new Button("Decode");
        decode.setOnAction(new EncryptingView.Decrypt());

        result = new Text();

        VBox root = new VBox(text, textField, algo, comboBox, code, decode, result);
        Scene mainScene = new Scene(root, 250, 250);
        stage.setTitle("Encryption");
        stage.setScene(mainScene);
    }

    class Decrypt implements EventHandler<ActionEvent> {
        @Override
        public void handle(ActionEvent event) {

        }
    }
}