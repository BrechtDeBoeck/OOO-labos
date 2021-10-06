package domain;

public abstract class Product {
    String title;

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

    @Override
    public boolean equals(Object o) {
        if (o instanceof Product) {
            return ((Product) o).getTitle().equals(this.getTitle());
        }
        return false;
    }

    @Override
    public String toString() {
        return this.getTitle() + "  (" + this.getClass().getSimpleName() + ")";
    }
}