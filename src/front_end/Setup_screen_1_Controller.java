package front_end;

import javafx.scene.control.ProgressBar;
import javafx.scene.control.TextField;
import javafx.scene.layout.Pane;
import javafx.scene.text.Text;
import back_end.Setting_Controller;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;


public class Setup_screen_1_Controller {

	public Setup_screen_1_Controller() {
		
	}
	
	@FXML
	private Pane all;
	
	@FXML
	private TextField Connection_Address;
	
	@FXML
	private TextField username;
	
	@FXML
	private TextField password;
	
	@FXML 
	private ProgressBar loading_bar;
	
	@FXML
	private Pane test_connection;
	
	@FXML
	private Pane next;
	
	@FXML
	private Text status;
	
	
	@FXML
	private boolean Test_Connection()  {
		
		System.out.println("test connection clicked");
				
		Setting_Controller sc = new Setting_Controller();
		
		sc.set_connection_string(Connection_Address.getText(), username.getText(), password.getText());
		status.setText("Testing connection...");
		status.setVisible(true);
		if(sc.Test_Connection()) {System.out.println("Connection Succeeded"); status.setText("Connection Succeeded");return true;}
		else {System.out.println("Connection failed"); status.setText("Connection failed"); return false;}
	}
	
	@FXML
	private void Next_to_Setup_screen_2() {
		/*TODO remove this */
		Connection_Address.setText("MyAccounter");
		username.setText("root");
		password.setText("Mysql.Alayan7112002");
		/*TODO remove this */
		if(Test_Connection()) {
			FXMLLoader loader = new FXMLLoader(getClass().getResource("/front_end/fxml/Setup_screen_2.fxml"));

			try {
				all.getChildren().clear();
				all.getChildren().add((Pane) loader.load());
			}catch(Exception e){Setting_Controller.Exception_Handler(e);}
		}
	}
	
	@FXML
	private void hover_test_connection() {
		test_connection.setStyle("-fx-background-color: #FFFFFF");
		
	}
	@FXML
	private void end_hover_test_connection() {
		test_connection.setStyle("-fx-background-color: #2abf9e");
	}
	
	@FXML
	private void hover_next() {
		next.setStyle("-fx-background-color: #FFFFFF");
	}
	@FXML
	private void end_hover_next() {
		next.setStyle("-fx-background-color: #2abf9e");
	}

	@FXML
	private void Connection_Address_clicked() {
		Connection_Address.setText("");
	}
	
	@FXML
	private void username_clicked() {
		username.setText("");
	}
	
	@FXML
	private void password_clicked() {
		password.setText("");
	}

}
