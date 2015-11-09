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
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;



public class LoginController implements Initializable
{
	@FXML Button loginButton;
	@FXML TextField emailTextField;
	@FXML Label emailLabel;
	@FXML Label emailErrorLabel;
	@FXML Label passwordLabel;
	@FXML Label passwordErrorLabel;
	@FXML PasswordField passwordField;
	
	
	@FXML private void loginButtonClicked(ActionEvent event) throws IOException
	{
		System.out.println(emailTextField.getText());
		
		//Validate email text field is not empty
		if(emailTextField.getText().isEmpty())
		{}
		else
		{
		FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("Main.fxml"));
		Parent root = (Pane) fxmlLoader.load();
		Scene scene = new Scene(root);
		Stage stage = new Stage();

		scene.getStylesheets().add(getClass().getResource("material-fx-v0_3.css").toExternalForm());
		//stage.initModality(Modality.APPLICATION_MODAL);
		stage.setScene(scene);
		stage.setTitle("Main2");
		stage.show();
		((Node)(event.getSource())).getScene().getWindow().hide();
		}
		
		
	}
	
	@Override
	public void initialize(URL location, ResourceBundle resources)
	{
		//Experiment to try and validate on the spot
		//Hides email Label until EmailField is entered
		emailTextField.setOnKeyPressed(e->
		{
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
			}
			else
			if(emailTextField.getText().isEmpty())
				{
					emailLabel.setVisible(false);
					emailErrorLabel.setVisible(false);
					emailTextField.getStyleClass().remove("error");
				}			
		});
		
		passwordField.setOnKeyPressed(e->
		{
			passwordLabel.setVisible(true);
			passwordErrorLabel.setVisible(false);
		});
		passwordField.focusedProperty().addListener(e->
		{
			if(passwordField.isFocused()== false)
			{
				if(passwordField.getText().isEmpty())
				{
					passwordLabel.setVisible(false);
					passwordErrorLabel.setVisible(true);
					passwordField.getStyleClass().add("error");
				}			
			}
			else
			if(passwordField.getText().isEmpty())
				{
					passwordLabel.setVisible(false);
					passwordErrorLabel.setVisible(false);
					passwordField.getStyleClass().remove("error");
				}			
		});
	}

}
