package vaqpack.controller.resume;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

import vaqpack.controller.BackgroundController;
import javafx.animation.FadeTransition;
import javafx.animation.ScaleTransition;
import javafx.animation.TranslateTransition;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
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
	@FXML Label personalButtonLabel;
	@FXML Button objectiveButton;
	@FXML Label objectiveButtonLabel;
	@FXML Button experienceButton;
	@FXML Label experienceButtonLabel;
	@FXML Button educationButton;
	@FXML Label educationButtonLabel;
	@FXML Button achievementButton;
	@FXML Label achievementButtonLabel;
	@FXML Button skillButton;
	@FXML Label skillButtonLabel;
	@FXML Button styleButton;
	@FXML Label styleButtonLabel;
	

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
		else if(event.getSource().equals(styleButton))
			loadStyle();
		}
	
	private void loadStyle()
	{
		removeStyle();
		styleButtonLabel.getStyleClass().add("stepper-label-selected");
		styleButton.getStyleClass().add("stepper-button-selected");
		try
		{
			   FXMLLoader loader = new FXMLLoader();
		        loader.setLocation(BackgroundController.class.getResource("/vaqpack/view/resume/Personal.fxml"));
		        AnchorPane Login = (AnchorPane) loader.load();
					wizardCenterPane.getChildren().remove(0);
					wizardCenterPane.getChildren().add(Login);
				} catch (IOException e)
				{
					e.printStackTrace();
				}
		     	   
	}

	private void loadSkill()
	{
		removeStyle();
		skillButtonLabel.getStyleClass().add("stepper-label-selected");
		skillButton.getStyleClass().add("stepper-button-selected");
		try
		{
			   FXMLLoader loader = new FXMLLoader();
		        loader.setLocation(BackgroundController.class.getResource("/vaqpack/view/resume/Skill.fxml"));
		        AnchorPane Login = (AnchorPane) loader.load();
					wizardCenterPane.getChildren().remove(0);
					wizardCenterPane.getChildren().add(Login);
				} catch (IOException e)
				{
					e.printStackTrace();
				}
		     	   
		
	}

	private void removeStyle()
	{
		 personalButton.getStyleClass().removeAll();
		 personalButtonLabel.getStyleClass().removeAll();
		 objectiveButton.getStyleClass().removeAll();
		 objectiveButtonLabel.getStyleClass().removeAll();
		 experienceButton.getStyleClass().removeAll();
		 experienceButtonLabel.getStyleClass().removeAll();
		 educationButton.getStyleClass().removeAll();
		 educationButtonLabel.getStyleClass().removeAll();
		 achievementButton.getStyleClass().removeAll();
		 achievementButtonLabel.getStyleClass().removeAll();
		 skillButton.getStyleClass().removeAll();
		 skillButtonLabel.getStyleClass().removeAll();
		 
		 personalButton.getStyleClass().add("stepper-button");
		 personalButtonLabel.getStyleClass().add("stepper-label");
		 objectiveButton.getStyleClass().add("stepper-button");
		 objectiveButtonLabel.getStyleClass().add("stepper-label");
		 experienceButton.getStyleClass().add("stepper-button");
		 experienceButtonLabel.getStyleClass().add("stepper-label");
		 educationButton.getStyleClass().add("stepper-button");
		 educationButtonLabel.getStyleClass().add("stepper-label");
		 achievementButton.getStyleClass().add("stepper-button");
		 achievementButtonLabel.getStyleClass().add("stepper-label");
		 skillButton.getStyleClass().add("stepper-button");
		 skillButtonLabel.getStyleClass().add("stepper-label");

	}

	private void loadAchievment()
	{
		removeStyle();
		achievementButtonLabel.getStyleClass().add("stepper-label-selected");
		achievementButton.getStyleClass().add("stepper-button-selected");
		try
		{
			   FXMLLoader loader = new FXMLLoader();
		        loader.setLocation(BackgroundController.class.getResource("/vaqpack/view/resume/Achievement.fxml"));
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
		removeStyle();
		educationButtonLabel.getStyleClass().add("stepper-label-selected");
		educationButton.getStyleClass().add("stepper-button-selected");
		try
		{
			   FXMLLoader loader = new FXMLLoader();
		        loader.setLocation(BackgroundController.class.getResource("/vaqpack/view/resume/Education.fxml"));
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
		removeStyle();
		experienceButtonLabel.getStyleClass().add("stepper-label-selected");
		experienceButton.getStyleClass().add("stepper-button-selected");
		try
		{
			   FXMLLoader loader = new FXMLLoader();
		        loader.setLocation(BackgroundController.class.getResource("/vaqpack/view/resume/Experience.fxml"));
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
		removeStyle();
		objectiveButtonLabel.getStyleClass().add("stepper-label-selected");
		objectiveButton.getStyleClass().add("stepper-button-selected");
		
		
		try
		{
		   FXMLLoader loader = new FXMLLoader();
	        loader.setLocation(BackgroundController.class.getResource("/vaqpack/view/CoverLetterParagraphs.fxml"));
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
		removeStyle();
		personalButtonLabel.getStyleClass().add("stepper-label-selected");
		personalButton.getStyleClass().add("stepper-button-selected");
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
