package ua.yunyk;

public class Customer {

	private int id;
	private String firstName;
	private String lastName;
	private float amountOfMoney;

	public Customer(int id, String firstName, String lastName, float amountOfMoney) {
		super();
		this.id = id;
		this.firstName = firstName;
		this.lastName = lastName;
		this.amountOfMoney = amountOfMoney;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public float getAmountOfMoney() {
		return amountOfMoney;
	}

	public void setAmountOfMoney(float amountOfMoney) {
		this.amountOfMoney = amountOfMoney;
	}

	@Override
	public String toString() {
		return "Customer [id=" + id + ", firstName=" + firstName + ", lastName=" + lastName + ", amountOfMoney="
				+ amountOfMoney + "]";
	}

}
