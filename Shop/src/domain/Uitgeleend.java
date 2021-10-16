package domain;

public class Uitgeleend implements ProductState {
    Product product;

    public Uitgeleend(Product product){
        this.product = product;
    }

    @Override
    public String loanProduct(int days) {
        return product.getTitle() + " is al uitgeleend.";
    }

    @Override
    public String removeProduct() {
        return product.getTitle() + " wordt momenteel uitgeleend. We kunnen geen producten uit de winkel verwijderen als ze nog uitgeleend worden.";
    }

    @Override
    public String returnProduct(boolean isBeschadigd) {
        if (isBeschadigd){
            product.setState(product.getBeschadigd());
            return product.getTitle() + " is in gehavende conditie teruggebracht.";
        } else {
            product.setState(product.getUitleenbaar());
            return product.getTitle() + " is in goede conditie teruggebracht.";
        }
    }

    @Override
    public String repairProduct() {
        return product.getTitle() + " is momenteel uitgeleend en kan nu niet hersteld worden.";
    }
}
