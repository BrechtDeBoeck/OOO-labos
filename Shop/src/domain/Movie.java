package domain;

public class Movie extends Product {
    public Movie(String title){
        super(title);
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
