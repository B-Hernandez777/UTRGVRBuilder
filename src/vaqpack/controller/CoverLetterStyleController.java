package vaqpack.controller;

import java.net.URL;
import java.util.ResourceBundle;

import javafx.animation.FadeTransition;
import javafx.animation.TranslateTransition;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.ListView;
import javafx.scene.layout.FlowPane;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;
import javafx.util.Duration;
import vaqpack.model.CoverLetter;
import vaqpack.model.CoverLetterStyle;
import vaqpack.model.resume.Context;
import vaqpack.model.resume.ResumeStyle;

public class CoverLetterStyleController implements Initializable

{
	
	@FXML FlowPane styleBackground;
	@FXML VBox styleCard;
	@FXML StackPane styleListCard;
	@FXML Button saveButton;

	
	@FXML ListView<CoverLetterStyle> styleListView;
	
	private ObservableList<CoverLetterStyle> styleList = FXCollections.observableArrayList(new CoverLetterStyle("Style 1"), new CoverLetterStyle("Style 2"));
	private boolean expanded;
	
		

	@Override
	public void initialize(URL arg0, ResourceBundle arg1)
	{
		
		 System.out.println(styleList);
		 loadList();

	}

	

	private void loadList()
	{
		styleBackground.getChildren().remove(styleCard);
		expanded = false;
		
		//Connect Global Resume list with current list
		 styleListView.setItems(styleList);
		 
		 //Connect to Custom Cell
		
	        
		 //Listener for when an item is selected
		 styleListView.getSelectionModel().selectedItemProperty().addListener(e->
	        {
	        	if(!expanded)
	        	{	        		
	    			styleBackground.getChildren().add(0, styleCard);
	    			expanded = true;
	        	}
	        	
	        	if(!styleList.isEmpty())
	        	{
	        		CoverLetterStyle selected = styleListView.getSelectionModel().getSelectedItem();
	        		//CoverLetter.setStyle(selected);
	        	}
	        	animateIn();
	        });
	}
	
	private void animateIn()
	{
		TranslateTransition tt = new TranslateTransition(Duration.millis(500), styleCard);
		FadeTransition ft1 = new FadeTransition(Duration.millis(1),	styleCard);
		ft1.setFromValue(0);
		ft1.setToValue(1);
		ft1.play();
		tt.setFromX(400f);
		tt.setToX(0);
		tt.play();
	}

	



}
