package domain;

import java.util.Observable;
import java.util.Observer;

public class RekeningLogger implements Observer {
    private Observable bank;

    public RekeningLogger(Bank bank){
        this.bank = bank;
        bank.addObserver(this);
    }

    @Override
    public void update(Observable o, Object arg) {
        if (o instanceof Bank){
            Bank bank = (Bank) o;
            Rekening rekening = bank.getNewestRekening().getValue();
            System.out.println("Rekening toegevoegd: " + rekening.getNr() + "  -  Totaal aantal rekeningen: " + bank.getAantalRekeningen());
        }
    }
}
