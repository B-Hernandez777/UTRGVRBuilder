package vaqpack.controller;

import java.io.File;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

import javafx.animation.FadeTransition;
import javafx.animation.TranslateTransition;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.CheckBox;
import javafx.scene.control.ListView;
import javafx.scene.layout.FlowPane;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;
import javafx.stage.FileChooser;
import javafx.util.Duration;
import vaqpack.model.WebsiteStyle;

public class ExportController implements Initializable

{

	@FXML
	FlowPane exportBackground;
	@FXML
	VBox exportCard;
	@FXML
	StackPane exportListCard;
	@FXML
	Button exportButton;
	@FXML
	CheckBox resumeCheckBox;
	@FXML
	CheckBox coverLettercheckbox;
	@FXML
	CheckBox websiteCheckbox;
	@FXML
	CheckBox businesscardsCheckBox;
	@FXML
	Button saveLocation;

	@FXML
	ListView<WebsiteStyle> styleListView;

	private boolean expanded;

	@Override
	public void initialize(URL arg0, ResourceBundle arg1)
	{

		loadList();

	}

	private void loadList()
	{
		expanded = true;

		animateIn();
	}

	private void animateIn()
	{
		TranslateTransition tt = new TranslateTransition(Duration.millis(500),
				exportCard);
		FadeTransition ft1 = new FadeTransition(Duration.millis(1), exportCard);
		ft1.setFromValue(0);
		ft1.setToValue(1);
		ft1.play();
		tt.setFromX(400f);
		tt.setToX(0);
		tt.play();
	}

	@FXML
	public void saveLocation()
	{

		FileChooser fileChooser = new FileChooser();
		fileChooser.setTitle("Save file");
		fileChooser.setInitialFileName("resume.xml");
		File savedFile = fileChooser.showSaveDialog(null);
		if (savedFile != null)
		{

		}

	}

}
