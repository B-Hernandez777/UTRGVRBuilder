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
import javafx.scene.control.TextField;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;



public class LoginController implements Initializable
{
	@FXML Button loginButton;
	@FXML TextField emailTextField;
	
	
	
	@FXML private void loginButtonClicked(ActionEvent event) throws IOException
	{
		System.out.println(emailTextField.getText());
		
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
	
	@Override
	public void initialize(URL location, ResourceBundle resources)
	{
		
	}

}
