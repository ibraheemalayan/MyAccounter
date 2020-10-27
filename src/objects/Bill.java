/*
    this class is only for representing a bill in the database not for making a new one
    and it is not for editing it 
    because bills are uneditable after they are printed
    the only way to do that is to delete it and add another one 
*///TODO make a class that writes a bill for the first time to the database
package objects;

import java.util.ArrayList;
import java.util.Date;

public class Bill {

	private ArrayList<Bill_item> items ;
	private double sum ;
	private double paid;
	private int id;
	private String Address;
	private Date date;
	private int Auth_num;
	private Person customer;
	private String note;
	
	
	
	public Bill(ArrayList<Bill_item> items, double sum, double paid, int id, Date date,int Auth_num, Person customer , String Address , String note) {
		super();
		this.setAuth_num(Auth_num);  
		this.items = items;
		this.setNote(note);
		this.sum = sum;
		this.Address = Address;
		this.paid = paid;
		this.id = id;
		this.date = date;
		this.customer = customer;
	}
	
	public Bill(S_Bill sbill) {
		//TODO complete this constructer
	}
	
	public ArrayList<Bill_item> getItems() {
		return items;
	}
	public double getSum() {
		return sum;
	}
	public Person getCustomer() {
		return customer;
	}
	public int getId() {
		return id;
	}
	public Date getDate() {
		return date;
	}

	public double getPaid() {
		return paid;
	}

	public String getAddress() {
		return Address;
	}

	public static Bill read_bill(int id) {
		//TODO read a serialized bill from the database and format it (translate it) to normal bill
		return null;
	}
	
	public static void write_bill(Bill bill) {
		//TODO translate this bill for less size and write it to the database
		
	}

	public String getNote() {
		return note;
	}

	public void setNote(String note) {
		this.note = note;
	}

	public int getAuth_num() {
		return Auth_num;
	}

	public void setAuth_num(int auth_num) {
		Auth_num = auth_num;
	}

}
