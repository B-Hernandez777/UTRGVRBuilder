package vaqpack.controller;
import java.net.URL;
import java.util.ArrayList;
import java.util.ResourceBundle;

import javafx.animation.FadeTransition;
import javafx.animation.TranslateTransition;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.ListCell;
import javafx.scene.control.ListView;
import javafx.scene.control.TextArea;
import javafx.scene.layout.FlowPane;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;
import javafx.util.Callback;
import javafx.util.Duration;
import vaqpack.model.CoverLetterFields;
import vaqpack.model.Paragraph;
import vaqpack.model.ParagraphCell;
import vaqpack.model.Singleton;
import vaqpack.model.resume.Context;
import vaqpack.model.resume.Experience;



public class CoverLetterParagraphController implements Initializable
{
	@FXML FlowPane paragraphBackground;
	@FXML VBox paragraphCard;
	@FXML TextArea paragraphTextArea;
	@FXML StackPane paragraphListCard;
	@FXML Button addButton;
	@FXML Button saveButton;
	@FXML Button newActionButton;
	@FXML ListView<Paragraph> paragraphListView;

	private  ObservableList<Paragraph> paragraphList = FXCollections.observableArrayList();
	private ArrayList<Paragraph> globalParagraphs = new ArrayList<Paragraph>();
		private boolean expanded;
		
		@FXML
		public void newActionButtonClicked(ActionEvent event)
		{	
			if(!expanded)
			{
				paragraphBackground.getChildren().add(0, paragraphCard);
				expanded = true;
			}		
			
			paragraphTextArea.setText("");
	
			animateIn();
		}
		
		@FXML public void addButtonClicked() 
		{
			
			boolean added=false;
			
			
			Paragraph paragraph = new Paragraph
			(
					paragraphTextArea.getText()
			);
			
			for(int i =0; i < paragraphList.size(); i++ )
			{
				//if paragraph already exists, update
				if(paragraphList.get(i).getParagraph().equals(paragraph.getParagraph()))
					{
						paragraphList.remove(i);
						paragraphList.add(i, paragraph);
						added=true;
					}
			}
				if(!added)
					paragraphList.add(paragraph);

		}
		


	

		private void validate()
		{
			
		}
		

		

		private void loadList()
		{
			paragraphBackground.getChildren().remove(paragraphCard);
			expanded = false;
			
			//Connect Global Resume list with current list
			if(globalParagraphs!= null)
				for(int i = 0; i < globalParagraphs.size(); i++)
					paragraphList.add(globalParagraphs.get(i));
			 paragraphListView.setItems(paragraphList);
			 
			 //Connect to Custom Cell
			 paragraphListView.setCellFactory(new Callback<ListView<Paragraph>, ListCell<Paragraph>>() {
		    
		            public ListCell<Paragraph> call(ListView<Paragraph> item) {
		                return new ParagraphCell();
		            }
		        });
		        
			 //Listener for when an item is selected
			 paragraphListView.getSelectionModel().selectedItemProperty().addListener(e->
		        {
		        	if(!expanded)
		        	{	        		
		    			paragraphBackground.getChildren().add(0, paragraphCard);
		    			expanded = true;
		        	}
		        	
		        	if(!paragraphList.isEmpty())
		        	{
		        		Paragraph selected = paragraphListView.getSelectionModel().getSelectedItem();
		        		paragraphTextArea.setText(selected.getParagraph());
		  
		        	animateIn();
		        	}
		        });
			
		
		        }

		
	@Override
	public void initialize(URL arg0, ResourceBundle arg1)
	{
	
			
			 for(int i =0; i < paragraphList.size(); i++)
			 {
				 System.out.println(paragraphList.get(i));
			 }
			 loadList();
			 validate();

	}


	private void animateIn()
	{
		TranslateTransition tt = new TranslateTransition(Duration.millis(500), paragraphCard);
		FadeTransition ft1 = new FadeTransition(Duration.millis(1),	paragraphCard);
		ft1.setFromValue(0);
		ft1.setToValue(1);
		ft1.play();
		tt.setFromX(400f);
		tt.setToX(0);
		tt.play();
	}
	
	@FXML public void saveButtonClicked() {
		
		//globalExperience.clear();
		globalParagraphs= new ArrayList<Paragraph>();
		globalParagraphs.addAll(paragraphList);
		 
		//Context.getInstance().currentResume().setSkillList(globalSkill);
		
		
	}

}
