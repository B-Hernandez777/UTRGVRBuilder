package vaqpack.controller;
import java.net.URL;
import java.util.ResourceBundle;

import javafx.animation.FadeTransition;
import javafx.animation.TranslateTransition;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.layout.VBox;
import javafx.util.Duration;


public class ObjectiveController implements Initializable
{

	@FXML VBox objectiveCard;
	
	@Override
	public void initialize(URL arg0, ResourceBundle arg1)
	{
		animateIn();

		
	}

	private void animateIn()
	{
		TranslateTransition tt = new TranslateTransition(Duration.millis(500), objectiveCard);
		FadeTransition ft1 = new FadeTransition(Duration.millis(1),	objectiveCard);
		ft1.setFromValue(0);
		ft1.setToValue(1);
		ft1.play();
		tt.setFromX(400f);
		tt.setToX(0);
		tt.play();
	}

}
