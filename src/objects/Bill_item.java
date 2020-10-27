package objects;

public class Bill_item {

	private int id;
	private Product product;
	private double price;
	private double total;
	private double profit;
	private String note;
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getName() {
		return product.getName();
	}
	public double getPrice() {
		return price;
	}
	public void setPrice(double price) {
		this.price = price;
	}
	public double getTotal() {
		return total;
	}
	public void setTotal(double total) {
		this.total = total;
	}
	public String getNote() {
		return note;
	}
	public void setNote(String note) {
		this.note = note;
	}
	public Bill_item(int id, double price, double total,double profit, String note) {
		super();
		this.id = id;
		this.price = price;
		this.profit = profit;
		this.total = total;
		this.note = note;
		
		//TODO get product by id
	}
	public double getProfit() {
		return profit;
	}
	public void setProfit(double profit) {
		this.profit = profit;
	}
	public Product getProduct() {
		return product;
	}
	
	
	

}
