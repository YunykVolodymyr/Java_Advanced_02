package ua.yunyk;

public class Commodity {

	private int id;
	private String name;
	private float priceForOne;
	private int quantity;

	public Commodity(int id, String name, float priceForOne, int quantity) {
		super();
		this.id = id;
		this.name = name;
		this.priceForOne = priceForOne;
		this.quantity = quantity;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public float getPriceForOne() {
		return priceForOne;
	}

	public void setPriceForOne(float priceForOne) {
		this.priceForOne = priceForOne;
	}

	public int getQuantity() {
		return quantity;
	}

	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}

	@Override
	public String toString() {
		return "Commodity [id=" + id + ", name=" + name + ", priceForOne=" + priceForOne + ", quantity=" + quantity
				+ "]";
	}

}
