package front_end;

import javafx.scene.control.Label;
import javafx.scene.control.ProgressBar;
import javafx.scene.control.ProgressIndicator;
import javafx.scene.control.ScrollPane;
import javafx.scene.layout.Pane;
import javafx.scene.text.Text;
import tasks.DataBase_Setup_Task;
import javafx.scene.Cursor;
import back_end.Setting_Controller;
import javafx.application.Platform;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;

@SuppressWarnings("unused")
public class Setup_screen_2_Controller {

	private Thread thread;
	private DataBase_Setup_Task task ;
	
	@FXML
	private Text status;
	
	@FXML
	private Pane all;
	
	@FXML 
	private Text news;
	
	@FXML
	private Pane next;
	
	@FXML
	private ProgressIndicator indicator;
	
	@FXML 
	private ProgressBar loading_bar;
	
	@FXML
	private Label next_txt;
	
	@FXML
	private ScrollPane scroller ;
	
	@FXML
	private Pane start;
	
	@FXML
	private Pane news_pane;
	
	@FXML
	private Label start_txt;
	
	@FXML
	public void initialize() {
	
		task = new DataBase_Setup_Task (scroller,status,news,next,indicator,loading_bar,next_txt,start,news_pane,start_txt);
		
		thread = new Thread(task);
		
		
	}
	
	@FXML
	private void hover_next() {
		if(task.Is_Done) {
		next.setStyle("-fx-background-color: #FFFFFF");
	    }
	}
	
	@FXML
	private void end_hover_next() {
		if(task.Is_Done) {
		next.setStyle("-fx-background-color: #2abf9e");
		}
	}
	
	@FXML
	private void next() {
		if(task.Is_Done) {
			
			FXMLLoader loader = new FXMLLoader(getClass().getResource("/front_end/fxml/Setup_screen_done.fxml"));

			try {
				all.getChildren().clear();
				all.getChildren().add((Pane) loader.load());
			}catch(Exception e){Setting_Controller.Exception_Handler(e);}
			
		}else {System.out.println(">>> Not done yet");}
	}
	
	@FXML
	private void Start_setup() {
		
		if(!thread.isAlive() && !task.Is_Done) {
			
			thread.start();
		}
		
		
	}
	
	@FXML
	private void hover_start() {
		start.setStyle("-fx-background-color: #FFFFFF");
	}
	
	@FXML
	private void end_hover_start() {
		start.setStyle("-fx-background-color: #2abf9e");
	}
}
