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
import javafx.util.Duration;

public class CoverLetterBaseController implements Initializable{

	
	@FXML private BorderPane navigationRoot;
	@FXML private AnchorPane coverLetterCenterPane;
    @FXML private Button paragraphsButton;
    @FXML private Button stylesButton;
    @FXML private Button fieldsButton;

    @FXML
    void tabSelected(ActionEvent event) 
    {
    	if(event.getSource().equals(fieldsButton))
			loadFields();
		else if(event.getSource().equals(paragraphsButton))
			loadParagraphs();
		else if(event.getSource().equals(stylesButton))
			loadStyles();
    	
    }
    
    
    
	private void loadStyles()
	{
		try
        {

        FXMLLoader loader = new FXMLLoader();
        loader.setLocation(BackgroundController.class.getResource("/vaqpack/view/CoverLetterStyle.fxml"));
        AnchorPane Login = (AnchorPane) loader.load();
        coverLetterCenterPane.getChildren().remove(0);
        coverLetterCenterPane.getChildren().add(Login);	              
     	   
        } catch (IOException e1)
        {
     	   // TODO Auto-generated catch block
     	   e1.printStackTrace();
        }
	}



	private void loadParagraphs()
	{
		  try
	         {

	         FXMLLoader loader = new FXMLLoader();
	         loader.setLocation(BackgroundController.class.getResource("/vaqpack/view/CoverLetterParagraphs.fxml"));
	         AnchorPane Login = (AnchorPane) loader.load();
	         coverLetterCenterPane.getChildren().remove(0);
	         coverLetterCenterPane.getChildren().add(Login);	              
	      	   
	         } catch (IOException e1)
	         {
	      	   // TODO Auto-generated catch block
	      	   e1.printStackTrace();
	         }
		
	}



	private void loadFields()
	{
		  try
	         {

	         FXMLLoader loader = new FXMLLoader();
	         loader.setLocation(BackgroundController.class.getResource("/vaqpack/view/CoverLetterFields.fxml"));
	         AnchorPane Login = (AnchorPane) loader.load();
	         coverLetterCenterPane.getChildren().remove(0);
	         coverLetterCenterPane.getChildren().add(Login);	              
	      	   
	         } catch (IOException e1)
	         {
	      	   // TODO Auto-generated catch block
	      	   e1.printStackTrace();
	         }
		
	}



	@Override
	public void initialize(URL arg0, ResourceBundle arg1)
	{
		animateIn();
		
	}
	
	private void animateIn()
	{
		TranslateTransition tt = new TranslateTransition(Duration.millis(400), navigationRoot);
		  FadeTransition ft1 = new FadeTransition(Duration.millis(200), navigationRoot);	
		  
		  tt.setDelay(Duration.seconds(.1));
		  ft1.setDelay(Duration.seconds(.1));
		  ft1.setFromValue(0);
		  ft1.setToValue(1);			
		  ft1.play();
		  tt.setFromY(-225);
		  tt.setToY(0);						   
		  tt.play();
			
		ScaleTransition st = new ScaleTransition(Duration.millis(500), navigationRoot);
			st.setFromY(0);
			st.setToY(1);
			st.play();
			st.setOnFinished(e->
		  {
			   try
		         {

		         FXMLLoader loader = new FXMLLoader();
		         loader.setLocation(BackgroundController.class.getResource("/vaqpack/view/CoverLetterFields.fxml"));
		         AnchorPane Login = (AnchorPane) loader.load();
		         coverLetterCenterPane.getChildren().add(Login);	              
		      	   
		         } catch (IOException e1)
		         {
		      	   // TODO Auto-generated catch block
		      	   e1.printStackTrace();
		         }
		  });
	}

 
 }


