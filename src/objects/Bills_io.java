package objects;

import java.util.ArrayList;
import java.util.Date;

public class Bills_io {

	public static Bill get_bill(int id) {
		
		Bill res = null;
		
		//TODO complete here
		
		return res;
	}
	
	public static Bill new_bill(ArrayList<Bill_item> items, double sum, double paid, Person customer) {
		
		customer.change_Balance(sum-paid);
		
        Bill res = null;
		
		//TODO build the serilaizable bill and save it to the database then return it unserilaized FROM THE DATABASE to make sure it is good
		
		return res;
		
	}
	
}
