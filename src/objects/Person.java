package objects;

import java.util.ArrayList;

public class Person {

	private int id;
	private String name;
	private int phone_num;
	private ArrayList<Bill> bills;
	private double balance = 0;
	
	public Person(int id, String name, int phone_num, double balance, ArrayList<Bill> bills) {
		super();
		this.id = id;
		this.name = name;
		this.phone_num = phone_num;
		this.bills = bills;
		this.balance = balance;/*balance with him (what you need from him)*/
	}
	
	public void change_Balance(double amount) {
		balance = balance + amount;
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
	public int getPhone_num() {
		return phone_num;
	}
	public void setPhone_num(int phone_num) {
		this.phone_num = phone_num;
	}
	public ArrayList<Bill> getBills() {
		return bills;
	}
	public void setBills(ArrayList<Bill> bills) {
		this.bills = bills;
	}
	public double getBalance() {
		return balance;
	}
	public void setBalance(double balance) {
		this.balance = balance;
	}
	
	
	
}
