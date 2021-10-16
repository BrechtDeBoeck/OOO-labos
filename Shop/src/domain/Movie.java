package domain;

public class Movie extends Product {

    public Movie(String title){
        super(title);
    }

    @Override
    public double getPrice(){
        double price = 5;
        int daysLeft = days - 3;
        if (daysLeft > 0){
            price += (daysLeft * 2);
        }
        return price;
    }

    @Override
    public boolean equals(Object o){
        if (o instanceof Movie){
            return super.equals(o);
        }
        return false;
    }

    @Override
    public String toString(){
        return super.toString();
    }
}
