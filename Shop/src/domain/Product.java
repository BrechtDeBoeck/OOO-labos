package domain;

import domain.database.ShopDB;

public abstract class Product {
    private ProductState uitleenbaar;
    private ProductState uitgeleend;
    private ProductState beschadigd;
    private ProductState verwijderd;

    private String title;
    private ProductState state;

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


    public String getTitle() {
        return this.title;
    }

    public abstract double getPrice(int days);

    public Boolean getUitgeleend() { return  this.state == uitgeleend;}

    public Boolean setUitgeleend() { this.state = uitgeleend;}

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