package front_end;

import javafx.scene.layout.VBox;
import javafx.scene.text.Text;
import back_end.Product_Methods;
import javafx.fxml.FXML;

public class Storage_GreenPane_Controller {
	
	
	@FXML
	private Text Products_count;
	
	@FXML 
	private VBox green_pane;
	
	@FXML
	public void initialize() {
		Products_count.setText(Product_Methods.get_product_count()+"");
	}
	
	@FXML
	private void click() {
		System.out.println("cllicked !!!!!!");
		Products_count.setText("hoh");
	}
	
	
	

}
