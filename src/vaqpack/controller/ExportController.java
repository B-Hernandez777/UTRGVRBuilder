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
        @FXML
        public void exportButtonClicked()
        {
            if(resumeCheckBox.isSelected() )
            {
                //get the resume xml
                // so either we can make the xml from the resume elements here 
                // or have it save some where else
                
                // then we send the xml and the selected style which will be set from the xsl i will upload
                // then send to the html maker function in resume styles and html name that the user can select or
                // it can be a preset name like resumewebsite.html
                // and the returns the html name
                
                // then with the htmlname ( which is the html file ) to the pdf function under export
                // and it will save the pdf in the set location or I suppose file so i can add the file parameter
            }
            // get the selected info / array
            // call the style function
            // so if the user selected the style 1 then the html function will be 
            // given the selected xml file and the selected style and the name of the html
            // the default name could be resumewebsite.html
            // then send to the html maker function in resume style( the function can be moved ) 
            // it returns the html and with that you can make the pdf and keep it in the same saved location
            
        }

}
