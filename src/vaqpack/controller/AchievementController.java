package vaqpack.controller;

import java.net.URL;
import java.util.ResourceBundle;

import javafx.animation.FadeTransition;
import javafx.animation.TranslateTransition;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.ListCell;
import javafx.scene.control.ListView;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.layout.FlowPane;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.util.Callback;
import javafx.util.Duration;
import vaqpack.model.Achievement;
import vaqpack.model.AchievementCell;
import vaqpack.model.Context;
import vaqpack.model.Experience;

public class AchievementController implements Initializable

{
	
	@FXML FlowPane achievementBackground;
	@FXML VBox achievementCard;
	@FXML StackPane achievementListCard;
	@FXML Label achievementLabel;
	@FXML TextField achievementField;
	@FXML Label achievementErrorLabel;
	@FXML TextArea descriptionTextArea;
	@FXML Label descriptionErrorLabel;
	
	@FXML Button addButton;
	@FXML Button saveButton;
	@FXML Button newActionButton;
	
	@FXML ListView<Achievement> achievementListView;
	
	private ObservableList<Achievement> achievementList = Context.getInstance().currentResume().getAchivementList();
	private boolean expanded;
	
	
	@FXML
	public void newActionButtonClicked(ActionEvent event)
	{	
		
		if(!expanded)
		{
			achievementBackground.getChildren().add(0, achievementCard);
			expanded = true;
		}		
		
		achievementField.setText("");
		descriptionTextArea.setText("");
		animateIn();
	}
	
	@FXML public void addButtonClicked() 
	{
		
		boolean added=false;
		
		Achievement achievement = new Achievement
		(
				achievementField.getText()
				//descriptionTextArea.getText(), startDate.getValue(),
		);
		
		
		for(int i =0; i < achievementList.size(); i++ )
		{
			//if Experience already exists, update
			if(achievementList.get(i).getName().equals(achievement.getName()))
				{
					achievementList.remove(i);
					achievementList.add(i, achievement);
					added=true;
				}
		}
			if(!added)
				achievementList.add(achievement);

	}
	


	@Override
	public void initialize(URL arg0, ResourceBundle arg1)
	{
		
		 System.out.println(achievementList);
		 loadList();
		 validate();

	}

	private void validate()
	{
		achievementField.setOnKeyPressed(e->
			{
				achievementLabel.setTextFill(Color.web("#4CAF50"));
				achievementLabel.setVisible(true);
				achievementErrorLabel.setVisible(false);
			});
			achievementField.focusedProperty().addListener(e->
			{
				if(achievementField.isFocused()== false)
				{
					if(achievementField.getText().isEmpty())
					{
						achievementLabel.setVisible(false);
						achievementErrorLabel.setVisible(true);
						achievementField.getStyleClass().add("error");
					}
					else
						achievementLabel.setTextFill(Color.GRAY);
				}
				else
				if(achievementField.getText().isEmpty())
					{
						achievementLabel.setVisible(false);
						achievementErrorLabel.setVisible(false);
						achievementField.getStyleClass().remove("error");
					}
				else
					achievementLabel.setTextFill(Color.web("#4CAF50"));
				
			});
	}
	

	

	private void loadList()
	{
		achievementBackground.getChildren().remove(achievementCard);
		expanded = false;
		
		//Connect Global Resume list with current list
		 achievementListView.setItems(achievementList);
		 
		 //Connect to Custom Cell
		 achievementListView.setCellFactory(new Callback<ListView<Achievement>, ListCell<Achievement>>() {
	            @Override
	            public ListCell<Achievement> call(ListView<Achievement> item) {
	                return new AchievementCell();
	            }
	        });
	        
		 //Listener for when an item is selected
		 achievementListView.getSelectionModel().selectedItemProperty().addListener(e->
	        {
	        	if(!expanded)
	        	{	        		
	    			achievementBackground.getChildren().add(0, achievementCard);
	    			expanded = true;
	        	}
	        	
	        	if(!achievementList.isEmpty())
	        	{
	        		Achievement selected = achievementListView.getSelectionModel().getSelectedItem();
	        		achievementField.setText(selected.getName());
	        		//descriptionTextArea.setText(selected.getDescription());
	        	
	        	}
	        	animateIn();
	        });
	}
	
	private void animateIn()
	{
		TranslateTransition tt = new TranslateTransition(Duration.millis(500), achievementCard);
		FadeTransition ft1 = new FadeTransition(Duration.millis(1),	achievementCard);
		ft1.setFromValue(0);
		ft1.setToValue(1);
		ft1.play();
		tt.setFromX(400f);
		tt.setToX(0);
		tt.play();
	}

	



}
