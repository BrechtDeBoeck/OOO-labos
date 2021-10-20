package domain;

public class GamePricing implements Pricing{

    public double getPrice(int days){
        return days * 3;
    }
}
