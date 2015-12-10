package vaqpack.controller.resume;


import java.net.URL;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.ResourceBundle;

import javafx.animation.FadeTransition;
import javafx.animation.TranslateTransition;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.FlowPane;
import javafx.scene.layout.VBox;
import javafx.util.Duration;
import vaqpack.controller.BackgroundController;
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
	@FXML Label message;

	@FXML Button addButton;

	private Personal personal = Singleton.getInstance().currentVaqpack().getResume().getPersonal();
	private ArrayList<String> states =  new ArrayList<>(Arrays.asList("Alabama","Alaska","Arizona","Arkansas","California","Colorado","Connecticut","Delaware","Florida","Georgia","Hawaii","Idaho","Illinois","Indiana","Iowa","Kansas","Kentucky","Louisiana","Maine","Maryland","Massachusetts","Michigan","Minnesota","Mississippi","Missouri","Montana","Nebraska","Nevada","New Hampshire","New Jersey","New Mexico","New York","North Carolina","North Dakota","Ohio","Oklahoma","Oregon","Pennsylvania","Rhode Island","South Carolina","South Dakota","Tennessee","Texas","Utah","Vermont","Virginia","Washington","West Virginia","Wisconsin","Wyoming"));
	private ObservableList<String> state = FXCollections.observableArrayList();
	

	
	@FXML public void saveButtonClicked(ActionEvent e) 
	{
		boolean error = false;
		error = validate(error);
				
		if(!error)		
		{
		personal = new Personal(

				  firstNameField.getText(),
				  lastNameField.getText(),
				  phoneNumberField.getText(),
				  personal.getEmail(),
				  addressField.getText(),
				  cityTextField.getText(),
				  stateBox.getSelectionModel().getSelectedItem(),
				  zipCodeTextField.getText()
				
				);
		Singleton.getInstance().currentVaqpack().getResume().setPersonal(personal);
		TranslateTransition tt = new TranslateTransition(Duration.millis(500), message);
		FadeTransition ft1 = new FadeTransition(Duration.millis(500), message);
		FadeTransition ft2 = new FadeTransition(Duration.millis(750), message);
		ft2.setDelay(Duration.millis(1000));
		ft1.setFromValue(1);
		ft1.setToValue(0);
		ft1.setFromValue(0);
		ft1.setToValue(1);
		ft1.play();
		ft2.play();
		tt.setFromY(400f);
		tt.setToY(0);
		tt.play();
		
		
		}
		
		
	}



	private boolean validate(boolean error)
	{
		phoneNumberErrorLabel.setVisible(false);
		phoneNumberField.getStyleClass().remove("error");
		errorLabel.setVisible(false);
		zipCodeTextField.getStyleClass().remove("error");
		firstNameErrorLabel.setVisible(false);
		firstNameField.getStyleClass().remove("error");
		lastNameErrorLabel.setVisible(false);
		lastNameField.getStyleClass().remove("error");
		stateBox.getStyleClass().remove("error");
		addressField.getStyleClass().remove("error");
		addressErrorLabel.setVisible(false);
		cityTextField.getStyleClass().remove("error");
		
		if(firstNameField.getText() == null)
		{
			error = true;
			firstNameErrorLabel.setVisible(true);
			firstNameField.getStyleClass().add("error");
		}
		if(lastNameField.getText() == null)
		{
			error = true;
			lastNameErrorLabel.setVisible(true);
			lastNameField.getStyleClass().add("error");
		}
		
		
		if(phoneNumberField.getText() != null)
		{
		if(!phoneNumberField.getText().matches("\\(\\d{3}\\)\\d{3}-\\d{4}"))
			{
				error = true;
				phoneNumberErrorLabel.setVisible(true);
				phoneNumberErrorLabel.setText("(xxx)xxx-xxxx");
				phoneNumberField.getStyleClass().add("error");
			}
		}
		else
		{
			error = true;
			phoneNumberErrorLabel.setVisible(true);
			phoneNumberErrorLabel.setText("(xxx)xxx-xxxx");
			phoneNumberField.getStyleClass().add("error");
		}

		  if(zipCodeTextField.getText() != null)
		  {
			  if(!zipCodeTextField.getText().matches("\\d{5}"))
			{
			error = true;
			errorLabel.setText("Enter valid zip code. ");
			errorLabel.setVisible(true);
			zipCodeTextField.getStyleClass().add("error");
			}
		  }
			  else
			  {
				error = true;
				errorLabel.setText("Enter valid zip code. ");
				errorLabel.setVisible(true);
				zipCodeTextField.getStyleClass().add("error");
			  }
				  
			 if(cityTextField.getText() == null)
				{
				errorLabel.setText(errorLabel.getText() + "Enter a city ");
				errorLabel.setVisible(true);
				cityTextField.getStyleClass().add("error");
				}
	
			 if(addressField.getText() == null)
				{
				addressErrorLabel.setText("Enter an Address ");
				addressErrorLabel.setVisible(true);
				addressField.getStyleClass().add("error");
				}
			 
		if(stateBox.getSelectionModel().getSelectedItem() == null)
		{
			error=true;
			errorLabel.setText(errorLabel.getText() + "Select a state ");
			errorLabel.setVisible(true);
			stateBox.getStyleClass().add("error");
		
		}
		return error;
	}
	


	@Override
	public void initialize(URL arg0, ResourceBundle arg1)
	{
		state.setAll(states);
		stateBox.setItems(state);
		animateIn();
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
