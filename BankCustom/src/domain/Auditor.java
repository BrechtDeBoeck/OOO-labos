package domain;

import java.time.LocalDate;

public class Auditor implements Observer {
    private Bank bank;

    public Auditor(Bank bank){
        this.bank = bank;
        bank.attach(this);
    }

    @Override
    public void update(Rekening rekening) {
        System.out.println("Nieuwe rekening geopend op datum " + LocalDate.now() + " met nummer " + rekening.getNr() + " en saldo " + rekening.getSaldo());
    }
}
