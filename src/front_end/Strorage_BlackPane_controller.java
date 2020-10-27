package front_end;

import javafx.scene.control.ProgressIndicator;
import javafx.scene.control.ScrollPane;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.Pane;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Paint;
import javafx.scene.shape.Circle;
import javafx.scene.shape.Rectangle;
import javafx.scene.text.Text;
import javafx.stage.Stage;
import javafx.stage.StageStyle;
import objects.Product;
import tasks.Get_Products_task;

import java.io.IOException;
import java.util.ArrayList;

import back_end.Setting_Controller;
import javafx.application.Platform;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;

public class Strorage_BlackPane_controller {

	@FXML 
	private VBox black_pane;
	
	@FXML
	private ArrayList<Product> products;
	
	
	private Get_Products_task task ;
	
	@FXML
	private Rectangle Edit_Rect;
	
	@FXML
	private Text Edit_txt;
	
	@FXML
	private ImageView Edit_icon;
	
	@FXML
	private Rectangle add_rect;
	
	@FXML
	private ScrollPane Items_scroller;
	
	@FXML
	private VBox items_vbox;
	
	@FXML
	private Pane Add_Pane;
	
	@FXML
	private ImageView Add_icon;
	
	@FXML
	private ProgressIndicator data_indicater; 
	
	@FXML
	private Text add_txt;
	
	@FXML
	private Pane Setting;
	
	@FXML
	private Rectangle Setting_Rect;
	
	@FXML
	private ImageView Setting_icon;
	
	@FXML
	private Pane Refresh;
	
	@FXML
	private Rectangle Refresh_Rect;
	
	@FXML
	private ImageView Refresh_icon;
	
	@FXML
	private Circle Sort_by_Available;
	
	@FXML
	private Circle Sort_by_price;
	
	@FXML
	private Circle Sort_by_profits;
	
	@FXML
	private Circle Sort_by_sold_num;

	@FXML
	private Text Sort_by_Available_txt;
	
	@FXML
	private Text Sort_by_profits_txt;
	
	@FXML
	private Text Sort_by_price_txt;
	
	@FXML
	private Text Sort_by_sold_num_txt;
	
	private double xOffset = 0 ;
    private double yOffset = 0 ;
	
	@FXML
	private void initialize() {
		
		
		
		Sort_by_Available_txt.setVisible(false);
		Sort_by_price_txt.setVisible(false);
		Sort_by_sold_num_txt.setVisible(false);
		
		items_vbox.getChildren().clear();
		
		sort_products_by_profits();
		 
	}

	@FXML
	private void hover_Setting() {
		Setting_Rect.setFill(Paint.valueOf("#c1cfdc"));		
		}
	@FXML
	private void end_hover_Setting() {
		Setting_Rect.setFill(Paint.valueOf("#33373b"));	
	}
	
	@FXML
	private void hover_Refresh() {
		Refresh_Rect.setFill(Paint.valueOf("#c1cfdc"));		
		}
	@FXML
	private void end_hover_Refresh() {
		Refresh_Rect.setFill(Paint.valueOf("#33373b"));	
	}
	
	@FXML
	private void hover_Add() {
		add_rect.setFill(Paint.valueOf("#c1cfdc"));		
		}
	@FXML
	private void end_hover_Add() {
		add_rect.setFill(Paint.valueOf("#33373b"));	
	}
	//********************************************************//
	
	@FXML
	private void sort_products_by_Available() {
		System.out.println(" >>> Sorting by Date");
		
		Sort_by_Available_txt.setVisible(true);

		Sort_by_profits_txt.setVisible(false);
        Sort_by_price_txt.setVisible(false);
		Sort_by_sold_num_txt.setVisible(false);
		
		Sort_by_Available.setFill(Paint.valueOf("#8b939a"));
		
		Sort_by_price.setFill(Paint.valueOf("#FFFFFF"));
		Sort_by_profits.setFill(Paint.valueOf("#FFFFFF"));
		Sort_by_sold_num.setFill(Paint.valueOf("#FFFFFF"));
		
		task = new Get_Products_task("countity",true,black_pane,items_vbox);

		Platform.runLater(task);
		
		System.out.println("INFO __ thread started");
		
	}
	
	@FXML
	private void sort_products_by_price() {
		System.out.println(" >>> Sorting by Price");
		
		Sort_by_price_txt.setVisible(true);

		Sort_by_profits_txt.setVisible(false);
		Sort_by_Available_txt.setVisible(false);
		Sort_by_sold_num_txt.setVisible(false);
		
		Sort_by_price.setFill(Paint.valueOf("#8b939a"));
		
		Sort_by_Available.setFill(Paint.valueOf("#FFFFFF"));
		Sort_by_profits.setFill(Paint.valueOf("#FFFFFF"));
		Sort_by_sold_num.setFill(Paint.valueOf("#FFFFFF"));
		
		task = new Get_Products_task("price",true,black_pane,items_vbox);

		Platform.runLater(task);
		
	
	}
	
	@FXML
	private void sort_products_by_sold() {
		System.out.println(" >>> Sorting by Sold");
		
		Sort_by_sold_num_txt.setVisible(true);

		Sort_by_profits_txt.setVisible(false);
		Sort_by_Available_txt.setVisible(false);
		Sort_by_price_txt.setVisible(false);
		
		Sort_by_sold_num.setFill(Paint.valueOf("#8b939a"));
		
		Sort_by_Available.setFill(Paint.valueOf("#FFFFFF"));
		Sort_by_profits.setFill(Paint.valueOf("#FFFFFF"));
		Sort_by_price.setFill(Paint.valueOf("#FFFFFF"));
		
		task = new Get_Products_task("sold",true,black_pane,items_vbox);

		Platform.runLater(task);
		
	}
	
	@FXML
	private void sort_products_by_profits() {
		System.out.println(" >>> Sorting by Profits");
		
		Sort_by_profits_txt.setVisible(true);

		Sort_by_sold_num_txt.setVisible(false);
		Sort_by_Available_txt.setVisible(false);
		Sort_by_price_txt.setVisible(false);
		
		Sort_by_profits.setFill(Paint.valueOf("#8b939a"));
		
		Sort_by_Available.setFill(Paint.valueOf("#FFFFFF"));
		Sort_by_sold_num.setFill(Paint.valueOf("#FFFFFF"));
		Sort_by_price.setFill(Paint.valueOf("#FFFFFF"));
		
		task = new Get_Products_task("profits",true,black_pane,items_vbox);

		Platform.runLater(task);
	}
	
	/********************************************************/

	@FXML
	private void New_Product() { 
		
		add_rect.setFill(Paint.valueOf("#33373b"));	
		
		//New_Product_Stage
		if( !(main_win.New_Product_Stage == null)) {    main_win.New_Product_Stage.close();    }
		
		main_win.New_Product_Stage = new Stage(); 
		
		main_win.New_Product_Stage.setResizable(false);
		main_win.New_Product_Stage.setHeight(700);
		main_win.New_Product_Stage.setWidth(1100);
		
		FXMLLoader loader = new FXMLLoader(getClass().getResource("/front_end/fxml/New_Product_Window.fxml"));

		Stage stage = null;
		
		try {    stage = (Stage)(loader.load());    } catch (IOException e) {  Setting_Controller.Exception_Handler(e);  }
		
		main_win.New_Product_Stage = stage; 
		main_win.New_Product_Stage.setResizable(false);
		main_win.New_Product_Stage.initStyle(StageStyle.UNDECORATED);
		
		stage.getScene().getRoot().setOnMousePressed((EventHandler<? super MouseEvent>) new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent event) {
                xOffset = event.getSceneX();
                yOffset = event.getSceneY();
            }
        });
        stage.getScene().getRoot().setOnMouseDragged(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent event) {
            	main_win.New_Product_Stage.setX(event.getScreenX() - xOffset);
            	main_win.New_Product_Stage.setY(event.getScreenY() - yOffset);
            }
        });
        
		main_win.New_Product_Stage.show();
		
	}
	

}
