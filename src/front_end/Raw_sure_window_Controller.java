package front_end;

import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Paint;
import javafx.scene.shape.Line;
import javafx.scene.shape.Rectangle;
import javafx.stage.Stage;
import javafx.stage.StageStyle;

public class Raw_sure_window_Controller {
	
	@FXML
	private Stage notification_stage;
	
	@FXML
	private Rectangle Close_button;
	
	@FXML
	private Line Close_Line_1;
	
	@FXML
	private Line Close_Line_2;
	
	@FXML
	public Button Yes_button;
	
	@FXML
	public Button No_button;
	
	protected double notification_XOffset; 
	protected double notification_YOffset;
	
	private Pane blured_Pane;
	
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
		
		blured_Pane.setEffect(null);
		
		notification_stage.close();
		
	}
	
	@FXML
	private void initialize() {
		
		No_button.setOnMouseClicked((EventHandler<? super MouseEvent>) new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent event) {
            	
            	blured_Pane.setEffect(null);
            	
            	notification_stage.close();
            	
            }
        });
		
        notification_stage.initStyle(StageStyle.UNDECORATED);
		
		
		notification_stage.getScene().setOnMousePressed((EventHandler<? super MouseEvent>) new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent event) {
            	notification_XOffset = event.getSceneX();
            	notification_YOffset = event.getSceneY();
            }
        });                                
		notification_stage.getScene().setOnMouseDragged(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent event) {
            	notification_stage.setX(event.getScreenX() - notification_XOffset);
            	notification_stage.setY(event.getScreenY() - notification_YOffset);
            }
        });
	
	}
	
	public void set_blured_Pane(Pane p) {
		
		blured_Pane = p;
		
		blured_Pane.setEffect(main_win.Stage_blur);
		
	}
	

}
