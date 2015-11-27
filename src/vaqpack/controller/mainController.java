package vaqpack.controller;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

import javafx.animation.FadeTransition;
import javafx.animation.TranslateTransition;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.Pane;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
import javafx.stage.StageStyle;
import javafx.util.Duration;


public class mainController implements Initializable
{
	//Huriel
	@FXML Button loginScreenButton;
	
	@FXML VBox buttonCard;
	
	
	
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
		FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("/vaqpack/view/Login.fxml"));		
		Parent root = (Pane) fxmlLoader.load();
		Scene scene = new Scene(root);
		Stage stage = new Stage();
		
		scene.getStylesheets().add(getClass().getResource("/material-fx-v0_3.css").toExternalForm());
		//stage.initModality(Modality.APPLICATION_MODAL);
		stage.setScene(scene);
		stage.setTitle("Login");
		stage.initStyle(StageStyle.TRANSPARENT);
		scene.setFill(null);
		stage.show();		
	}
	
	
	@Override
	public void initialize(URL location, ResourceBundle resources)
	{		
		animateIn();
	}
	
	private void animateIn()
	{
		TranslateTransition tt = new TranslateTransition(Duration.millis(500), buttonCard);
		FadeTransition ft1 = new FadeTransition(Duration.millis(1),	buttonCard);
		ft1.setFromValue(0);
		ft1.setToValue(1);
		ft1.play();
		tt.setFromX(400f);
		tt.setToX(0);
		tt.play();
	}

}
