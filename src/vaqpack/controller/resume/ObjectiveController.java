package vaqpack.controller.resume;
import java.net.URL;
import java.util.ResourceBundle;

import javafx.animation.FadeTransition;
import javafx.animation.TranslateTransition;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.TextArea;
import javafx.scene.layout.VBox;
import javafx.util.Duration;
import vaqpack.Tests.SQL;
import vaqpack.model.Singleton;
import vaqpack.model.resume.Objective;


public class ObjectiveController implements Initializable
{

	@FXML VBox objectiveCard;
	@FXML TextArea objectiveTextArea;
	private Objective objective = Singleton.getInstance().currentVaqpack().getResume().getObjective();
	
	
	@Override
	public void initialize(URL arg0, ResourceBundle arg1)
	{
		animateIn();		
		loadInformation();
		objectiveTextArea.setWrapText(true);
	}

	private void loadInformation()
	{
		if(objective.getObjective() != null)
		objectiveTextArea.setText(objective.getObjective());
		
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
	
	@FXML
	public void saveButtonClicked()
	{
		objective = new Objective(objectiveTextArea.getText());
		Singleton.getInstance().currentVaqpack().getResume().setObjective(objective);
		SQL.updateDB(Singleton.getInstance().currentVaqpack(), Singleton.getInstance().currentVaqpack().getResume().getPersonal().getEmail());
	}
	

}
