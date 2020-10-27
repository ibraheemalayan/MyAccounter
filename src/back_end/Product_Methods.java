package back_end;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import objects.Product;



public class Product_Methods {
	
	/*
	 * TODO 
	 * make an items table in the database 
	 * with date and customer id 
	 * this table will be the main for **REPORTS**
	*/

	public Product_Methods() {
		
	}
	// tested
	public static int Add_product( Product product ) {
		
		    int new_id = 0;
			PreparedStatement pr = null;
			try{
				
				pr = Setting_Controller.con.prepareStatement("insert into myaccounter.products(name,price,countity,sold) values (?,?,?,?);");
				pr.setString(1, product.getName());
				pr.setDouble(2, product.getPrice());
				pr.setDouble(3, product.getCountity());
				pr.setDouble(4, product.getSold());
				pr.executeUpdate();
				
				PreparedStatement st = Setting_Controller.con.prepareStatement("SELECT * FROM myaccounter.products WHERE (name = ?);");
	            st.setString(1, product.getName());
	            ResultSet res =st.executeQuery();
	            res.next();
	            new_id = res.getInt("id"); 
				
				System.out.println("product is inserted with id "+new_id+" ! >> " + product.toString());
				
			}catch(Exception e){Setting_Controller.Exception_Handler(e);}
			
			return new_id;
	}
	// tested	
	public static void remove_product( int id ) {
		
		PreparedStatement pr = null;
		try{
			
			pr = Setting_Controller.con.prepareStatement("DELETE FROM myaccounter.products WHERE (id = ?);");
			pr.setInt(1, id);
			
			pr.executeUpdate();
			
			System.out.println("product is removed ! ID>> " + id );
			
		}catch(Exception e){Setting_Controller.Exception_Handler(e);}
	}
	// tested
	public static void recive_product( Product product , double num) {
		
		
		try {
			
			PreparedStatement p = Setting_Controller.con.prepareStatement("SELECT * FROM myaccounter.products WHERE (name = ?);");
            p.setString(1, product.getName());
            ResultSet r =p.executeQuery();
            r.next();
            product.setId(r.getInt("id")); 
          //TODO  product.setCountity(r.getDouble("countity"));
			
			PreparedStatement pr = Setting_Controller.con.prepareStatement("UPDATE `myaccounter`.`products` SET `countity` = `countity`+ ? WHERE (`id` = ?);");
			pr.setDouble( 1 , num );
			pr.setInt( 2 , product.getId() );
			
            pr.executeUpdate();
            
            System.out.print("info >> product with id "+product.getId()+" countity is increased by "+num+" > was " + product.getCountity());
			
            PreparedStatement st = Setting_Controller.con.prepareStatement("SELECT * FROM myaccounter.products WHERE (id = ?);");
            st.setInt(1, product.getId());
            ResultSet res =st.executeQuery();
            
            res.next();
     //TODO       product.setCountity(res.getDouble("countity"));
            
            
			System.out.print( " became " + product.getCountity());
			
		} catch (SQLException e) {Setting_Controller.Exception_Handler(e);}
	   
	}
	// tested
	public static void edit_product(int id , Product new_product) {
		
		PreparedStatement pr = null;
		
		try{
			
			pr = Setting_Controller.con.prepareStatement("DELETE FROM myaccounter.products WHERE (id = ?);");
			pr.setInt(1, id);
			pr.executeUpdate();
			Add_product(new_product);

		}catch(Exception e){Setting_Controller.Exception_Handler(e);}

	}
	
	public static int get_product_count() {
		
		try {
			
			PreparedStatement p = Setting_Controller.con.prepareStatement("SELECT count(*) FROM myaccounter.products;");
			ResultSet r =p.executeQuery();
			r.next();
			int res = r.getInt(1);
			return res;
			
		}catch(Exception e) {Setting_Controller.Exception_Handler(e);}
		return 0;
	}
	
	public static int get_product_id(Product product) {
		
        try {
			
			PreparedStatement p = Setting_Controller.con.prepareStatement("SELECT id FROM myaccounter.products WHERE (name = ?);");
            p.setString(1, product.getName());
            ResultSet r =p.executeQuery();
            r.next();
            return r.getInt(1);
            
         } catch (SQLException e) {Setting_Controller.Exception_Handler(e);}
        return 0;
		
	}
    
	public static void get_product_report() {
		
	}
	
	public static Product get_product(int id) {
		return null;
	}
    
    public static void get_merchant_report() {
		
	}
    
    public static void get_daily_report() {
		
	}
    
    public static void get_month_report(int month) {
    	
    	
		
	}
	
	public void add_customer() {
		
	}
	
	public void get_customer_report() {
		
	}
	
	public void add_merchant() {
		
	}
	
	
}
