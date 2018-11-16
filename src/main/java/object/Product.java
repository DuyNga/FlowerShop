package object;

public class Product {
    private int id;
    private String productName;
    private String imageName;
    private String fullDescription;
    private String shortDescription;
    private double price;

    public Product (int id, String productName, String imageName, String fullDescription, String shortDescription, double price){
        this.id = id;
        this.productName = productName;
        this.imageName = imageName;
        this.fullDescription = fullDescription;
        this.shortDescription = shortDescription;
        this.price = price;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getId() {
        return id;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }

    public String getProductName() {
        return productName;
    }

    public void setImageName(String imageName) {
        this.imageName = imageName;
    }

    public String getImageName() {
        return imageName;
    }

    public void setFullDescription(String fullDescription) {
        this.fullDescription = fullDescription;
    }

    public String getFullDescription() {
        return fullDescription;
    }

    public void setShortDescription(String shortDescription) {
        this.shortDescription = shortDescription;
    }

    public String getShortDescription() {
        return shortDescription;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public double getPrice() {
        return price;
    }
}
