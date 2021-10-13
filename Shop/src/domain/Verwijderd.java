package domain;

public class Verwijderd implements ProductState {
    Product product;

    public Verwijderd(Product product){
        this.product = product;
    }

    @Override
    public void loanProduct(){

    }

    @Override
    public void removeProduct(){

    }

    @Override
    public void returnProduct(){

    }

    @Override
    public void repairProduct(){

    }
}
