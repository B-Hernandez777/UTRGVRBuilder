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
import javafx.scene.layout.FlowPane;
import javafx.util.Duration;


public class WizardBaseController implements Initializable
{	
	@FXML BorderPane navigationRoot;
	@FXML FlowPane navigationPane;
	@FXML AnchorPane wizardCenterPane;
	
	@FXML Button personalButton;
	@FXML Button objectiveButton;
	@FXML Button experienceButton;
	@FXML Button educationButton;
	@FXML Button achievementButton;
	@FXML Button skillButton;
	

	@FXML void navigationButtonClicked(ActionEvent event)
	{
		if(event.getSource().equals(personalButton))
			loadPersonal();
		else if(event.getSource().equals(objectiveButton))
			loadObjective();
		else if(event.getSource().equals(experienceButton))
			loadExperience();
		else if(event.getSource().equals(educationButton))
			loadEducation();
		else if(event.getSource().equals(achievementButton))
			loadAchievment();
		else if(event.getSource().equals(skillButton))
			loadSkill();
		}
	
	private void loadSkill()
	{
		try
		{
			   FXMLLoader loader = new FXMLLoader();
		        loader.setLocation(BackgroundController.class.getResource("/vaqpack/view/Skill.fxml"));
		        AnchorPane Login = (AnchorPane) loader.load();
					wizardCenterPane.getChildren().remove(0);
					wizardCenterPane.getChildren().add(Login);
				} catch (IOException e)
				{
					e.printStackTrace();
				}
		     	   
		
	}

	private void loadAchievment()
	{
		try
		{
			   FXMLLoader loader = new FXMLLoader();
		        loader.setLocation(BackgroundController.class.getResource("/vaqpack/view/Achievement.fxml"));
		        AnchorPane Login = (AnchorPane) loader.load();
					wizardCenterPane.getChildren().remove(0);
					wizardCenterPane.getChildren().add(Login);
				} catch (IOException e)
				{
					e.printStackTrace();
				}
		     	   
	}

	private void loadEducation()
	{
		try
		{
			   FXMLLoader loader = new FXMLLoader();
		        loader.setLocation(BackgroundController.class.getResource("/vaqpack/view/Education.fxml"));
		        AnchorPane Login = (AnchorPane) loader.load();
					wizardCenterPane.getChildren().remove(0);
					wizardCenterPane.getChildren().add(Login);
				} catch (IOException e)
				{
					e.printStackTrace();
				}
		     	   
		
	}

	private void loadExperience()
	{
		try
		{
			   FXMLLoader loader = new FXMLLoader();
		        loader.setLocation(BackgroundController.class.getResource("/vaqpack/view/Experience.fxml"));
		        AnchorPane Login = (AnchorPane) loader.load();
					wizardCenterPane.getChildren().remove(0);
					wizardCenterPane.getChildren().add(Login);
				} catch (IOException e)
				{
					e.printStackTrace();
				}
		     	   
		
	}

	private void loadObjective()
	{
		try
		{
		   FXMLLoader loader = new FXMLLoader();
	        loader.setLocation(BackgroundController.class.getResource("/vaqpack/view/Objective.fxml"));
	        AnchorPane Login = (AnchorPane) loader.load();
				wizardCenterPane.getChildren().remove(0);
				wizardCenterPane.getChildren().add(Login);
			} catch (IOException e)
			{
				e.printStackTrace();
			}
	     	   
	 
		
	}

	private void loadPersonal()
	{
		try
        {

        FXMLLoader loader = new FXMLLoader();
        loader.setLocation(BackgroundController.class.getResource("/vaqpack/view/Main.fxml"));
        AnchorPane Login = (AnchorPane) loader.load();
        wizardCenterPane.getChildren().remove(0);
        wizardCenterPane.getChildren().add(Login);
     	   
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
		         loader.setLocation(BackgroundController.class.getResource("/vaqpack/view/Main.fxml"));
		         AnchorPane Login = (AnchorPane) loader.load();
		         wizardCenterPane.getChildren().add(Login);	              
		      	   
		         } catch (IOException e1)
		         {
		      	   // TODO Auto-generated catch block
		      	   e1.printStackTrace();
		         }
		  });
	}
		

 
}
