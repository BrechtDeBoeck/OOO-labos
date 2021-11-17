import javafx.application.Application;
import javafx.stage.Stage;
import model.EncryptingFacade;
import view.*;
import controller.*;

public class Main extends Application {
    public static void main(String[] args){
        launch(args);
    }


    @Override
    public void start(Stage primaryStage) throws Exception {
        EncryptingFacade model = new EncryptingFacade();
        EncryptingView eView = new EncryptingView();
        EncryptingController eController = new EncryptingController();
        LogView lView = new LogView();
        LogController lController = new LogController();
    }
}
