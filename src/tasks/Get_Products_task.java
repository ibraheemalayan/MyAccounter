package tasks;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

import back_end.Setting_Controller;
import javafx.event.Event;
import javafx.event.EventHandler;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Pane;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Paint;
import javafx.scene.shape.Line;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.scene.text.Text;
import javafx.scene.text.TextAlignment;

import objects.Product;

public class Get_Products_task implements Runnable{

	@SuppressWarnings("unused")
	private VBox black_pane;

	//saves the pane of the Item selected by the user (the yellow one)
	private HBox selected_pane;
	
	//saves the currently selected product by the user
	@SuppressWarnings("unused")
	private Product selected_product ;

	//saves true if there is a product selected b the user and fasle if not 
	private boolean is_selected = false;
	
	//the product saves the obtained products by order and the panes save their panes by the same order
	private ArrayList<Product> products;
	private ArrayList<HBox> panes;
	
	//the vbox that contains everything in the scroll pane
	private VBox vbox;

	//sort by coulmn name in this string
	private String column_name;
	
	//sort false : asc or true : desc
	private boolean sort_kind;

	//Constructer
	public Get_Products_task(String column_name ,boolean sort_kind, VBox all , VBox vbox) {
		
        products = new ArrayList<Product>();
        
        panes = new ArrayList<HBox>();

		System.out.println("INFO __ task constructed");
		
		black_pane = all;
		this.column_name = column_name;
		this.sort_kind = sort_kind;
		this.vbox = vbox;

	
	}

	@Override
	public void run() {
		
		System.out.println("INFO__ running the task");
		
		vbox.getChildren().clear();
		
		products.clear();
		
		panes.clear();
		
		get_Products();
		
	}
	
    
	private void get_Products(){
		
		
		
		products = new ArrayList<Product>();
		
		PreparedStatement pr = null;
		try{
			
			System.out.println("");
			
			pr = Setting_Controller.con.prepareStatement("SELECT * FROM myaccounter.products order by ? ?;");
			pr.setString(1, column_name);
			pr.setString(2, (sort_kind)?"desc":"asc");
			
			ResultSet r = pr.executeQuery();
			
			//retrieving products from the result set
			while(r.next()) {
				
				products.add(  new Product( r.getInt(1) , r.getString(2) , r.getDouble(3) , r.getDouble(6) , r.getDouble(7) , r.getDouble(4))  );
				
			}
			
		}catch(Exception e){Setting_Controller.Exception_Handler(e);}
		
		panes = new ArrayList<>();
		
		for(Product p : products) {

			HBox temp = get_temp_HBox(p);

			temp.setId(p.getId()+"");

			Line H_line = new Line();
			
			H_line.setStartX(-100);
			H_line.setEndX(450);
			
			H_line.setStartY(0);
			H_line.setEndY(0);
			
			H_line.setStroke(Paint.valueOf("#c1cfdc"));
			H_line.setStrokeWidth(1);
			
			temp.setOnMouseEntered(item_mouse_enter);
			
			panes.add(temp);
			vbox.getChildren().add(temp);
			vbox.getChildren().add(H_line);
			
	    }
		
	}
	
	
	private HBox get_temp_HBox(Product p) {
		
		HBox temp = new HBox();
		
		temp.setStyle("-fx-background-color : #FFFFFF");
		
		/********************************/
        Text name_txt = new Text();
		
		name_txt.setLayoutX(7);
		name_txt.setLayoutY(18);
		name_txt.setFont(Font.font("Calibri",FontWeight.BOLD, 18));
		name_txt.setFill(Paint.valueOf("#43484d"));
		name_txt.setOpacity(0.5);
		name_txt.setWrappingWidth(215);
		name_txt.setTextAlignment(TextAlignment.CENTER);
		name_txt.setText(p.getName());

		
		Text price_txt = new Text();
		
		price_txt.setLayoutX(16);
		price_txt.setLayoutY(18);
		price_txt.setFont(Font.font("Calibri",FontWeight.BOLD, 18));
		price_txt.setFill(Paint.valueOf("#43484d"));
		price_txt.setOpacity(0.5);
		price_txt.setWrappingWidth(80);
		price_txt.setTextAlignment(TextAlignment.CENTER);
		price_txt.setText(p.getPrice()+"");

		
		Text available_txt = new Text();
		
		available_txt.setLayoutX(0);
		available_txt.setLayoutY(18);
		available_txt.setFont(Font.font("Calibri",FontWeight.BOLD, 18));
		available_txt.setFill(Paint.valueOf("#43484d"));
		available_txt.setOpacity(0.5);
		available_txt.setWrappingWidth(80);
		available_txt.setTextAlignment(TextAlignment.CENTER);
		available_txt.setText(p.getCountity()+"");

		
		Text profits_txt = new Text();
		
		profits_txt.setLayoutX(10);
		profits_txt.setLayoutY(18);
		profits_txt.setTextAlignment(TextAlignment.CENTER);
		profits_txt.setFont(Font.font("Calibri",FontWeight.BOLD, 18));
		profits_txt.setFill(Paint.valueOf("#43484d"));
		profits_txt.setOpacity(0.5);
		profits_txt.setWrappingWidth(80);
		profits_txt.setText(p.getProfits()+"");

		
		Text sold_txt = new Text();
		
		sold_txt.setLayoutX(0);
		sold_txt.setLayoutY(18);
		sold_txt.setFont(Font.font("Calibri",FontWeight.BOLD, 18));
		sold_txt.setFill(Paint.valueOf("#43484d"));
		sold_txt.setOpacity(0.5);
		sold_txt.setTextAlignment(TextAlignment.CENTER);
		sold_txt.setWrappingWidth(75);
		sold_txt.setText(p.getSold()+"");

		
		/********************************/
		
		Pane name_pane = new Pane();
		
		name_pane.setPrefSize(219, 25);
		name_pane.setMaxSize(219, 25);
		name_pane.setMinSize(219, 25);
		name_pane.getChildren().add(name_txt);
		
		Pane price_pane = new Pane();
		
		price_pane.setPrefSize(80.5, 25);
		price_pane.setMaxSize(80.5, 25);
		price_pane.setMinSize(80.5, 25);
		price_pane.getChildren().add(price_txt);
		
		
		Pane available_pane = new Pane();
		
		available_pane.setPrefSize(80.5, 25);
		available_pane.setMaxSize(80.5, 25);
		available_pane.setMinSize(80.5, 25);
		available_pane.getChildren().add(available_txt);
		
		
		Pane profits_pane = new Pane();
		
		profits_pane.setPrefSize(80.5, 25);
		profits_pane.setMaxSize(80.5, 25);
		profits_pane.setMinSize(80.5, 25);
		profits_pane.getChildren().add(profits_txt);
		
        Pane sold_pane = new Pane();
		
        sold_pane.setPrefSize(77, 25);
        sold_pane.setMaxSize(77, 25);
        sold_pane.setMinSize(77, 25);
        sold_pane.getChildren().add(sold_txt);
		
		/***********************************/
		
		Line line_1 = new Line();
		
		line_1.setStartX(100);
		line_1.setStartY(0);
		
		line_1.setEndX(100);
		line_1.setEndY(23);
		
		line_1.setStroke(Paint.valueOf("#6b6b6b"));
		line_1.setStrokeWidth(2);
		
		Line line_3 = new Line();
		
		line_3.setStartX(100);
		line_3.setStartY(0);
		
		line_3.setEndX(100);
		line_3.setEndY(23);
		
		line_3.setStroke(Paint.valueOf("#6b6b6b"));
		line_3.setStrokeWidth(2);
		
		
		Line line_2 = new Line();
		
		line_2.setStartX(100);
		line_2.setStartY(0);
		
		line_2.setEndX(100);
		line_2.setEndY(23);
		
		line_2.setStroke(Paint.valueOf("#6b6b6b"));
		line_2.setStrokeWidth(2);
		
		
		Line line_4 = new Line();
		
		line_4.setStartX(100);
		line_4.setStartY(0);
		
		line_4.setEndX(100);
		line_4.setEndY(23);
		
		line_4.setStroke(Paint.valueOf("#6b6b6b"));
		line_4.setStrokeWidth(2);
		
		
		
		/**********************************/
		
		temp.getChildren().add(name_pane);
		temp.getChildren().add(line_1);
		temp.getChildren().add(price_pane);
		temp.getChildren().add(line_2);
		temp.getChildren().add(available_pane);
		temp.getChildren().add(line_3);
		temp.getChildren().add(profits_pane);
		temp.getChildren().add(line_4);
		temp.getChildren().add(sold_pane);
		
		temp.setOnMouseClicked(item_mouse_click);
		temp.setOnMouseEntered(item_mouse_enter);
		temp.setOnMouseExited(item_mouse_exit);
		
		return temp;
		
		
	}
	

	private EventHandler<Event> item_mouse_enter = new EventHandler<Event>() {

		@Override
		public void handle(Event event) {
			
			for(HBox h : panes) {
				h.setStyle("-fx-background-color : #FFFFFF");
			}
			
			if( is_selected ) { selected_pane.setStyle("-fx-background-color : #F9E79F"); }
			
			HBox caller = (HBox) event.getSource();
	
			caller.setStyle("-fx-background-color : #E4E4E4");
			/*TODO complete another handlers and make this one not yellow but the yellow for the selected one
			 * and make this one makes the hbox a bit darker and make on click and on mouse exited handlers*/
			
		}
	};
	
	private EventHandler<Event> item_mouse_exit = new EventHandler<Event>() {

		@Override
		public void handle(Event event) {
			
			HBox caller = (HBox) event.getSource();
	
			caller.setStyle("-fx-background-color : #FFFFFF");
			
			if( is_selected ) { selected_pane.setStyle("-fx-background-color : #F9E79F"); }
			
		
		}
	};
	
	private EventHandler<Event> item_mouse_click = new EventHandler<Event>() {

		@Override
		public void handle(Event event) {
			
			is_selected = true;
			
			for(HBox h : panes) {
				h.setStyle("-fx-background-color : #FFFFFF");
			}
			
			selected_pane = (HBox) event.getSource();
		    
			selected_pane.setStyle("-fx-background-color : #F9E79F");
			
			int id = Integer.parseInt(selected_pane.getId());
			
			for(Product p : products) {
				if(p.getId() == id) {
					selected_product = p;
				}
			}
			 
		}
	};
	

}
