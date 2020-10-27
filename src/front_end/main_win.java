package front_end;

import javafx.fxml.FXMLLoader;
import java.io.IOException;
import back_end.Setting_Controller;
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.effect.Lighting;
import javafx.scene.layout.Pane;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class main_win extends Application{
	
	public static Setting_Controller sc;

	public static void main(String[] args)  {System.out.println(">>>> Running <<<<");Application.launch(args); }
	
	public static Stage stage;
	
	public static Stage New_Product_Stage;
	
	public static Lighting Stage_blur;
	
	@Override 
	public void start(Stage stage) throws IOException
	{

		main_win.stage = stage;
		
		sc = new Setting_Controller();
		
		if(!sc.need_setup) {
		
		FXMLLoader loader = new FXMLLoader(getClass().getResource("/front_end/fxml/main_window.fxml"));


		VBox root = (VBox) loader.load();

		Scene scene = new Scene(root);

		stage.setScene(scene);
		stage.setTitle("MyAccounter");
		stage.setResizable(false);

		stage.show();
		} else {
			FXMLLoader loader = new FXMLLoader(getClass().getResource("/front_end/fxml/Setup_screen_1.fxml"));


			Pane root = (Pane) loader.load();

			Scene scene = new Scene(root);

			stage.setScene(scene);
			stage.setTitle("MyAccounter Setup");
			stage.setResizable(false);

			stage.show();
		}
		
		//TODO make a class for shared static variables ***important***
		
		Stage_blur = new Lighting();
		
		Stage_blur.setDiffuseConstant(2.0);
		Stage_blur.setSpecularConstant(2.0);
		Stage_blur.setSpecularExponent(15.0);
		Stage_blur.setSurfaceScale(10.0);

		

	}


}
