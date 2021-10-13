package domain;

import domain.database.ShopDB;

public abstract class Product {
    String title;
    Boolean uitgeleend = false;

    public Product(String title) {
        setTitle(title);
    }

    private void setTitle(String title) {
        if (title == null || title.trim().isEmpty()) {
            throw new IllegalArgumentException("Title may not be empty");
        }
        this.title = title;
    }


    public String getTitle() {
        return this.title;
    }

    public abstract double getPrice(int days);

    public Boolean getUitgeleend() { return  this.uitgeleend;}

    public Boolean setUitgeleend() { return this.uitgeleend = true;}

    @Override
    public boolean equals(Object o) {
        if (o instanceof Product) {
            return ((Product) o).getTitle().equals(this.getTitle());
        }
        return false;
    }

    @Override
    public String toString() {
        return this.getTitle() + "  (" + this.getClass().getSimpleName() + ") uitgeleend: " + this.getUitgeleend();
    }
}