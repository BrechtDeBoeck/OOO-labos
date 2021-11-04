import domain.*;

public class Launcher {
    public static void main(String[] args){
        Bank bank = new Bank();
        Auditor auditor = new Auditor(bank);

        RekeningLogger rekLogger = new RekeningLogger(bank);
        Rekening rekening = new Rekening(12345, 1000);
        bank.addRekening(rekening);

        bank.deposit(1000, 350);
        bank.withdrawal(1000, 700);
    }
}
