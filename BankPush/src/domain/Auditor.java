package domain;

import java.time.LocalDate;
import java.util.Observable;
import java.util.Observer;

public class Auditor implements Observer {
    private Bank bank;

    public Auditor(Bank bank){
        this.bank = bank;
        bank.addObserver(this);
    }

    @Override
    public void update(Observable o, Object arg) {
        Rekening rekening = (Rekening) arg;
        if (o instanceof Bank){
            Bank bank = (Bank) o;
            System.out.println("Nieuwe rekening geopend op datum " + LocalDate.now() + " met nummer " + rekening.getNr() + " en saldo " + rekening.getSaldo());
        }
    }
}
