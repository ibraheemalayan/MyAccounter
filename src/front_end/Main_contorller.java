package front_end;


import javafx.scene.layout.Pane;
import javafx.scene.layout.VBox;
import java.io.IOException;
import back_end.Setting_Controller;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;



public class Main_contorller {
	
	public Main_contorller() {
		super();
	}
	
	public String connection_String;

	
	@FXML
	public void initialize() {
		Setting_Controller setting_controller = new Setting_Controller();
		
		connection_String = setting_controller.get_connection_string();
		
		
		
	}
	
	@FXML
	private VBox green_pane;
	
	@FXML
	private VBox black_pane;
	
	//****************************main menu panes start**************************************
	// *** Bills ***
	@FXML
	private Pane New_bill;
	@FXML
	private Pane Unofficial_bill;
	@FXML
	private Pane Recive_bill;
	@FXML
	private Pane History;
	
	// *** Reports ***
	@FXML
	private Pane General;
	@FXML
	private Pane This_month;
	@FXML
	private Pane Today;

	// *** Goods ***
	@FXML
	private Pane Storage;
	@FXML
	private Pane Add;

	// *** People ***
	@FXML
	private Pane Customers;
	@FXML
	private Pane Merchants;
	@FXML
	private Pane Depts;
	//****************************main menu panes end*****************************************
	//****************************************************************************************
	//****************************main menu hover methods start*******************************
	
	// *** Bills ***
	@FXML
	private void hover_main_menu_New_bill() {
		New_bill.setStyle("-fx-background-color: #2B2F33");
	}
	@FXML
	private void end_hover_main_menu_New_bill() {
		New_bill.setStyle("-fx-background-color: #33373B");
	}
	//***********************************************************
	
	@FXML
	private void hover_main_menu_Unofficial_bill() {
		Unofficial_bill.setStyle("-fx-background-color: #2B2F33");
	}
	@FXML
	private void end_hover_main_menu_Unofficial_bill() {
		Unofficial_bill.setStyle("-fx-background-color: #33373B");
	}
	//***********************************************************
	
	@FXML
	private void hover_main_menu_Recive_bill() {
		Recive_bill.setStyle("-fx-background-color: #2B2F33");
	}
	@FXML
	private void end_hover_main_menu_Recive_bill() {
		Recive_bill.setStyle("-fx-background-color: #33373B");
	}
	//***********************************************************
	
	@FXML
	private void hover_main_menu_History() {
		History.setStyle("-fx-background-color: #2B2F33");
	}
	@FXML
	private void end_hover_main_menu_History() {
		History.setStyle("-fx-background-color: #33373B");
	}
	
	// *** Reports ***
	@FXML
	private void hover_main_menu_this_month() {
		This_month.setStyle("-fx-background-color: #2B2F33");
	}
	@FXML
	private void end_hover_main_menu_this_month() {
		This_month.setStyle("-fx-background-color: #33373B");
	}
	//***********************************************************
	@FXML
	private void hover_main_menu_today() {
		Today.setStyle("-fx-background-color: #2B2F33");
	}
	@FXML
	private void end_hover_main_menu_today() {
		Today.setStyle("-fx-background-color: #33373B");
	}
	//***********************************************************
	@FXML
	private void hover_main_menu_General() {
		General.setStyle("-fx-background-color: #2B2F33");
	}
	@FXML
	private void end_hover_main_menu_General() {
		General.setStyle("-fx-background-color: #33373B");
	}
	// *** Goods ***
	@FXML
	private void hover_main_menu_storage() {
		Storage.setStyle("-fx-background-color: #2B2F33");		}
	@FXML
	private void end_hover_main_menu_storage() {
		Storage.setStyle("-fx-background-color: #33373B");
	}
	//***********************************************************
	@FXML
	private void hover_main_menu_add() {
		Add.setStyle("-fx-background-color: #2B2F33");
	}
	@FXML
	private void end_hover_main_menu_add() {
		Add.setStyle("-fx-background-color: #33373B");
	}
	// *** People ***
	@FXML
	private void hover_main_menu_Customers() {
		Customers.setStyle("-fx-background-color: #2B2F33");		
		}
	@FXML
	private void end_hover_main_menu_Customers() {
		Customers.setStyle("-fx-background-color: #33373B");
	}
	//***********************************************************
	@FXML
	private void hover_main_menu_Merchants() {
		Merchants.setStyle("-fx-background-color: #2B2F33");
	}
	@FXML
	private void end_hover_main_menu_Merchants() {
		Merchants.setStyle("-fx-background-color: #33373B");
	}
	//***********************************************************
	@FXML
	private void hover_main_menu_Depts() {
		Depts.setStyle("-fx-background-color: #2B2F33");
	}
	@FXML
	private void end_hover_main_menu_Depts() {
		Depts.setStyle("-fx-background-color: #33373B");
	}
	//****************************main menu hover methods end*******************************
	//**************************************************************************************
	//****************************   on click main menu      *******************************
	@FXML
	private void on_click_main_menu_storage() throws IOException {
		
		
		FXMLLoader loader_green_pane = new FXMLLoader(getClass().getResource("/front_end/fxml/Storage_GreenPane.fxml"));

		green_pane.getChildren().clear();
		green_pane.getChildren().add((VBox) loader_green_pane.load());
		
		FXMLLoader loader_black_pane = new FXMLLoader(getClass().getResource("/front_end/fxml/Storage_BlackPane.fxml"));

		black_pane.getChildren().clear();
		black_pane.getChildren().add((VBox) loader_black_pane.load());


	}

	
	
	
	
}
