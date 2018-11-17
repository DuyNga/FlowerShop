package mapper;

public class FlowerMapper {
    private int id;
    private int qty;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getQty() {
        return qty;
    }

    public void setQty(int qty) {
        this.qty = qty;
    }

    public String toString(){
        return String.format( "Flower Mapper[id: %s, qty: %s]",String.valueOf(id),String.valueOf(qty));
    }
}
