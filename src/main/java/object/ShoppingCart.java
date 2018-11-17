package object;

public class ShoppingCart {
    private Flower product;
    private double price;
    private int quantity;

    public void setProduct(Flower product) {
        this.product = product;
    }

    public Flower getProduct() {
        return product;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public double getPrice() {
        return price;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public int getQuantity() {
        return quantity;
    }
}
