public abstract class Produit {
    protected float price;

    public float getPrice() {
        return price;
    }

    public Produit(float price) {
        this.price = price;
    }

    public abstract String getDescription();
}