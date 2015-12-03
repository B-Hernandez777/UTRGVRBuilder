package vaqpack.controller.resume;

import java.net.URL;
import java.util.ResourceBundle;

import javafx.animation.FadeTransition;
import javafx.animation.TranslateTransition;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.FlowPane;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.util.Duration;
import jdk.nashorn.internal.runtime.Context;
import vaqpack.model.resume.Personal;

public class PersonalController implements Initializable

{
//	
	@FXML FlowPane personalBackground;
	@FXML VBox personalCard;
	@FXML Label firstNameLabel;
	@FXML TextField firstNameField;
	@FXML Label firstNameErrorLabel;
	@FXML Label lastNameLabel;
	@FXML TextField lastNameField;
	@FXML Label lastNameErrorLabel;
	@FXML Label phoneNumberLabel;
	@FXML TextField phoneNumberField;
	@FXML Label phoneNumberErrorLabel;
	@FXML Label addressLabel;
	@FXML TextField addressField;
	@FXML Label addressErrorLabel;
	@FXML TextField cityTextField;
	@FXML TextField stateTextField;
	@FXML TextField zipCodeTextField;

	@FXML Button addButton;

	private Personal personal;

	

	
	@FXML public void saveButtonClicked() 
	{
		
		
		
		this.personal = new Personal(

				  firstNameField.getText(),
				  lastNameField.getText(),
				  phoneNumberField.getText(),
				  addressField.getText(),
				  cityTextField.getText(),
				  stateTextField.getText(),
				  zipCodeTextField.getText()
				
				);
		
		

	}
	


	@Override
	public void initialize(URL arg0, ResourceBundle arg1)
	{
		animateIn();

	}

	private void validate()
	{
		firstNameField.setOnKeyPressed(e->
			{
				firstNameLabel.setTextFill(Color.web("#4CAF50"));
				firstNameLabel.setVisible(true);
				firstNameErrorLabel.setVisible(false);
			});
			firstNameField.focusedProperty().addListener(e->
			{
				if(firstNameField.isFocused()== false)
				{
					if(firstNameField.getText().isEmpty())
					{
						firstNameLabel.setVisible(false);
						firstNameErrorLabel.setVisible(true);
						firstNameField.getStyleClass().add("error");
					}
					else
						firstNameLabel.setTextFill(Color.GRAY);
				}
				else
				if(firstNameField.getText().isEmpty())
					{
						firstNameLabel.setVisible(false);
						firstNameErrorLabel.setVisible(false);
						firstNameField.getStyleClass().remove("error");
					}
				else
					firstNameLabel.setTextFill(Color.web("#4CAF50"));
				
			});
	}
	


	
	private void animateIn()
	{
		TranslateTransition tt = new TranslateTransition(Duration.millis(500), personalCard);
		FadeTransition ft1 = new FadeTransition(Duration.millis(1),	personalCard);
		ft1.setFromValue(0);
		ft1.setToValue(1);
		ft1.play();
		tt.setFromX(400f);
		tt.setToX(0);
		tt.play();
	}

	



}
