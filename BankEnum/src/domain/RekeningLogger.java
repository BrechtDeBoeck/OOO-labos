package domain;

public class RekeningLogger implements Observer {
    private Bank bank;

    public RekeningLogger(Bank bank){
        this.bank = bank;
        bank.attach(this, Event.ALL);
    }

    @Override
    public void update(Rekening rekening, Event event) {
        switch(event){
            case OPEN:
                System.out.println("Rekening toegevoegd: " + rekening.getNr() + "  -  Totaal aantal rekeningen: " + bank.getAantalRekeningen());
                break;
            default:
                System.out.println(event.getStringValue() + ": Rekeningnummer: " + rekening.getNr() + "  -  Nieuw saldo: " + rekening.getSaldo());
        }
    }
}
