package vaqpack.controller.resume;


import java.net.URL;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.ResourceBundle;

import javafx.animation.FadeTransition;
import javafx.animation.TranslateTransition;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.FlowPane;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.util.Duration;
import vaqpack.model.Singleton;
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
	@FXML ChoiceBox<String> stateBox;
	@FXML TextField zipCodeTextField;
	@FXML Label errorLabel;

	@FXML Button addButton;

	private Personal personal = Singleton.getInstance().currentVaqpack().getResume().getPersonal();
	
	
	private ArrayList<String> states =  new ArrayList<>(Arrays.asList("Alabama","Alaska","Arizona","Arkansas","California","Colorado","Connecticut","Delaware","Florida","Georgia","Hawaii","Idaho","Illinois","Indiana","Iowa","Kansas","Kentucky","Louisiana","Maine","Maryland","Massachusetts","Michigan","Minnesota","Mississippi","Missouri","Montana","Nebraska","Nevada","New Hampshire","New Jersey","New Mexico","New York","North Carolina","North Dakota","Ohio","Oklahoma","Oregon","Pennsylvania","Rhode Island","South Carolina","South Dakota","Tennessee","Texas","Utah","Vermont","Virginia","Washington","West Virginia","Wisconsin","Wyoming"));
	private ObservableList<String> state = FXCollections.observableArrayList();
	

	
	@FXML public void saveButtonClicked() 
	{
		boolean error = false;
		
		phoneNumberErrorLabel.setVisible(false);
		phoneNumberField.getStyleClass().remove("error");
		errorLabel.setVisible(false);
		zipCodeTextField.getStyleClass().remove("error");
		firstNameErrorLabel.setVisible(false);
		firstNameField.getStyleClass().remove("error");
		lastNameErrorLabel.setVisible(false);
		lastNameField.getStyleClass().remove("error");
		
		if(!phoneNumberField.getText().matches("\\(\\d{3}\\)\\d{3}-\\d{4}"))
			{
				error = true;
				phoneNumberErrorLabel.setVisible(true);
				phoneNumberErrorLabel.setText("(xxx)xxx-xxxx");
				phoneNumberField.getStyleClass().add("error");
			}
		try
		{
		  Double.parseDouble(zipCodeTextField.getText());
		}
		catch(NumberFormatException e)
		{
		  //not a double
			error = true;
			errorLabel.setText("Enter Proper zip code");
			errorLabel.setVisible(true);
			zipCodeTextField.getStyleClass().add("error");
		}
			
				
				
		
		if(!error)		
		personal = new Personal(

				  firstNameField.getText(),
				  lastNameField.getText(),
				  phoneNumberField.getText(),
				  personal.getEmail(),
				  addressField.getText(),
				  cityTextField.getText(),
				  stateBox.getSelectionModel().getSelectedItem().toString(),
				  zipCodeTextField.getText()
				
				);
		
		Singleton.getInstance().currentVaqpack().getResume().setPersonal(personal);
	}
	


	@Override
	public void initialize(URL arg0, ResourceBundle arg1)
	{
		state.setAll(states);
		stateBox.setItems(state);
		animateIn();
		validate();
		loadInformation();

	}

	private void loadInformation()
	{
		
			
		  firstNameField.setText(personal.getFirstName());
		  lastNameField.setText(personal.getLastName());
		  phoneNumberField.setText(personal.getPhoneNumber());
		  addressField.setText(personal.getAddress());
		  cityTextField.setText(personal.getCity());
		  stateBox.getSelectionModel().select(personal.getState());
		  zipCodeTextField.setText(personal.getZipCode());
		
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
			
			lastNameField.setOnKeyPressed(e->
			{
				lastNameLabel.setTextFill(Color.web("#4CAF50"));
				lastNameLabel.setVisible(true);
				lastNameErrorLabel.setVisible(false);
			});

			lastNameField.focusedProperty().addListener(e->
			{
				if(lastNameField.isFocused()== false)
				{
					if(lastNameField.getText().isEmpty())
					{
						lastNameLabel.setVisible(false);
						lastNameErrorLabel.setVisible(true);
						lastNameField.getStyleClass().add("error");
					}
					else
						lastNameLabel.setTextFill(Color.GRAY);
				}
				else
				if(lastNameField.getText().isEmpty())
					{
						lastNameLabel.setVisible(false);
						lastNameErrorLabel.setVisible(false);
						lastNameField.getStyleClass().remove("error");
					}
				else
					lastNameLabel.setTextFill(Color.web("#4CAF50"));
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
