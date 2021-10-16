package domain;

public class Beschadigd implements ProductState {
    Product product;

    public Beschadigd(Product product){
        this.product = product;
    }

    @Override
    public String loanProduct(int days) {
        return product.getTitle() + " is momenteel beschadigd en moet eerst hersteld worden. Beschadigde goederen uitlenen is slecht voor onze naam.";
    }

    @Override
    public String removeProduct() {
        product.setState(product.getVerwijderd());
        return product.getTitle() + " is nu gemarkeerd als 'te beschadigd voor herstel', en wordt verwijderd bij het sluiten van het programma.";
    }

    @Override
    public String returnProduct(boolean isBeschadigd) {
        return product.getTitle() + " is al binnengebracht.";
    }

    @Override
    public String repairProduct() {
        product.setState(product.getUitleenbaar());
        return product.getTitle() + " wordt nu hersteld. Naar de klant wordt een schadevergoeding van " + product.getRepairCosts() + " euro gestuurd.";
    }
}
