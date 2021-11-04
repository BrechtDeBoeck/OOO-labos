package domain;

public class CD extends Product{
    public CD(String title) {
        super(title);
        setPricing(new CDPricing());
    }

    @Override
    public boolean equals(Object o) {
        if (o instanceof CD) {
            return super.equals(o);
        }
        return false;
    }

    @Override
    public String toString() {
        return super.toString();
    }
}
