package tasks;

import back_end.Setting_Controller;
import javafx.application.Platform;
import javafx.concurrent.Task;

//TODO set all threads to daemon true so the JVM exist and shutdown the tasks and threads at the moment the last stage got closed

public class Loading_Task extends Task<Integer>{
	
	private Runnable OnDone;
	private Runnable OnNearDone;

	public Loading_Task( Runnable OnDone , Runnable OnNearDone) {
		this.OnDone = OnDone;
		this.OnNearDone = OnNearDone;
	}

	@Override
	public void run() {
		
		try {Thread.sleep(2000);} catch (InterruptedException e) {Setting_Controller.Exception_Handler(e);}
		updateProgress(0, 100);
		
		for(double i = 3 ; i <= 37 ; i = i + 2) {

			updateProgress(i, 100);
			try {Thread.sleep(15);} catch (InterruptedException e) {Setting_Controller.Exception_Handler(e);}
			
		}

		updateProgress(52, 100);
		try {Thread.sleep(300);} catch (InterruptedException e) {Setting_Controller.Exception_Handler(e);}
		
		
        for(double i = 52 ; i <= 79 ; i = i + 3) {
			
        	updateProgress(i, 100);
			try {Thread.sleep(20);} catch (InterruptedException e) {Setting_Controller.Exception_Handler(e);}
			
		}
        
        updateProgress(98, 100);
		try {Thread.sleep(300);} catch (InterruptedException e) {Setting_Controller.Exception_Handler(e);}
		
		updateProgress(100, 100);
		Platform.runLater(OnNearDone);

		try {Thread.sleep(800);} catch (InterruptedException e) {Setting_Controller.Exception_Handler(e);}
		Platform.runLater(OnDone);
	}

	@Override
	protected Integer call() throws Exception {    return 0 ;    }


	
}
