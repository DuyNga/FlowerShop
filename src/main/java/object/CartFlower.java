package object;

public class CartFlower {
    private Flower flower;
    private double price;
    private int qty;

    public CartFlower(Flower flower, double price, int qty) {
        this.flower = flower;
        this.price = price;
        this.qty = qty;
    }

    public Flower getFlower() {
        return flower;
    }

    public void setFlower(Flower flower) {
        this.flower = flower;
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
