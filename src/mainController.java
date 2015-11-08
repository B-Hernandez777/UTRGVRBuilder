import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;
import javafx.stage.StageStyle;


public class mainController implements Initializable
{
	//Huriel
	@FXML Button loginScreenButton;
	
	
	
	@FXML
	private void mainButtonBarClicked(ActionEvent event) throws IOException
	{
		if(event.getSource().equals(loginScreenButton))	
		{
			loadLoginScreen();
			((Node)(event.getSource())).getScene().getWindow().hide();
		}
//		else if()
//		{
//			
//		}
	
	}


	private void loadLoginScreen() throws IOException
	{
		FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("Login.fxml"));		
		Parent root = (Pane) fxmlLoader.load();
		Scene scene = new Scene(root);
		Stage stage = new Stage();
		
		scene.getStylesheets().add(getClass().getResource("material-fx-v0_3.css").toExternalForm());
		//stage.initModality(Modality.APPLICATION_MODAL);
		stage.setScene(scene);
		stage.setTitle("Login");
		stage.initStyle(StageStyle.TRANSPARENT);
		stage.show();		
	}
	
	
	@Override
	public void initialize(URL location, ResourceBundle resources)
	{		
	}

}
