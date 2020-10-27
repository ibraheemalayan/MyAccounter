package objects;

import java.util.ArrayList;

import back_end.Product_Methods;

public class Product_Report {

	private int id;
    private ArrayList<Bill> bills ;
    private ArrayList<Recieve_Bill> r_bills;
    private ArrayList<Merchant> merchants;
    private ArrayList<Bill_item> items;
    private double sold_last_month;
    private double sold_this_month;
    private double profits_last_month;
    private double profits_this_month;
    private Product product;
    
    public Product_Report(int id){
    	
    	this.id = id;
    	
    	product = Product_Methods.get_product(id);
    	
    	//TODO use multi threading in obtaining the report
    }
    
    
    /******************************************/

	public ArrayList<Bill> getBills() {
		return bills;
	}

	public void setBills(ArrayList<Bill> bills) {
		this.bills = bills;
	}

	public ArrayList<Recieve_Bill> getR_bills() {
		return r_bills;
	}

	public void setR_bills(ArrayList<Recieve_Bill> r_bills) {
		this.r_bills = r_bills;
	}

	public ArrayList<Merchant> getMerchants() {
		return merchants;
	}

	public void setMerchants(ArrayList<Merchant> merchants) {
		this.merchants = merchants;
	}

	public ArrayList<Bill_item> getItems() {
		return items;
	}

	public void setItems(ArrayList<Bill_item> items) {
		this.items = items;
	}

	public int getId() {
		return id;
	}

	public double getSold_last_month() {
		return sold_last_month;
	}

	public double getSold_this_month() {
		return sold_this_month;
	}

	public double getProfits_last_month() {
		return profits_last_month;
	}

	public double getProfits_this_month() {
		return profits_this_month;
	}

	public Product getProduct() {
		return product;
	}
    
    

}
