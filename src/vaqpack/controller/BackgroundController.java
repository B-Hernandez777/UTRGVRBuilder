package vaqpack.controller;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

import javafx.animation.FadeTransition;
import javafx.animation.ScaleTransition;
import javafx.animation.TranslateTransition;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.Pane;
import javafx.scene.layout.VBox;
import javafx.scene.text.Text;
import javafx.util.Duration;



public class BackgroundController implements Initializable 
{	
	
	@FXML private BorderPane root;
    @FXML private Pane menuBar;
    @FXML private VBox toolBar;
    @FXML private AnchorPane centerPane;
    @FXML private VBox menuItems;
    @FXML private Text title;
    
    @FXML Button resumeButton;
    @FXML Button coverLetterButton;
    @FXML Button businessCardsButton;
    @FXML Button websiteButton;
    @FXML Button exportButton;
    
	@FXML public void mainMenuButtonClicked(ActionEvent event)
	{
		if(event.getSource().equals(resumeButton))
			loadResume();
		//else if(event.getSource().equals(objectiveButton))

		}
	
	private void loadResume()
	{
		try
		{
			   FXMLLoader loader = new FXMLLoader();
		        loader.setLocation(BackgroundController.class.getResource("/vaqpack/view/resume/WizardBase.fxml"));
		        AnchorPane pane = (AnchorPane) loader.load();
					centerPane.getChildren().remove(0);
					centerPane.getChildren().add(pane);
				} catch (IOException e)
				{
					e.printStackTrace();
				}
		     	   
	}

	@Override
	public void initialize(URL arg0, ResourceBundle arg1)
	{	
		
		FadeTransition ft3 = new FadeTransition(Duration.millis(100), toolBar);
		ft3.setFromValue(0);
		ft3.setToValue(1);
		ft3.play();
		ScaleTransition st2 = new ScaleTransition(Duration.millis(500), toolBar);
		st2.setFromX(.50);
		st2.setToX(1);
		st2.play();
		st2.setOnFinished(event->
		{
		title.setOpacity(1);
		ScaleTransition st1 = new ScaleTransition(Duration.millis(500), menuBar);
		st1.setFromY(0);
		st1.setToY(1);
		st1.play();
	
			FadeTransition ft = new FadeTransition(Duration.millis(100),menuBar);
			TranslateTransition tt1 = new TranslateTransition(Duration.millis(245), menuBar);
			ft.setDelay(Duration.seconds(.25));
			tt1.setDelay(Duration.seconds(.25));
			tt1.setFromY(-136f);
			tt1.setToY(0);
			tt1.play();
			ft.setFromValue(0.0);
			ft.setToValue(1);
			ft.play();
		   tt1.setOnFinished(e->
		     {
				menuItems.setOpacity(1);
				ScaleTransition st = new ScaleTransition(Duration.millis(500),centerPane);
				st.setFromX(0);
				st.setToX(1);
				st.play();

				TranslateTransition tt = new TranslateTransition(Duration.millis(500), centerPane);
				FadeTransition ft1 = new FadeTransition(Duration.millis(1),centerPane);
				ft1.setFromValue(0);
				ft1.setToValue(1);
				ft1.play();
				tt.setFromX(-348);
				tt.setToX(0);
				tt.play();
	    	  tt.setOnFinished(ev->
	    	  {
	    		   try
	               {

	               FXMLLoader loader = new FXMLLoader();
	               loader.setLocation(BackgroundController.class.getResource("/vaqpack/view/resume/WizardBase.fxml"));
	               AnchorPane Login = (AnchorPane) loader.load();
	               centerPane.getChildren().add(Login);	              
	            	   
	               } catch (IOException e1)
	               {
	            	   e1.printStackTrace();
	               }
	    	  });
		     });
		   
		   
		});
			
		

		
	}



	
    
    

}
