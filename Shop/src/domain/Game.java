package domain;

public class Game extends Product {
    public Game(String title){
        super(title);
    }

    @Override
    public boolean equals(Object o){
        if (o instanceof Game){
            return super.equals(o);
        }
        return false;
    }

    @Override
    public String toString(){
        return super.toString();
    }
}
