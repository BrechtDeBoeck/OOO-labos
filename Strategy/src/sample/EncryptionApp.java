package sample;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.FlowPane;
import javafx.stage.Stage;

public class EncryptionApp extends Application {
    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) throws Exception{
        FlowPane root = new FlowPane();
        Label text = new Label("Typ text");
        Label algo = new Label("Kies algo");
        TextField textField = new TextField();
        ComboBox comboBox = new ComboBox();
        comboBox.getItems().addAll("Caesar", "Spiegel");
        Button code = new Button("Code");
        Button decode = new Button("Decode");




        Scene mainScene = new Scene(root, 250, 500);
        primaryStage.setTitle("Encryption");
        primaryStage.setScene(mainScene);
        primaryStage.show();
    }
}