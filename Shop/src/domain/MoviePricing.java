package domain;

public class MoviePricing implements Pricing{

    public double getPrice(int days){
        double price = 5;
        int daysLeft = days - 3;
        if (daysLeft > 0){
            price += (daysLeft * 2);
        }
        return price;
    }
}
