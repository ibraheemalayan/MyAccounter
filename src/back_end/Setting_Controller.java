package back_end;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import com.mysql.jdbc.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.Date;


public class Setting_Controller {
	
	//String original = "jdbc:mysql://localhost/MyAccounter?user=root&password=Mysql.Alayan7112002";
	//TODO make a test for the tables and the schema
	
	private String file_name = "Connection.st";
	private String Connection_String;
	public Boolean need_setup ;
	public static Connection con;

	public Setting_Controller()  {
		
		try {
		 
		if(is_there_connection_str()) {
		
            ObjectInputStream input = new ObjectInputStream(new FileInputStream(file_name));
		
		    Connection_String = input.readUTF();
		
		    input.close();
		
		    if(Test_Connection()) {
		    	
		    	con = ConnectDB(Connection_String);
		    	if(Is_there_myaccounter_schema()) { need_setup = false;
		    	}else {	need_setup = true; }
		    	
	    	}else {	need_setup = true; }
		    
		}else {	need_setup = true; }
		
		}catch(Exception e) {Exception_Handler(e);need_setup = true;}
		
	}

    public static Connection ConnectDB(String connectionString) {
		
		Connection connect = null;

		try{	
			Class.forName("com.mysql.jdbc.Driver");
			connect = (Connection) DriverManager.getConnection(connectionString);
		}catch(Exception e){Setting_Controller.Exception_Handler(e);}
	
		return connect;	
	}
    
	public void set_connection_string(String Connection_Address , String Username , String password){
		
		try {
			
		Connection_String = "jdbc:mysql://localhost/"+Connection_Address+"?user="+Username + "&password=" + password;
		
		System.out.println("new Connection String >> " + Connection_String);
		
        ObjectOutputStream output = new ObjectOutputStream(new FileOutputStream(file_name)); 
        
		output.writeUTF(Connection_String);
		
		output.close();
		
		con = ConnectDB(Connection_String);
		
		}catch(Exception e) {Exception_Handler(e);}
	}
	
	public String get_connection_string(){
		
		System.out.println(" Connection_String >> "+Connection_String);
		
		return Connection_String;
	}
	
	public Boolean is_there_connection_str(){
		
		try {
		
		File f = new File(file_name);
		if(f.exists() && !f.isDirectory()) { 

		ObjectInputStream input = new ObjectInputStream(new FileInputStream(file_name));
		
		if(input.available() != 0 ) {
			
			input.close();
			return true;
		}
		
		input.close();
		
		return false;
		
		}else {return false;}
		
		}catch(Exception e) {System.out.println(" >!> Error in is_there_connection_str");Exception_Handler(e);}
		
		return false;
		
	}

	public Boolean Test_Connection() {
		try {
			
			Class.forName("com.mysql.jdbc.Driver");
			DriverManager.getConnection(Connection_String);
		    return true;
		    
		}catch(Exception e){Exception_Handler(e);return false;}
	}
	
	public static void Exception_Handler(Exception e) {
		/*TODO print and handle errors*/
		
		String err_txt = e.toString();
		
		/*   Handling >>>>> down here  */
		
		if(err_txt.contains("com.mysql.jdbc.exceptions.jdbc4.MySQLIntegrityConstraintViolationException: Duplicate entry")) {
			System.err.print("..._\n known_err >>> " + e.getMessage() + "\n..._");
			e.printStackTrace();
//		}else if() {
//			
//		}else if() {
			
		}else {
			e.printStackTrace();
		}
		
		
		
		
	}

	public boolean Is_there_myaccounter_schema() {
		
		ArrayList<String> res = new ArrayList<>();
		
		try {
			
			ResultSet rs = con.getMetaData().getCatalogs();
			
			while (rs.next()) {
			    res.add(rs.getString("TABLE_CAT"));
			}

			if(res.contains("myaccounter")) {return true ;}
			else                            {return false;}
		
		} catch (Exception e) { Exception_Handler(e);}
		
		return false;

	}

	public boolean Create_schema() {
		
		PreparedStatement pr = null;
		try{
			
			pr = Setting_Controller.con.prepareStatement("CREATE SCHEMA `myaccounter` ;");
			pr.executeUpdate();
			return true;
		} catch (Exception e) { Exception_Handler(e);}
		return false;
	}

    public boolean Create_products_table() {
    	
    	
    	PreparedStatement pr = null;
		try{
			
			pr = Setting_Controller.con.prepareStatement("CREATE TABLE `myaccounter`.`products` (\r\n" + 
					"    			  `id` INT(11) NOT NULL AUTO_INCREMENT,\r\n" + 
					"    			  `name` VARCHAR(50) NOT NULL,\r\n" + 
					"    			  `price` DECIMAL(7,2) NOT NULL,\r\n" + 
					"    			  `countity` DECIMAL(6,2) ZEROFILL UNSIGNED NOT NULL DEFAULT 0,\r\n" + 
					"    			  `sold` DECIMAL(7,2) UNSIGNED ZEROFILL NOT NULL DEFAULT 0,\r\n" + 
					"    			  `bills_IDs` MEDIUMTEXT NULL DEFAULT NULL,\r\n" + 
					"    			  PRIMARY KEY (`id`),\r\n" + 
					"    			  UNIQUE INDEX `name_UNIQUE` (`name` ASC) VISIBLE,\r\n" + 
					"    			  UNIQUE INDEX `id_UNIQUE` (`id` ASC) VISIBLE);");
			pr.executeUpdate();
			return true;
		} catch (Exception e) { Exception_Handler(e);}
		return false;

    }
    
    public boolean Add_Product(String Name , Double Price , Double Countity , Double Buy_Price , Double Sold , Double Profit ) {
    	
    	//INSERT INTO `myaccounter`.`products` (`name`, `price`, `countity`, `buy_price`, `sold`, `profits`, `Date_created`) VALUES ('Neo', '565', '657', '657', '67', '67', '2019-05-22 12:30:29');

    	PreparedStatement pr = null;
		try{
			
			pr = Setting_Controller.con.prepareStatement("INSERT INTO `myaccounter`.`products` (`name`, `price`, `countity`, `buy_price`, `sold`, `profits`, `Date_created`) VALUES (?,?,?,?,?,?,?);");
			pr.setString(1, Name);
			pr.setDouble(2, Price);
			pr.setDouble(3, Countity);
			pr.setDouble(4, Buy_Price);
			pr.setDouble(5, Sold);
			pr.setDouble(6, Profit);
			pr.setTimestamp(7, new Timestamp( new Date().getTime() )  );
			pr.executeUpdate();
			return true;
		} catch (Exception e) { Exception_Handler(e);}
		return false;
    	
    }
    
    public static Date get_Date() {
		return new Date();
    }
    
    @SuppressWarnings("deprecation")
	public static String get_Date_txt() {
    	
    	Date date = get_Date();
    	
    	int year = date.getYear() + 1900;
    	int month = date.getMonth();
    	int day = date.getDate();

    	int week_day = date.getDay();
    	
    	String Week_Day = "" ;
    	
    	switch(week_day) {
    	 
    	case 0 : Week_Day = "Sunday" ;break;
    	case 1 : Week_Day = "Monday" ;break;
    	case 2 : Week_Day = "Tuesday" ;break;
    	case 3 : Week_Day = "Wednesday" ;break;
    	case 4 : Week_Day = "Thursday" ;break;
    	case 5 : Week_Day = "Friday" ;break;
    	case 6 : Week_Day = "Saturday" ;break;
    	}
    	
    	
		return ( " " + Week_Day + " : " + day + " / " + month + " / " + year + " " );
    }
    
    public boolean Is_Product_Name( String name ) {
    	
    	PreparedStatement pr = null;
		try{
			pr = Setting_Controller.con.prepareStatement("SELECT count(*) FROM myaccounter.products where myaccounter.products.name = ?;");
			pr.setString(1, name);
			
		    ResultSet res = pr.executeQuery();
		    
		    res.next();
		    
		    if(res.getInt(1) == 0) {
		    	return false;
		    }
 
			return true;
			
		} catch (Exception e) { Exception_Handler(e);}
		
		return false;
		
    }
    
}
