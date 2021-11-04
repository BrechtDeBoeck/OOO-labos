package domain;

import domain.database.ShopDB;

public abstract class Product {
    private ProductState uitleenbaar;
    private ProductState uitgeleend;
    private ProductState beschadigd;
    private ProductState verwijderd;
    private Pricing pricing;

    private String title;
    private ProductState state;
    public int days;

    public Product(String title) {
        uitleenbaar = new Uitleenbaar(this);
        uitgeleend = new Uitgeleend(this);
        beschadigd = new Beschadigd(this);
        verwijderd = new Verwijderd(this);


        setTitle(title);
        this.state = uitleenbaar;
    }

    private void setTitle(String title) {
        if (title == null || title.trim().isEmpty()) {
            throw new IllegalArgumentException("Title may not be empty");
        }
        this.title = title;
    }
    public void setPricing(Pricing pricing) {
        this.pricing = pricing;
    }

    public String getTitle() {
        return this.title;
    }

    public double getPrice(int days) {
        return pricing.getPrice(days);
    }

    public double getRepairCosts(){
        return this.getPrice(this.days) / 3;
    }

    public ProductState getUitleenbaar(){
        return this.uitleenbaar;
    }

    public ProductState getUitgeleend(){
        return this.uitgeleend;
    }

    public ProductState getVerwijderd(){
        return this.verwijderd;
    }

    public ProductState getBeschadigd(){
        return this.beschadigd;
    }

    public ProductState getState(){
        return this.state;
    }

    public void setState(ProductState state){
        this.state = state;
    }

    public String loanProduct(int days){
        return this.state.loanProduct(days);
    }

    public String removeProduct(){
        return this.state.removeProduct();
    }

    public String returnProduct(boolean isBeschadigd){
        return this.state.returnProduct(isBeschadigd);
    }

    public String repairProduct(){
        return this.state.repairProduct();
    }

    @Override
    public boolean equals(Object o) {
        if (o instanceof Product) {
            return ((Product) o).getTitle().equals(this.getTitle());
        }
        return false;
    }

    @Override
    public String toString() {
        return this.getTitle() + "  (" + this.getClass().getSimpleName() + ")  " + this.getState();
    }
}