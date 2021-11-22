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
        EncryptingController eController = new EncryptingController();
        EncryptingView eView = new EncryptingView(eController);
        LogController lController = new LogController(model);
        LogView lView = new LogView(lController);
    }
}
