package front_end;

import javafx.fxml.FXML;
import javafx.scene.control.ProgressIndicator;
import javafx.scene.text.Text;
import javafx.stage.Stage;
import javafx.stage.StageStyle;
import tasks.Loading_Task;

public class Loading_controller{

	@FXML
	private Stage Loading_Stage;
	
	@FXML
	private ProgressIndicator indicator;
	
	@FXML
	private Text txt;
	
	private Stage Blured_Stage;
	private boolean Close_After_Done;
	private Runnable Task;

	@FXML
	private void initialize() {
		
		Loading_Stage.initStyle(StageStyle.UNDECORATED);

	}
	
    public void set_Parameters(Stage Blured_Stage , boolean Close_After_Done , Runnable Task) { 
		
		this.Blured_Stage = Blured_Stage;
		this.Close_After_Done = Close_After_Done;
		this.Task = Task;
		
		Loading_Task timer = new Loading_Task( OnDone , OnNearDone );
		
		indicator.progressProperty().unbind();
		
		indicator.progressProperty().bind(timer.progressProperty());
		
		Loading_Stage.show();
		
		Blured_Stage.getScene().getRoot().setEffect(main_win.Stage_blur);
		
		Thread timer_thread = new Thread(timer);
		timer_thread.start();

	}
    
    private Runnable OnDone = new Runnable() {
		
		@Override
		public void run() {
			
			Blured_Stage.getScene().getRoot().setEffect(null);
			if(Close_After_Done) {  Blured_Stage.close();  }
			Loading_Stage.close();

		}
	};
	
    private Runnable OnNearDone = new Runnable() {
		
    	@Override
		public void run() {
			
    		Task.run();
    		
			txt.setText("Your all Done !");

		}
	};


    
    
    
    
	
	
	
}
