package objects;

public class Product {

	private double price;
	private double profits;
	private int id;
	private String name;
	private double countity;
	private double sold;

	
	
	public Product(int id , String name,double price,double sold,double profits, double countity) {
		super();
		this.profits = profits;
		this.sold = sold;
		this.price = price;
	 	this.name = name;
		this.setId(id);
		this.countity = countity;
	}
	
	public double getPrice() {
		return price;
	}
	public String getName() {
		return name;
	}
	public double getCountity() {
		return countity;
	}
	
	public double getSold() {
		return sold;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	@Override
	public String toString() {
		return "Product [id=" + id + ", name=" + name + ", price=" + price + ", countity=" + countity + ", sold=" + sold
				 + "]";
	}

	public double getProfits() {
		return profits;
	}

	
	
}
