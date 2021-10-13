package domain;

public class Uitleenbaar implements ProductState {
    Product product;

    public Uitleenbaar(Product product){
        this.product = product;
    }
}
