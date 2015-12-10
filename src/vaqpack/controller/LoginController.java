package vaqpack.controller;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.net.URL;
import java.util.ResourceBundle;

import javafx.animation.FadeTransition;
import javafx.animation.TranslateTransition;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Pane;
import javafx.scene.layout.Region;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.text.Text;
import javafx.util.Duration;
import vaqpack.model.Singleton;
import vaqpack.model.Vaqpack;



public class LoginController implements Initializable
{
        @FXML Button closePopup;
        @FXML Pane Popup;
        @FXML Label ErrorMessage;
        
	@FXML Button loginButton;
	@FXML Button registerButton;
	@FXML HBox buttonPane;
	@FXML Text title;
	@FXML VBox loginCardBackground;
	@FXML TextField emailTextField;
	@FXML Label emailLabel;
	@FXML Label emailErrorLabel;
	@FXML Label retypePasswordLabel;
	@FXML Label retypePasswordErrorLabel;
	@FXML PasswordField retypePasswordField;
	@FXML VBox retypeGroup;
	@FXML Label passwordLabel;
	@FXML Label passwordErrorLabel;
	@FXML PasswordField passwordField;
	@FXML Region contentRegion;
	@FXML ImageView coverImage;
	@FXML AnchorPane loginCard;
	@FXML AnchorPane root;
	
	
	
	@FXML private void loginButtonClicked(ActionEvent event) throws IOException, ClassNotFoundException
	{
		if(event.getSource().equals(registerButton))
			setRegisterCard();
		else
		{		
		System.out.println(emailTextField.getText());
		
		//Validate email text field is not empty
		if(!emailTextField.getText().matches("^[A-Za-z0-9+_.-]+@(.+)$")  || passwordField.getText().isEmpty() )
		{
                    Popup.setVisible(true);
                    closePopup.setVisible(true);
                    ErrorMessage.setVisible(true);
                    
                    ErrorMessage.setText("Not a valid email address/password");
                    System.out.println("Enter email in the correct format");
		}
		else
		// Method call to database to check and load if email exists
		if(!new vaqpack.Tests.SQL().userExists(emailTextField.getText())){//Returns true if email exists. Notice the "!"
			//do stuff here if the user does not already exist.
		}
		
		
		{
			try (ObjectInputStream input = new ObjectInputStream(new FileInputStream("1.dat"));)
			{
				Vaqpack vaqpack = (Vaqpack)input.readObject();
				Singleton.getInstance().currentVaqpack().setResume(vaqpack.getResume());
				Singleton.getInstance().currentVaqpack().setCoverLetter(vaqpack.getCoverLetter());
			
				//load the scene
				animateOut();	
			}}
		// Create method that displays method does not exist
		}
		
	}

        @FXML public void closePopupClicked ()
        {
                    Popup.setVisible(false);
                    closePopup.setVisible(false);
                    ErrorMessage.setVisible(false);
        }

	private void setRegisterCard()
	{
		loginCardBackground.setStyle("-fx-background-color: #212121;");
		contentRegion.setPrefHeight(580.0);
		title.setText("REGISTER");
		title.setFill(Color.web("#FFF"));
		loginCardBackground.getChildren().remove(buttonPane);
		loginCardBackground.getChildren().add(retypeGroup);
		loginCardBackground.getChildren().add(buttonPane);
		loginButton.setDefaultButton(false);
		registerButton.setDefaultButton(true);
		loginButton.setOnAction(e->
		{
			//set login 
			setLoginCard();
		});
		registerButton.setOnAction(e->
		{
			new vaqpack.Tests.SQL().registerUser(emailTextField.getText(), passwordField.getText(), vaqPack); //needs an empty vaqpack object.
			//method to database to register user
			//need to validate that users password works
			// need to display if registered successful
			
		});
	}

	private void setLoginCard()
	{
		loginCardBackground.setStyle("-fx-background-color: #FFF;");
		contentRegion.setPrefHeight(520.0);
		title.setText("LOGIN");
		title.setFill(Color.web("#000"));
		loginCardBackground.getChildren().remove(retypeGroup);
		retypeGroup.setVisible(true);
		loginButton.setDefaultButton(true);
		registerButton.setDefaultButton(false);
		passwordField.setText("");
		loginButton.setOnAction(e->{
			try
			{
				loginButtonClicked(e);
			} catch (Exception e1)
			{
				e1.printStackTrace();
			}
		});
		registerButton.setOnAction(e->
		{
			try
			{
				loginButtonClicked(e);
			} catch (Exception e1)
			{
				e1.printStackTrace();
			}
		});
	}
	private void animateOut()
	{
		TranslateTransition tt = new TranslateTransition(Duration.millis(500), loginCard);
		tt.setToX(-600f);
		tt.play();			

		tt.setOnFinished(e->
		{
			TranslateTransition t1 = new TranslateTransition(Duration.millis(500), root);
			t1.setToY(-200f);
			
			t1.play();	
			FadeTransition ft1 = new FadeTransition(Duration.millis(100), contentRegion);
		    	  ft1.setFromValue(1);
		    	  ft1.setToValue(0);			
		      ft1.play();
			t1.setOnFinished(e1->
			{
				try
				{
					openMainScene();
				} catch (Exception e2)
				{
					e2.printStackTrace();
				}
			});

		});
	}
	private void openMainScene() throws IOException
	{
		FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("/vaqpack/view/Background.fxml"));
		Parent root1 = (Pane) fxmlLoader.load();
		root.getScene().setRoot(root1);
	}
	
	@Override
	public void initialize(URL location, ResourceBundle resources)
	{
		  setLoginCard();
		
		  validateFields();
		
		  animateIn();
		  
	}

	private void validateFields()
	{
		emailTextField.setOnKeyPressed(e->
		{
			emailLabel.setTextFill(Color.web("#4CAF50"));
			emailLabel.setVisible(true);
			emailErrorLabel.setVisible(false);
		});
		emailTextField.focusedProperty().addListener(e->
		{
			if(emailTextField.isFocused()== false)
			{
				if(emailTextField.getText().isEmpty())
				{
					emailLabel.setVisible(false);
					emailErrorLabel.setVisible(true);
					emailTextField.getStyleClass().add("error");
				}
				else
					emailLabel.setTextFill(Color.GRAY);
			}
			else
			if(emailTextField.getText().isEmpty())
				{
					emailLabel.setVisible(false);
					emailErrorLabel.setVisible(false);
					emailTextField.getStyleClass().remove("error");
				}
			else
				emailLabel.setTextFill(Color.web("#4CAF50"));
		});
		
		passwordField.setOnKeyPressed(e->
		{
			passwordLabel.setTextFill(Color.web("#4CAF50"));
			passwordLabel.setVisible(true);
			passwordErrorLabel.setVisible(false);
		});
		passwordField.focusedProperty().addListener(e->
		{
			if(passwordField.isFocused()== false)
			{
				if(passwordField.getText().isEmpty())
				{
					passwordLabel.setTextFill(Color.web("#4CAF50"));
					passwordLabel.setVisible(false);
					passwordErrorLabel.setVisible(true);
					passwordField.getStyleClass().add("error");
				}
				else
					passwordLabel.setTextFill(Color.GRAY);
			}
			else
			if(passwordField.getText().isEmpty())
				{
					passwordLabel.setVisible(false);
					passwordErrorLabel.setVisible(false);
					passwordField.getStyleClass().remove("error");
				}
			else
				passwordLabel.setTextFill(Color.web("#4CAF50"));
		});
		
		retypePasswordField.setOnKeyPressed(e->
		{
			retypePasswordLabel.setTextFill(Color.web("#4CAF50"));
			retypePasswordLabel.setVisible(true);
			retypePasswordErrorLabel.setVisible(false);
		});
		retypePasswordField.focusedProperty().addListener(e->
		{
			if(retypePasswordField.isFocused()== false)
			{
				if(retypePasswordField.getText().isEmpty())
				{
					retypePasswordLabel.setTextFill(Color.web("#4CAF50"));
					retypePasswordLabel.setVisible(false);
					retypePasswordErrorLabel.setVisible(true);
					retypePasswordField.getStyleClass().add("error");
				}
				else
					retypePasswordLabel.setTextFill(Color.GRAY);
			}
			else
			if(retypePasswordField.getText().isEmpty())
				{
					retypePasswordLabel.setVisible(false);
					retypePasswordErrorLabel.setVisible(false);
					retypePasswordField.getStyleClass().remove("error");
				}
			else
				retypePasswordLabel.setTextFill(Color.web("#4CAF50"));
		});
	}

	private void animateIn()
	{
		loginCard.setOpacity(0);
		contentRegion.setOpacity(0);
		loginCard.setDisable(true);

		TranslateTransition tt1 = new TranslateTransition(Duration.millis(750), coverImage);
	    tt1.setDelay(Duration.seconds(1.5));
		tt1.setFromY(0);
		tt1.setToY(-338f);
		tt1.play();
		FadeTransition ft2 = new FadeTransition(Duration.millis(1500),contentRegion);
		ft2.setFromValue(0);
		ft2.setToValue(1);
		ft2.play();
		tt1.setOnFinished(e ->
		{	
			coverImage.setDisable(true);
			TranslateTransition tt = new TranslateTransition(Duration.millis(500), loginCard);
			FadeTransition ft1 = new FadeTransition(Duration.millis(1),	loginCard);
			ft1.setFromValue(0);
			ft1.setToValue(1);
			ft1.play();
			tt.setFromX(400f);
			tt.setToX(0);
			tt.play();
			loginCard.setDisable(false);
		});
	}

}
