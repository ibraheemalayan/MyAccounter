package front_end;

import back_end.Setting_Controller;
import javafx.application.Platform;
import javafx.fxml.FXML;
import javafx.scene.layout.Pane;

public class Setup_screen_done {

	@FXML
	private Pane Start;
	
	@FXML
	private void hover_start() {
		Start.setStyle("-fx-background-color: #FFFFFF");
	}
	
	@FXML
	private void end_hover_start() {
		Start.setStyle("-fx-background-color: #2abf9e");
	}
	
	@FXML
	private void Start_MyAccounter() {
		
		try {
			
			System.out.println("Start MyAccounter...Clicked\n");
			Platform.exit();
			
		} catch (Exception e) {Setting_Controller.Exception_Handler(e);}
		
	}

}
