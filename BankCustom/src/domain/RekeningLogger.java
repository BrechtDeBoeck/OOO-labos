package domain;

public class RekeningLogger implements Observer {
    private Bank bank;

    public RekeningLogger(Bank bank){
        this.bank = bank;
        bank.attach(this);
    }

    @Override
    public void update(Rekening rekening) {
        System.out.println("Rekening toegevoegd: " + rekening.getNr() + "  -  Totaal aantal rekeningen: " + bank.getAantalRekeningen());
    }
}
