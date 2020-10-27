package front_end;

import back_end.Setting_Controller;
import javafx.application.Platform;
import javafx.fxml.FXML;
import javafx.scene.control.TextField;
import javafx.scene.image.ImageView;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Paint;
import javafx.scene.shape.Line;
import javafx.scene.shape.Rectangle;
import javafx.scene.text.Text;
import javafx.stage.Stage;
import tasks.New_Product_window_Tasker;

public class New_Product_Controller {
	
	private New_Product_window_Tasker tasker;
	
	//TODO make a file that saves the version of the system and put those to it
	@FXML
	private Pane root_pane;
	
	@FXML
	private Stage New_Product_Stage;
	
	@FXML
	private Text version_kind_txt;
	
	@FXML
	private Text Version_txt;
	
	@FXML
	private ImageView Warning_img_price;

	@FXML
	private ImageView Warning_img_buy_price;
	
	@FXML
	private ImageView Warning_img_Name;

	@FXML
	private Rectangle Close_button;
	
	@FXML
	private Line Close_Line_1;
	
	@FXML
	private Line Close_Line_2;
	
	@FXML
	private Rectangle Cancel_Rect;
	
	@FXML
	private Rectangle Done_Rect;
	
	@FXML
	private Text Done_txt;
	
	@FXML
	private Text Cancel_txt;
	
	@FXML
	private TextField Name_Field;
	
	@FXML
	private TextField Price_Field;
	
	@FXML
	private TextField Buy_Price_Field;
	
	@FXML
	private TextField Date_Field;
	
	@FXML
	private TextField Countity_Field;
	
	@FXML
	private TextField Sold_Field;
	
	@FXML
	private TextField Profits_Field;
	
	@FXML
	private ImageView name_img;
	
	@FXML
	private ImageView price_img;
	
	@FXML
	private ImageView buy_price_img;
	
	@FXML
	private ImageView sold_img;
	
	@FXML
	private ImageView profits_img;
	
	@FXML
	private ImageView countity_img;



	

	
	/***************************ERROR MESSAGES*********************/
	
	@FXML
	private Rectangle Name_message_bubble;
	
	@FXML
	private Rectangle Price_message_bubble;
	
	@FXML
	private Rectangle Buy_price_message_bubble;
	
	@FXML
	private Rectangle data_message_bubble;
	
	@FXML
	private Rectangle Name_message_arrow;
	
	@FXML
	private Rectangle Price_message_arrow;
	
	@FXML
	private Rectangle Buy_price_message_arrow;
	
	@FXML
	private Rectangle data_message_arrow;
	
	@FXML
	private Text Name_message_txt;

	@FXML
	private Text Price_message_txt;
	
	@FXML
	private Text Buy_price_message_txt;
	
	@FXML
	private Text data_message_txt;
	
	@FXML
	private ImageView Warning_img_countity;
	
	@FXML
	private ImageView Warning_img_sold;
	
	@FXML
	private ImageView Warning_img_profits;
	
	/***************************ERROR MESSAGES*********************/




	
	@FXML
	private void initialize() {

		/*  TODO add the product to the database
		 *  TODO add sounds on wrong click
		 * */
		

		tasker = new New_Product_window_Tasker(
				Warning_img_price,Warning_img_buy_price,Warning_img_Name,
				Name_Field,Price_Field,Buy_Price_Field,Date_Field,
				Countity_Field,Sold_Field,Profits_Field,Name_message_bubble,
				Price_message_bubble,Buy_price_message_bubble,data_message_bubble,
				Name_message_arrow,Price_message_arrow,Buy_price_message_arrow,
				data_message_arrow,Name_message_txt,Price_message_txt,Buy_price_message_txt,
				data_message_txt, name_img, price_img, buy_price_img, countity_img, sold_img, profits_img,
				Warning_img_countity, Warning_img_sold, Warning_img_profits, root_pane, New_Product_Stage
				);
		
		Platform.runLater(tasker);
	
		Date_Field.setText(Setting_Controller.get_Date_txt());
		
		
		
	}
	
	@FXML
	private void Exit_Pane_Entered() {
		
		Close_Line_1.setStroke(Paint.valueOf("#79828b"));
		Close_Line_2.setStroke(Paint.valueOf("#79828b"));

	}
	
	@FXML
	private void Exit_Pane_Exited() {
		
		Close_Line_1.setStroke(Paint.valueOf("#ababab"));
		Close_Line_2.setStroke(Paint.valueOf("#ababab"));
		
	}
	
	@FXML
	private void Exit_Pane_Clicked() {
		
		tasker.Cancel();
		
	}
/********************************************************************/
	@FXML
	private void Done_Pane_Entered() {
		
		Done_Rect.setFill(Paint.valueOf("#D9F3EA"));

	}
	
	@FXML
	private void Done_Pane_Exited() {
		
		Done_Rect.setFill(Paint.valueOf("#FBFBFB"));
		
	}
	
	@FXML
	private void Done_Pane_Clicked() {
		
		System.out.println("Done clicked");
		
		tasker.Done();
		
		//TODO ***  Add the product
		
	}
/********************************************************************/
	@FXML
	private void Cancel_Pane_Entered() {
		
		Cancel_Rect.setFill(Paint.valueOf("#FEDFDC"));
		
	}
	
	@FXML
	private void Cancel_Pane_Exited() {
		
		Cancel_Rect.setFill(Paint.valueOf("#FBFBFB"));
		
	}
	

	@FXML
	private void Cancel_Pane_Clicked() {
		
		

		tasker.Cancel();
		
	}
	

}
