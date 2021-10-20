package domain;

public class Rekening {
    private double saldo;
    private int nr;

    public Rekening(double saldo, int nr){
        setNr(nr);
        setSaldo(saldo);
    }

    public double getSaldo(){
        return this.saldo;
    }

    private void setSaldo(double saldo){
        this.saldo = saldo;
    }

    public int getNr(){
        return this.nr;
    }

    private void setNr(int nr){
        this.nr = nr;
    }

    @Override
    public boolean equals(Object o){
        if (o instanceof Rekening){
            return this.nr == ((Rekening) o).getNr();
        }
        return false;
    }

    @Override
    public String toString(){
        return this.getNr() + ": " + this.getSaldo() + " euro";
    }
}
