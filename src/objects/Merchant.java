package objects;

import java.util.ArrayList;

public class Merchant extends Person {
	
	private ArrayList<Recieve_Bill> r_bills;

	public Merchant(int id, String name, int phone_num, double balance, ArrayList<Bill> bills , ArrayList<Recieve_Bill> r_bills ) {
		
		super(id, name, phone_num, balance, bills);
		
		this.setR_bills(r_bills) ;
	}

	public ArrayList<Recieve_Bill> getR_bills() {
		return r_bills;
	}

	public void setR_bills(ArrayList<Recieve_Bill> r_bills) {
		this.r_bills = r_bills;
	}

}
