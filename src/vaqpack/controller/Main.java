package vaqpack.controller;
import vaqpack.model.Resume;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import javafx.stage.StageStyle;


public class Main extends Application
{
	static Resume resume;
	
	
	@Override
	public void start(Stage primaryStage) throws Exception
	{
			Parent root = FXMLLoader.load(getClass().getResource("/vaqpack/view/Main.fxml"));			
	        Scene scene = new Scene(root);
	        scene.getStylesheets().add(getClass().getResource("/material-fx-v0_3.css").toExternalForm());
	        primaryStage.setTitle("Mainr");
	        primaryStage.setScene(scene);
	    	primaryStage.initStyle(StageStyle.TRANSPARENT);
	        primaryStage.show();
	}
	
	public static void main(String[] args)
	{
		launch(args);
	}
}


