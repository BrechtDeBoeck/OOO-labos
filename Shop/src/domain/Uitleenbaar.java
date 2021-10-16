package domain;

public class Uitleenbaar implements ProductState {
    Product product;

    public Uitleenbaar(Product product){
        this.product = product;
    }

    @Override
    public String loanProduct(int days) {
        product.setState(product.getUitgeleend());
        product.days = days;
        return product.getTitle() + " is nu uitgeleend voor " + days + " dagen.";
    }

    @Override
    public String removeProduct() {
        product.setState(product.getVerwijderd());
        return product.getTitle() + " wordt verwijderd zodra het programma wordt stopgezet";
    }

    @Override
    public String returnProduct(boolean isBeschadigd) {
        return product.getTitle() + " is al in de winkel.";
    }

    @Override
    public String repairProduct() {
        return product.getTitle() + " is in prime conditie en moet niet hersteld worden";
    }
}
