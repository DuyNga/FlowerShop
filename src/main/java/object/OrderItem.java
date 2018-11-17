package object;

import java.util.Objects;

public class OrderItem {
	private String id;
	private int flowerQty;
	private Flower flower;

	public OrderItem(String id, int flowerQty, Flower flower) {
		this.id = id;
		this.flowerQty = flowerQty;
		this.flower = flower;
	}

	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}

	public int getFlowerQty() {
		return flowerQty;
	}

	public void setFlowerQty(int flowerQty) {
		this.flowerQty = flowerQty;
	}

	public Flower getFlower() {
		return flower;
	}

	public void setFlower(Flower flower) {
		this.flower = flower;
	}

	@Override
	public boolean equals(Object obj) {
		if ( obj == null || !(obj instanceof OrderItem) ) {
			return false;
		}
		OrderItem orderItem = (OrderItem) obj;
		return this.getId() == orderItem.getId();
	}

	@Override
	public int hashCode() {
		return Objects.hashCode(this.getId());
	}
}
