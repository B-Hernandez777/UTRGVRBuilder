package vaqpack.controller.resume;

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
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.FlowPane;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;
import javafx.util.Duration;
import vaqpack.Tests.SQL;
import vaqpack.model.Singleton;
import vaqpack.model.resume.ResumeStyle;

public class ResumeStyleController implements Initializable

{
	
	@FXML FlowPane styleBackground;
	@FXML VBox styleCard;
	@FXML StackPane styleListCard;
	@FXML Button saveButton;
	@FXML ImageView imageStyle;
	
	@FXML ListView<ResumeStyle> styleListView;
	
	private ObservableList<ResumeStyle> styleList = FXCollections.observableArrayList(new ResumeStyle("Style 1"), new ResumeStyle("Style 2"), new ResumeStyle("Style 3"), new ResumeStyle("Style 4"));
	private boolean expanded;
	
		

	@Override
	public void initialize(URL arg0, ResourceBundle arg1)
	{
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
	        		ResumeStyle selected = styleListView.getSelectionModel().getSelectedItem();
	        		imageStyle.setImage(new Image("/vaqpack/images/"+selected.getStyle().trim()+".PNG"));
	        		imageStyle.setFitHeight(378);
	        		imageStyle.setFitWidth(375.0);
	        		
	        		Singleton.getInstance().currentVaqpack().getResume().setStyle(selected);
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



	@FXML public void saveButtonClicked() 
	{
		Singleton.getInstance().currentVaqpack().getResume().setStyle(styleListView.getSelectionModel().getSelectedItem());
		SQL.updateDB(Singleton.getInstance().currentVaqpack(), Singleton.getInstance().currentVaqpack().getResume().getPersonal().getEmail());
	}

	



}
