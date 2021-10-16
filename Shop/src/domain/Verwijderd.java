package domain;

public class Verwijderd implements ProductState {
    Product product;

    public Verwijderd(Product product){
        this.product = product;
    }

    @Override
    public String loanProduct(int days){
        return product.getTitle() + " wordt binnenkort verwijderd en kan niet meer uitgeleend worden.";
    }

    @Override
    public String removeProduct(){
        return product.getTitle() + " is al gemarkeerd voor verwijdering.";
    }

    @Override
    public String returnProduct(boolean isBeschadigd){
        return product.getTitle() + " wordt binnenkort verwijderd en kan niet meer teruggebracht worden.";
    }

    @Override
    public String repairProduct(){
        return product.getTitle() + " wordt binnenkort verwijderd en kan niet meer hersteld worden.";
    }
}
