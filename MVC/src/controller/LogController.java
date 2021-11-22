package controller;
import model.EncryptingContext;
import model.Observer;
import view.LogView;
import model.EncryptingFacade;

public class LogController implements Observer {
    private LogView view;
    private EncryptingFacade model;

    public LogController(EncryptingFacade model){
        model.attach(this);
    }

    //Called by LogView
    public void setView(LogView view){
        this.view = view;
    }

    @Override
    public void update(EncryptingContext context, String codedText){
        String originalText = context.getText();
        String codingMethod = context.getMethod().getClass().getSimpleName();
        view.updateDisplay(originalText, codedText, codingMethod);
    }
}
