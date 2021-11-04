package domain;


public class CDPricing implements Pricing{

    public double getPrice(int days) {
        return days * 1.5;
    }
}
