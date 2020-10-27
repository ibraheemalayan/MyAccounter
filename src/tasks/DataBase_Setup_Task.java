package tasks;

import back_end.Setting_Controller;
import front_end.main_win;
import javafx.scene.Cursor;
import javafx.scene.control.Label;
import javafx.scene.control.ProgressBar;
import javafx.scene.control.ProgressIndicator;
import javafx.scene.control.ScrollPane;
import javafx.scene.layout.Pane;
import javafx.scene.text.Text;

public class DataBase_Setup_Task implements Runnable{
	

	private Text status;
	private Text news;
	private Pane next;
	private ProgressIndicator indicator;
	private ProgressBar loading_bar;
	public boolean Is_Done = false;
	private Label next_txt;
	private ScrollPane scroller;
	private Pane start;
	private Pane news_pane;
	private Label start_txt;

	

	public DataBase_Setup_Task(ScrollPane scroller ,Text status, Text news, Pane next, ProgressIndicator indicator, ProgressBar loading_bar,
			Label next_txt, Pane start, Pane news_pane, Label start_txt) {
		super();
		this.status = status;
		this.news = news;
		this.scroller = scroller;
		this.next = next;
		this.indicator = indicator;
		this.loading_bar = loading_bar;
		this.next_txt = next_txt;
		this.start = start;
		this.news_pane = news_pane;
		this.start_txt = start_txt;
	}

	


	@Override
	public void run() {
	try {
		
		System.out.println("Starting_setup");
		Thread.sleep(1000);
		indicator.setVisible(true);
		news_pane.setCursor(Cursor.WAIT);
		next.setCursor(Cursor.WAIT);
		next.setVisible(true);
		next_txt.setVisible(true); 
		start.setVisible(false);
		start_txt.setVisible(false);
		loading_bar.setVisible(true);
		status.setText("Detecting precreated SCHEMAS...");
		news.setText("Searching for myaccounter schema ... ");
		scroller.setVvalue(scroller.getVmax());
		if(main_win.sc.Is_there_myaccounter_schema()) {
			
			Thread.sleep(1000);
			news.setText(news.getText()+"\n- "+"myaccounter schema already exists");
			scroller.setVvalue(scroller.getVmax());
			news.setText(news.getText()+"\n- "+"checking the tables ...");
			scroller.setVvalue(scroller.getVmax());
			status.setText("checking the tables ...");
			loading_bar.setProgress(loading_bar.getProgress()+0.1);
			System.out.println("the schema is found");
			//TODO complete the tests here
		}else {
			
			Thread.sleep(1000);
			news.setText(news.getText()+"\n- "+"myaccounter schema wasn't found");
			scroller.setVvalue(scroller.getVmax());
			news.setText(news.getText()+"\n- "+"creating new schema ...");
			scroller.setVvalue(scroller.getVmax());
			status.setText("creating new schema ...");
			loading_bar.setProgress(loading_bar.getProgress()+0.1);
			System.out.println("schema wasn't found");
			
			if(main_win.sc.Create_schema()) {
				
				Thread.sleep(1000);
				news.setText(news.getText()+"\n- "+"schema was succesfully created");
				scroller.setVvalue(scroller.getVmax());
				news.setText(news.getText()+"\n- "+"creating tables ...");
				scroller.setVvalue(scroller.getVmax());
				status.setText("creating tables ...");
				loading_bar.setProgress(loading_bar.getProgress()+0.1);
				System.out.println("schema was succesfully created");
				
				if(main_win.sc.Create_products_table()) {
					
					Thread.sleep(1000);
					news.setText(news.getText()+"\n- "+"products table was succesfully created");
					scroller.setVvalue(scroller.getVmax());
					loading_bar.setProgress(loading_bar.getProgress()+0.1);
					System.out.println("products table was succesfully created");
					//TODO continue >> make other tables
					news.setText(news.getText()+"\n- "+"You can click next !!!");
					scroller.setVvalue(scroller.getVmax());
					loading_bar.setProgress(1);
					status.setText("DONE !");
					news_pane.setCursor(Cursor.DEFAULT);
					next.setCursor(Cursor.DEFAULT);
					next.setStyle("-fx-background-color: #2abf9e");
					indicator.setVisible(false);
					Is_Done = true;
					/*complete then add the above */
					
				}else {
				    news.setStyle("-fx-fill: #FF0000");
				    news.setText(news.getText()+"\n- "+"Error >> see error log for details");
				    scroller.setVvalue(scroller.getVmax());
				    status.setText("ERROR !");
				    status.setStyle("-fx-fill: #FF0000");
				    
			    }
				
			}else {
				news.setStyle("-fx-fill: #FF0000");
				news.setText(news.getText()+"\n- "+"Error >> see error log for details");
				scroller.setVvalue(scroller.getVmax());
				status.setText("ERROR !");
			    status.setStyle("-fx-fill: #FF0000");
			}
		    }
		
	        }catch(Exception e) {Setting_Controller.Exception_Handler(e);}
	        }

}

