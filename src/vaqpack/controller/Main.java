package vaqpack.controller;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.stage.Stage;
import javafx.stage.StageStyle;


public class Main extends Application
{
	
	@Override
	public void start(Stage primaryStage) throws Exception
	{
			Parent root = FXMLLoader.load(getClass().getResource("/vaqpack/view/Login.fxml"));			
	        Scene scene = new Scene(root);
	        scene.getStylesheets().add(getClass().getResource("/material-fx-v0_3.css").toExternalForm());
	       
	        primaryStage.getIcons().add(new Image("/vaqpack/images/icon.png"));
	        primaryStage.setScene(scene);
	        primaryStage.setTitle("Login");
	        primaryStage.initStyle(StageStyle.TRANSPARENT);
	        scene.setFill(null);
	        primaryStage.show();
	}
	
	public static void main(String[] args)
	{
		launch(args);
	}
}


