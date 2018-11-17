package object;

public class Flower {
    private int id;
    private String flowerName;
    private String imageName;
    private String fullDescription;
    private String shortDescription;
    private double price;

    public Flower(int id, String flowerName, String imageName, String fullDescription, String shortDescription, double price){
        this.id = id;
        this.flowerName = flowerName;
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

    public void setFlowerName(String flowerName) {
        this.flowerName = flowerName;
    }

    public String getFlowerName() {
        return flowerName;
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
