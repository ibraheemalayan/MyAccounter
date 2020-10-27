package tasks;

import java.io.IOException;

import back_end.Setting_Controller;
import front_end.Loading_controller;
import front_end.Raw_notification_window_Controller;
import front_end.Raw_sure_window_Controller;
import front_end.main_win;
import javafx.event.Event;
import javafx.event.EventHandler;
import javafx.fxml.FXMLLoader;
import javafx.scene.control.TextField;
import javafx.scene.image.ImageView;
import javafx.scene.input.KeyEvent;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.Pane;
import javafx.scene.shape.Rectangle;
import javafx.scene.text.Font;
import javafx.scene.text.Text;
import javafx.stage.Stage;

/* TODO 
 *     
 *     change the $ to shekle sign and check messages spellings
 *     
 *     TODO #FDCFCA for field error on done click
 *     
 *     TODO make an error for empty required fields
 *     
 *     TODO check if the name is used
 *     
 *     TODO add error sound
 *     
 *     TODO make red fields on error feilds when done click and a pop up window with the error messege with whitening the main window
 *     
 *     
 *     
 * */

public class New_Product_window_Tasker implements Runnable {
	
	private String Name_Field_text = "";
	private double Price_Field_value = 0;
	private double Buy_Price_Field_value = 0;
	private double Countity_Field_value = 0;
	private double Sold_Field_value = 0;
	private double Profits_Field_value = 0;

	private ImageView Warning_img_price;
	private ImageView Warning_img_buy_price;
	private ImageView Warning_img_Name;
    private ImageView Warning_img_countity;
	private ImageView Warning_img_sold;
	private ImageView Warning_img_profits;
	private ImageView name_img;
	private ImageView price_img;
	private ImageView buy_price_img;
	private ImageView sold_img;
	private ImageView profit_img;
	private ImageView countity_img;
	private TextField Name_Field;
	private TextField Price_Field;
	private TextField Buy_Price_Field;
	private TextField Date_Field;
	private TextField Countity_Field;
	private TextField Sold_Field;
	private TextField Profits_Field;
	private Rectangle Name_message_bubble;
	private Rectangle Price_message_bubble;
	private Rectangle Buy_price_message_bubble;
	private Rectangle data_message_bubble;
	private Rectangle Name_message_arrow;
	private Rectangle Price_message_arrow;
	private Rectangle Buy_price_message_arrow;
	private Rectangle data_message_arrow;
	private Text Name_message_txt;
	private Text Price_message_txt;
	private Text Buy_price_message_txt;
	private Text data_message_txt;
    private Pane root_pane;
    private Stage New_Product_Stage;

	protected Stage notification;
	private boolean done_clicked = false;
	private String used_name = "12365487246157245124357245123479864527315664572865481157";
	//any string more than 45 chars TODO you can change this way for more security 

	public New_Product_window_Tasker(ImageView warning_img_price,
			ImageView warning_img_buy_price, ImageView warning_img_Name,
			TextField name_Field, TextField price_Field, TextField buy_Price_Field, TextField date_Field,
			TextField countity_Field, TextField sold_Field, TextField profits_Field, Rectangle name_message_bubble,
			Rectangle price_message_bubble, Rectangle buy_price_message_bubble, Rectangle data_message_bubble,
			Rectangle name_message_arrow, Rectangle price_message_arrow, Rectangle buy_price_message_arrow,
			Rectangle data_message_arrow, Text name_message_txt, Text price_message_txt, Text buy_price_message_txt,
			Text data_message_txt, ImageView name_img, ImageView price_img, ImageView buy_price_img, ImageView countity_img
			, ImageView sold_img, ImageView profits_img, ImageView Warning_img_countity, 
			ImageView Warning_img_sold, ImageView Warning_img_profits, Pane root_pane, Stage New_Product_Stage) {
		super();
		Warning_img_price = warning_img_price;
		Warning_img_buy_price = warning_img_buy_price;
		Warning_img_Name = warning_img_Name;
		Name_Field = name_Field;
		Price_Field = price_Field;
		Buy_Price_Field = buy_Price_Field;
		Date_Field = date_Field;
		Countity_Field = countity_Field;
		Sold_Field = sold_Field;
		Profits_Field = profits_Field;
		Name_message_bubble = name_message_bubble;
		Price_message_bubble = price_message_bubble;
		Buy_price_message_bubble = buy_price_message_bubble;
		this.data_message_bubble = data_message_bubble;
		Name_message_arrow = name_message_arrow;
		Price_message_arrow = price_message_arrow;
		Buy_price_message_arrow = buy_price_message_arrow;
		this.data_message_arrow = data_message_arrow;
		Name_message_txt = name_message_txt;
		Price_message_txt = price_message_txt;
		Buy_price_message_txt = buy_price_message_txt;
		this.data_message_txt = data_message_txt;
		this.name_img = name_img;
		this.price_img = price_img;
		this.buy_price_img = buy_price_img;
		this.countity_img = countity_img;
		this.sold_img = sold_img;
		this.profit_img = profits_img;
		this.Warning_img_countity = Warning_img_countity;
		this.Warning_img_sold = Warning_img_sold;
		this.Warning_img_profits = Warning_img_profits;
		this.root_pane = root_pane;
		this.New_Product_Stage = New_Product_Stage;
	}

	@Override
	public void run() {
		
		Date_Field.setText(Setting_Controller.get_Date_txt());
		
		root_pane.setOnMouseClicked(Refresh);
		Name_Field.setOnMouseClicked(Refresh);
		Price_Field.setOnMouseClicked(Refresh);
		Buy_Price_Field.setOnMouseClicked(Refresh);
		Countity_Field.setOnMouseClicked(Refresh);
		Sold_Field.setOnMouseClicked(Refresh);
		Profits_Field.setOnMouseClicked(Refresh);
		
		Name_Field.setOnKeyTyped(Name_typed);
		Price_Field.setOnKeyTyped(Price_typed);
		Buy_Price_Field.setOnKeyTyped(Buy_Price_typed);
		Countity_Field.setOnKeyTyped(Countity_typed);
		Sold_Field.setOnKeyTyped(Sold_typed);
		Profits_Field.setOnKeyTyped(Profits_typed);
		
	}
	
	public void Done() {
		
		done_clicked = true;
		
		boolean good = true;
		
		//TODO add the product to the database
		
		Name_Field_text = Name_Field_text.trim();
		
		if( Name_Field_text.length() < 1 ) {
			
			Name_Field.setStyle("-fx-background-color : #FDCFCA ");
			
			fire_notification(2);
			
			good = false;
		}	
		
		if( Price_Field_value == 0 ) {
			
            Price_Field.setStyle("-fx-background-color : #FDCFCA ");
            
			fire_notification(2);
			
			good = false;
		}	
		
		System.out.println("Buy Price val = " + Buy_Price_Field_value );
			
        if( Buy_Price_Field_value == 0 ) {
			
        	Buy_Price_Field.setStyle("-fx-background-color : #FDCFCA ");
        
			fire_notification(2);
			
			good = false;
		}   
        
        if(!good) {return;}
        
       
        if(main_win.sc.Is_Product_Name(Name_Field_text)) {
        	
        	Name_Field.setStyle("-fx-background-color : #FDCFCA ");
        	
        	Name_message_arrow.setVisible(true);
        	Name_message_bubble.setVisible(true);
        	Name_message_txt.setText("used name");
        	Name_message_txt.setVisible(true);
        	Warning_img_Name.setVisible(true);
        	name_img.setVisible(false);
        	
        	used_name = Name_Field_text;

        	fire_notification(3);
        	
        	good = false;
        	
        }
        
        if(!good) {return;}
        
        //Add the product
        
        fire_notification(4);

		
	}
	
	public void Cancel() {
		
		fire_notification(1);
		
	}

	private EventHandler<Event> Refresh = new EventHandler<Event>() {
		
		@Override
		public void handle(Event event) {
			refresh();
		}
		
	};
 
	private EventHandler<KeyEvent> Name_typed = new EventHandler<KeyEvent>() {

		@Override
		public void handle(KeyEvent event) {
			
			
			if( Name_Field.getText().length() < 45 ) {
				
				if( Name_Field.getText().length() > 0 && !Name_Field.getText().equals(used_name)) {
					
					Name_message_arrow.setVisible(false);
					Name_message_txt.setVisible(false);
					Name_message_bubble.setVisible(false);
					Warning_img_Name.setVisible(false);
					name_img.setVisible(true);
					
					Name_Field.setStyle("-fx-background-color :  #eeeff2");
					
					Name_Field_text = Name_Field.getText();
					
					Name_Field.setFont(Font.font(  (Name_Field_text.length() < 15 )?22:18  ));
					
				}else if( done_clicked && Name_Field.getText().length() < 1 ){
				
					Name_message_arrow.setVisible(true);
					Name_message_txt.setText("required field");
					Name_message_txt.setVisible(true);
					Name_message_bubble.setVisible(true);
					Warning_img_Name.setVisible(true);
					name_img.setVisible(false);
					
					Name_Field_text = Name_Field.getText();
					
	
				}else {
					
					Name_message_arrow.setVisible(true);
					Name_message_txt.setText("name used");
					Name_message_txt.setVisible(true);
					Name_message_bubble.setVisible(true);
					Warning_img_Name.setVisible(true);
					name_img.setVisible(false);
					
					Name_Field_text = Name_Field.getText();	
				}

			}else {
				
				Name_Field.deletePreviousChar();
				
				Name_message_arrow.setVisible(true);
				Name_message_txt.setText("45 charcters as max");
				Name_message_txt.setVisible(true);
				Name_message_bubble.setVisible(true);
				Warning_img_Name.setVisible(true);
				name_img.setVisible(false);
				
				Name_Field_text = Name_Field.getText().trim();
				
				
			}
			
		}
		
	};		
    private EventHandler<KeyEvent> Price_typed = new EventHandler<KeyEvent>() {

		@Override
		public void handle(KeyEvent event) {

			
			String txt = Price_Field.getText();
			
			if( ! IsDigital(txt) ) {
				
				
				
				Price_Field.deletePreviousChar();
				
				Price_message_arrow.setVisible(true);
				Price_message_txt.setText("Digits only");
				Price_message_txt.setVisible(true);
				Price_message_bubble.setVisible(true);
				Warning_img_price.setVisible(true);
				price_img.setVisible(false);
				
				Price_Field_value = (Price_Field.getText().length() > 0)?Double.parseDouble( Price_Field.getText() ):0;
				
				
			} else {
				
				txt = Price_Field.getText() ;
				
				if( txt.length() > 0) {
				
				double val = Double.parseDouble( txt );
				
				if( val > 999999.99 ) {
					
	                Price_Field.deletePreviousChar();
					
					Price_message_arrow.setVisible(true);
					Price_message_txt.setText("up to 10^6 $");
					Price_message_txt.setVisible(true);
					Price_message_bubble.setVisible(true);
					Warning_img_price.setVisible(true);
					price_img.setVisible(false);
					
					Price_Field.setStyle("-fx-background-color :  #eeeff2");
					
					Price_Field_value = Double.parseDouble( Price_Field.getText() );
					
					
				} else {
					
					Price_message_arrow.setVisible(false);
					Price_message_txt.setVisible(false);
					Price_message_bubble.setVisible(false);
					Warning_img_price.setVisible(false);
					price_img.setVisible(true);
					
					Price_Field.setStyle("-fx-background-color :  #eeeff2");
					
					Price_Field_value = val;
	
				}
				
				}else {
					
					Price_message_arrow.setVisible(true);
					Price_message_txt.setText("required field");
					Price_message_txt.setVisible(true);
					Price_message_bubble.setVisible(true);
					Warning_img_price.setVisible(true);
					price_img.setVisible(false);
					
					Price_Field_value = (Price_Field.getText().length() > 0)?Double.parseDouble( Price_Field.getText() ):0;
					
				}
				
			}
			
		}
		
	};
	private EventHandler<KeyEvent> Buy_Price_typed = new EventHandler<KeyEvent>() {

		@Override
		public void handle(KeyEvent event) {
			

			String txt = Buy_Price_Field.getText();
			
			if( ! IsDigital(txt) ) {
				
				Buy_Price_Field.deletePreviousChar();
				
				Buy_price_message_arrow.setVisible(true);
				Buy_price_message_txt.setText("Digits only");
				Buy_price_message_txt.setVisible(true);
				Buy_price_message_bubble.setVisible(true);
				Warning_img_buy_price.setVisible(true);
				buy_price_img.setVisible(false);
				
				Buy_Price_Field_value = (Buy_Price_Field.getText().length() > 0)?Double.parseDouble( Buy_Price_Field.getText() ):0;
				
				
			} else {
				
				txt = Buy_Price_Field.getText() ;
				
				if( txt.length() > 0 ) {
				
				double val = Double.parseDouble( txt );
				
				if( val > 999999.99 ) {
					
					Buy_Price_Field.deletePreviousChar();
					
					Buy_price_message_arrow.setVisible(true);
					Buy_price_message_txt.setText("up to 10^6 $");
					Buy_price_message_txt.setVisible(true);
					Buy_price_message_bubble.setVisible(true);
					Warning_img_buy_price.setVisible(true);
					buy_price_img.setVisible(false);

					Buy_Price_Field_value = Double.parseDouble( Buy_Price_Field.getText() );
					
					Buy_Price_Field.setStyle("-fx-background-color :  #eeeff2");
					
				} else {
					
					Buy_price_message_arrow.setVisible(false);
					Buy_price_message_txt.setVisible(false);
					Buy_price_message_bubble.setVisible(false);
					Warning_img_buy_price.setVisible(false);
					buy_price_img.setVisible(true);
					
					Buy_Price_Field.setStyle("-fx-background-color :  #eeeff2");
					
					Buy_Price_Field_value = val;
	
				}
				
			}else {
				
				Buy_price_message_arrow.setVisible(true);
				Buy_price_message_txt.setText("required field");
				Buy_price_message_txt.setVisible(true);
				Buy_price_message_bubble.setVisible(true);
				Warning_img_buy_price.setVisible(true);
				buy_price_img.setVisible(false);

				Buy_Price_Field_value = (Buy_Price_Field.getText().length() > 0)?Double.parseDouble( Buy_Price_Field.getText() ):0;
			
			}
				
			}
			
		}

	};
	private EventHandler<KeyEvent> Countity_typed = new EventHandler<KeyEvent>() {

		@Override
		public void handle(KeyEvent event) {
			
			
			String txt = Countity_Field.getText();
			
			if( ! IsDigital(txt) ) {
				
				Countity_Field.deletePreviousChar();
				
				data_message_arrow.setVisible(true);
				data_message_txt.setText("Digits only");
				data_message_txt.setVisible(true);
				data_message_bubble.setVisible(true);
	        	Warning_img_countity.setVisible(true);
	        	countity_img.setVisible(false);
	        	
	        	Countity_Field_value = (Countity_Field.getText().length() > 0)?Double.parseDouble( Countity_Field.getText() ):0;
				
			} else {
				
				txt = Countity_Field.getText() ;
				
				if( !(txt.trim().length() < 1) ) {
				
				double val = Double.parseDouble( txt );
				
				if( val > 999999.999 ) {
					
					Countity_Field.deletePreviousChar();
					
					data_message_arrow.setVisible(true);
					data_message_txt.setText("up to 10^4");
					data_message_txt.setVisible(true);
					data_message_bubble.setVisible(true);
		        	Warning_img_countity.setVisible(true);
		        	countity_img.setVisible(false);
		        	
		        	Countity_Field_value = Double.parseDouble( Countity_Field.getText() );
					
				} else {
					
					data_message_arrow.setVisible(false);
					data_message_txt.setVisible(false);
					data_message_bubble.setVisible(false);
					Warning_img_countity.setVisible(false);
					countity_img.setVisible(true);
					
					Countity_Field_value = val;
	
				}
				
			}
			}
			
		}

	};
	private EventHandler<KeyEvent> Sold_typed = new EventHandler<KeyEvent>() {

		@Override
		public void handle(KeyEvent event) {
			
			
			String txt = Sold_Field.getText();
			
			if( ! IsDigital(txt) ) {
				
				Sold_Field.deletePreviousChar();
				
				data_message_arrow.setVisible(true);
				data_message_txt.setText("Digits only");
				data_message_txt.setVisible(true);
				data_message_bubble.setVisible(true);
	        	Warning_img_sold.setVisible(true);
	        	sold_img.setVisible(false);
	        	
	        	Sold_Field_value = (Sold_Field.getText().length() > 0)?Double.parseDouble( Sold_Field.getText() ):0;
				
			} else {
				
				txt = Sold_Field.getText() ;
				
				if( !(txt.trim().length() < 1) ) {
				
				double val = Double.parseDouble( txt );
				
				if( val > 999999.99 ) {
					
					Sold_Field.deletePreviousChar();
					
					data_message_arrow.setVisible(true);
					data_message_txt.setText("up to 10^4");
					data_message_txt.setVisible(true);
					data_message_bubble.setVisible(true);
		        	Warning_img_sold.setVisible(true);
		        	sold_img.setVisible(false);
		        	
		        	Sold_Field_value = Double.parseDouble( Sold_Field.getText() );
					
				} else {
					
					data_message_arrow.setVisible(false);
					data_message_txt.setVisible(false);
					data_message_bubble.setVisible(false);
					Warning_img_sold.setVisible(false);
					sold_img.setVisible(true);
					
					Sold_Field_value = val;
	
				}
				
			}
			}
			
		}

	};	
    private EventHandler<KeyEvent> Profits_typed = new EventHandler<KeyEvent>() {

		@Override
		public void handle(KeyEvent event) {
			
			
			
			String txt = Profits_Field.getText();
			
			if( ! IsDigital(txt) ) {
				
				Profits_Field.deletePreviousChar();
				
				data_message_arrow.setVisible(true);
				data_message_txt.setText("Digits only");
				data_message_txt.setVisible(true);
				data_message_bubble.setVisible(true);
	        	Warning_img_profits.setVisible(true);
	        	profit_img.setVisible(false);
	        	
	        	Profits_Field_value = (Profits_Field.getText().length() > 0 )?Double.parseDouble( Profits_Field.getText() ):0;
				
			} else {
				
				txt = Profits_Field.getText() ;
				
				if( !(txt.trim().length() < 1) ) {
				
				double val = Double.parseDouble( txt );
				
				if( val > 9999999.99 ) {
					
					Profits_Field.deletePreviousChar();
					
					data_message_arrow.setVisible(true);
					data_message_txt.setText("up to 10^7");
					data_message_txt.setVisible(true);
					data_message_bubble.setVisible(true);
		        	Warning_img_profits.setVisible(true);
		        	profit_img.setVisible(false);

		        	Profits_Field_value = Double.parseDouble( Profits_Field.getText() );
					
				} else {
					
					data_message_arrow.setVisible(false);
					data_message_txt.setVisible(false);
					data_message_bubble.setVisible(false);
					Warning_img_profits.setVisible(false);
					profit_img.setVisible(true);
					
					Profits_Field_value = val;
	
				}
				
			}
			}
			
		}

	};
	
	
	
	private void refresh() { 
		
		Name_Field_text = Name_Field.getText();
		
		// Name **********************************************
		
		if( Name_Field.getText().length() < 45 && Name_Field.getText().length() > 0 && ( !Name_Field_text.trim().equals(used_name.trim() ) )) {
			
			Name_message_arrow.setVisible(false);
			Name_message_txt.setVisible(false);
			Name_message_bubble.setVisible(false);
			Warning_img_Name.setVisible(false);
			name_img.setVisible(true);
			
			Name_Field_text = Name_Field.getText().trim();
			
			Name_Field.setFont(Font.font(  (Name_Field_text.length() < 15 )?22:18  ));
			
			if((!(Name_Field_text.length() < 1)) && ( !Name_Field_text.trim().equals(used_name.trim() ))) {
				
				Name_Field.setStyle("-fx-background-color :  #eeeff2"); 
				
				}
						
		}else if ( Name_Field.getText().length() >= 45 ){
			
			Name_message_arrow.setVisible(true);
			Name_message_txt.setText("45 charcters as max");
			Name_message_txt.setVisible(true);
			Name_message_bubble.setVisible(true);
			Warning_img_Name.setVisible(true);
			name_img.setVisible(false);
			
			Name_Field_text = Name_Field.getText().trim();
			
			
		}else if(done_clicked && Name_Field.getText().length() < 1){
			
			Name_message_arrow.setVisible(true);
			Name_message_txt.setText("required field");
			Name_message_txt.setVisible(true);
			Name_message_bubble.setVisible(true);
			Warning_img_Name.setVisible(true);
			name_img.setVisible(false);
			
			Name_Field_text = Name_Field.getText().trim();
			
		}else{
			
			Name_message_arrow.setVisible(true);
			Name_message_txt.setText("name used");
			Name_message_txt.setVisible(true);
			Name_message_bubble.setVisible(true);
			Warning_img_Name.setVisible(true);
			name_img.setVisible(false);
			
			Name_Field_text = Name_Field.getText().trim();
			
		}
		
		//Price **************************
		
		String txt_price = Price_Field.getText();
		
		if( ! IsDigital(txt_price) ) {
			
			Price_message_arrow.setVisible(true);
			Price_message_txt.setText("Digits only");
			Price_message_txt.setVisible(true);
			Price_message_bubble.setVisible(true);
			Warning_img_price.setVisible(true);
			price_img.setVisible(false);
			
			
			
		} else {
			
			txt_price = Price_Field.getText() ;
			
			if( txt_price.length() > 0 ) {
				
				double val = Double.parseDouble( txt_price );
				
				if( val > 999999.99 ) {
					
	               
					
					Price_message_arrow.setVisible(true);
					Price_message_txt.setText("up to 10^6 $");
					Price_message_txt.setVisible(true);
					Price_message_bubble.setVisible(true);
					Warning_img_price.setVisible(true);
					price_img.setVisible(false);
					
				} else {
					
					Price_message_arrow.setVisible(false);
					Price_message_txt.setVisible(false);
					Price_message_bubble.setVisible(false);
					Warning_img_price.setVisible(false);
					price_img.setVisible(true);
					
					Price_Field_value = val;
					
					if(done_clicked && !(Price_Field_value == 0)) {  Price_Field.setStyle("-fx-background-color :  #eeeff2"); }
					else if(done_clicked) {Price_Field.setStyle("-fx-background-color : #FDCFCA ");}
				}
				
			}else  if(done_clicked){
				
				Price_message_arrow.setVisible(true);
				Price_message_txt.setText("required field");
				Price_message_txt.setVisible(true);
				Price_message_bubble.setVisible(true);
				Warning_img_price.setVisible(true);
				price_img.setVisible(false);
				
				Price_Field_value = (Price_Field.getText().length() > 0)?Double.parseDouble( Price_Field.getText() ):0;
				
			}
			
			
		}
		
		//Buy Price ********************************************
		

		
		String txt_buy_price = Buy_Price_Field.getText();
		
		if( ! IsDigital(txt_buy_price) ) {
			
		
			
			Buy_price_message_arrow.setVisible(true);
			Buy_price_message_txt.setText("Digits only");
			Buy_price_message_txt.setVisible(true);
			Buy_price_message_bubble.setVisible(true);
			Warning_img_buy_price.setVisible(true);
			buy_price_img.setVisible(false);
			
			
			
		} else {
			
			txt_buy_price = Buy_Price_Field.getText();
			
			if( txt_buy_price.length() > 0) {
		
				
				double val = Double.parseDouble( txt_buy_price );
				
				if( val > 999999.99 ) {
					
				
					
					Buy_price_message_arrow.setVisible(true);
					Buy_price_message_txt.setText("up to 10^6 $");
					Buy_price_message_txt.setVisible(true);
					Buy_price_message_bubble.setVisible(true);
					Warning_img_buy_price.setVisible(true);
					buy_price_img.setVisible(false);
					
				} else {
					
					Buy_price_message_arrow.setVisible(false);
					Buy_price_message_txt.setVisible(false);
					Buy_price_message_bubble.setVisible(false);
					Warning_img_buy_price.setVisible(false);
					buy_price_img.setVisible(true);
					
					Buy_Price_Field_value = val;
					
					if(done_clicked && !(Buy_Price_Field_value == 0)) {  Buy_Price_Field.setStyle("-fx-background-color :  #eeeff2"); }
	                
			}
			
	      }else if(done_clicked){
				
				Buy_price_message_arrow.setVisible(true);
				Buy_price_message_txt.setText("required field");
				Buy_price_message_txt.setVisible(true);
				Buy_price_message_bubble.setVisible(true);
				Warning_img_buy_price.setVisible(true);
				buy_price_img.setVisible(false);

				Buy_Price_Field_value = (Buy_Price_Field.getText().length() > 0)?Double.parseDouble( Buy_Price_Field.getText() ):0;
			
			}
		}
		
		//Countity ********************************************
		

		
		String txt_countity = Countity_Field.getText();
		
		if( ! IsDigital(txt_countity) ) {
					
			data_message_arrow.setVisible(true);
			data_message_txt.setText("Digits only");
			data_message_txt.setVisible(true);
			data_message_bubble.setVisible(true);
        	Warning_img_countity.setVisible(true);
        	countity_img.setVisible(false); 
        	
        
			
		} else if( !(txt_countity.trim().length() < 1) ) {
				
				double val = Double.parseDouble( txt_countity );
				
				if( val > 999999.99 ) {
					
					data_message_arrow.setVisible(true);
					data_message_txt.setText("up to 10^4");
					data_message_txt.setVisible(true);
					data_message_bubble.setVisible(true);
		        	Warning_img_countity.setVisible(true);
		        	countity_img.setVisible(false);
					
				} else {
					
					data_message_arrow.setVisible(false);
					data_message_txt.setVisible(false);
					data_message_bubble.setVisible(false);
					Warning_img_countity.setVisible(false);
					countity_img.setVisible(true);
					
					Countity_Field_value = val;
					
			}
			
		}
		
		// sold ***************************************************
		

		
		String txt_sold = Sold_Field.getText();
		
		if( ! IsDigital(txt_sold) ) {

			data_message_arrow.setVisible(true);
			data_message_txt.setText("Digits only");
			data_message_txt.setVisible(true);
			data_message_bubble.setVisible(true);
        	Warning_img_sold.setVisible(true);
        	sold_img.setVisible(false);
        	
        	
			
		} else if( !(txt_sold.trim().length() < 1) ) {
				
				double val = Double.parseDouble( txt_sold );
				
				if( val > 999999.99 ) {
					
					
					
					data_message_arrow.setVisible(true);
					data_message_txt.setText("up to 10^4");
					data_message_txt.setVisible(true);
					data_message_bubble.setVisible(true);
		        	Warning_img_sold.setVisible(true);
		        	sold_img.setVisible(false);
					
				} else {
					
					data_message_arrow.setVisible(false);
					data_message_txt.setVisible(false);
					data_message_bubble.setVisible(false);
					Warning_img_sold.setVisible(false);
					sold_img.setVisible(true);
					
					Sold_Field_value = val;
					
					
					
				
			}
			
		}
		
		//** profits ************************************************
		

		
		String txt_profits = Profits_Field.getText();
		
		if( ! IsDigital(txt_profits) ) {
			
			
			data_message_arrow.setVisible(true);
			data_message_txt.setText("Digits only");
			data_message_txt.setVisible(true);
			data_message_bubble.setVisible(true);
        	Warning_img_profits.setVisible(true);
        	profit_img.setVisible(false);
        	
			
		} else if( !(txt_profits.trim().length() < 1) ) {
				
				double val = Double.parseDouble( txt_profits );
				
				if( val > 9999999.99 ) {
					
					data_message_arrow.setVisible(true);
					data_message_txt.setText("up to 10^7");
					data_message_txt.setVisible(true);
					data_message_bubble.setVisible(true);
		        	Warning_img_profits.setVisible(true);
		        	profit_img.setVisible(false);
					
				} else {
					
					data_message_arrow.setVisible(false);
					data_message_txt.setVisible(false);
					data_message_bubble.setVisible(false);
					Warning_img_profits.setVisible(false);
					profit_img.setVisible(true);
					
					Profits_Field_value = val;
			
		 }
			
	   }

	}		

	private boolean IsDigital(String txt) {
		
		
		
		txt = txt.trim() ;
		
		if(txt.length() < 1) {return true;}
		
		try {
			
			Double.parseDouble(txt);
			
			return true;
			
		}catch (Exception e) {
			
			return false;
			
			}
		
		
	}

	private void fire_notification(int type) {		
		/*
		 * 1 for (are you sure) stage
		 * 2 for (fill required fields) stage
		 * 3 for (name used) stage
		 * 4 for (loading) stage
		 */
		
		if( notification != null ) { notification.close(); }
		
		switch(type) {
		
		case 1 : {
			FXMLLoader loader = new FXMLLoader(getClass().getResource("/front_end/fxml/Raw_sure_stage.fxml"));
			
			notification = null;
			
			try {    notification = (Stage)(loader.load());} catch (IOException e) {  Setting_Controller.Exception_Handler(e);  }

			
			
			Raw_sure_window_Controller controller = loader.<Raw_sure_window_Controller>getController();
			
			controller.set_blured_Pane(root_pane);
			
			controller.Yes_button.setOnMouseClicked((EventHandler<? super MouseEvent>) new EventHandler<MouseEvent>() {
	            @Override
	            public void handle(MouseEvent event) {
	            	main_win.New_Product_Stage.close();
	            	notification.close();
	            }
	        });
		    
			notification.show();

		    break;
		}
		case 2 : {
			
            FXMLLoader loader = new FXMLLoader(getClass().getResource("/front_end/fxml/Fill_required_fields_notification_window.fxml"));
			
			notification = null;
			
			try {    notification = (Stage)(loader.load());} catch (IOException e) {  Setting_Controller.Exception_Handler(e);  }

			loader.<Raw_notification_window_Controller>getController().set_blured_Pane(root_pane);;
			
			notification.show();
			
			break;
		}
		
        case 3 : {
			
            FXMLLoader loader = new FXMLLoader(getClass().getResource("/front_end/fxml/Name_used_notification_Stage.fxml"));
			
			notification = null;
			
			try {    notification = (Stage)(loader.load());} catch (IOException e) {  Setting_Controller.Exception_Handler(e);  }

			loader.<Raw_notification_window_Controller>getController().set_blured_Pane(root_pane);;
			
			notification.show();
			
			break;
		}
        
        case 4 : {
        	
            FXMLLoader loader = new FXMLLoader(getClass().getResource("/front_end/fxml/Loading.fxml"));

			notification = null;
			
			try {    notification = (Stage)(loader.load());   } catch (IOException e) {  Setting_Controller.Exception_Handler(e);  }
			
			loader.<Loading_controller>getController().set_Parameters(New_Product_Stage , true , Insert_Product);

			break;
        	
        }
        
        
		
		
		
		
		}
	
	}
	
	
	public Runnable Insert_Product = new Runnable() {		
    	@Override
		public void run() {
    		main_win.sc.Add_Product
    		    (Name_Field_text, Price_Field_value, Countity_Field_value, Buy_Price_Field_value, Sold_Field_value, Profits_Field_value);
		}
	};

}
