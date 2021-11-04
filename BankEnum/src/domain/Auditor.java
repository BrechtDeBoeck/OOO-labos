package domain;

import java.time.LocalDate;

public class Auditor implements Observer {
    private Bank bank;

    public Auditor(Bank bank){
        this.bank = bank;
        bank.attach(this, Event.OPEN);
    }

    @Override
    public void update(Rekening rekening, Event event) {
        switch (event) {
            case OPEN:
            System.out.println("Nieuwe rekening geopend op datum " + LocalDate.now() + " met nummer " + rekening.getNr() + " en saldo " + rekening.getSaldo());
            break;
        }
    }
}
