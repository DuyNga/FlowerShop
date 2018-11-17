package object;

public class CartFlower {
    private Flower product;
    private double price;
    private int qty;

    public CartFlower(Flower product, double price, int qty) {
        this.product = product;
        this.price = price;
        this.qty = qty;
    }

    public Flower getFlower() {
        return product;
    }

    public double getPrice() {
        return price;
    }

    public int getQty() {
        return qty;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public void setQty(int qty) {
        this.qty = qty;
    }

}
