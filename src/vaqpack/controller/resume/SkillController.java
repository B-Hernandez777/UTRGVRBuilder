package vaqpack.controller.resume;

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
import javafx.scene.layout.FlowPane;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.util.Callback;
import javafx.util.Duration;
import vaqpack.model.resume.Context;
import vaqpack.model.resume.Skill;
import vaqpack.model.resume.SkillCell;

public class SkillController implements Initializable

{
	
	@FXML FlowPane skillBackground;
	@FXML VBox skillCard;
	@FXML StackPane skillListCard;
	@FXML Label skillLabel;
	@FXML TextArea skillTextArea;
	@FXML Label skillErrorLabel;

	
	@FXML Button addButton;
	@FXML Button saveButton;
	@FXML Button newActionButton;
	
	@FXML ListView<Skill> skillListView;
	
	private ObservableList<Skill> skillList = Context.getInstance().currentResume().getSkillList();
	private boolean expanded;
	
	
	@FXML
	public void newActionButtonClicked(ActionEvent event)
	{	
		
		if(!expanded)
		{
			skillBackground.getChildren().add(0, skillCard);
			expanded = true;
		}		
		
		skillTextArea.setText("");
		
		animateIn();
	}
	
	@FXML public void addButtonClicked() 
	{
		
		boolean added=false;
		
		Skill skill = new Skill
		(
				skillTextArea.getText()
				//descriptionTextArea.getText(), startDate.getValue(),
		);
		
		
		for(int i =0; i < skillList.size(); i++ )
		{
			//if Experience already exists, update
			if(skillList.get(i).getSkill().equals(skill.getSkill()))
				{
					skillList.remove(i);
					skillList.add(i, skill);
					added=true;
				}
		}
			if(!added)
				skillList.add(skill);

	}
	


	@Override
	public void initialize(URL arg0, ResourceBundle arg1)
	{
		
		 System.out.println(skillList);
		 loadList();
		 validate();

	}

	private void validate()
	{
		skillTextArea.setOnKeyPressed(e->
			{
				skillLabel.setTextFill(Color.web("#4CAF50"));
				skillLabel.setVisible(true);
				skillErrorLabel.setVisible(false);
			});
			skillTextArea.focusedProperty().addListener(e->
			{
				if(skillTextArea.isFocused()== false)
				{
					if(skillTextArea.getText().isEmpty())
					{
						skillLabel.setVisible(false);
						skillErrorLabel.setVisible(true);
						skillTextArea.getStyleClass().add("error");
					}
					else
						skillLabel.setTextFill(Color.GRAY);
				}
				else
				if(skillTextArea.getText().isEmpty())
					{
						skillLabel.setVisible(false);
						skillErrorLabel.setVisible(false);
						skillTextArea.getStyleClass().remove("error");
					}
				else
					skillLabel.setTextFill(Color.web("#4CAF50"));
				
			});
	}
	

	

	private void loadList()
	{
		skillBackground.getChildren().remove(skillCard);
		expanded = false;
		
		//Connect Global Resume list with current list
		 skillListView.setItems(skillList);
		 
		 //Connect to Custom Cell
		 skillListView.setCellFactory(new Callback<ListView<Skill>, ListCell<Skill>>() {
	            @Override
	            public ListCell<Skill> call(ListView<Skill> item) {
	                return new SkillCell();
	            }
	        });
	        
		 //Listener for when an item is selected
		 skillListView.getSelectionModel().selectedItemProperty().addListener(e->
	        {
	        	if(!expanded)
	        	{	        		
	    			skillBackground.getChildren().add(0, skillCard);
	    			expanded = true;
	        	}
	        	
	        	if(!skillList.isEmpty())
	        	{
	        		Skill selected = skillListView.getSelectionModel().getSelectedItem();
	        		skillTextArea.setText(selected.getSkill());
	        		//descriptionTextArea.setText(selected.getDescription());
	        	
	        	}
	        	animateIn();
	        });
	}
	
	private void animateIn()
	{
		TranslateTransition tt = new TranslateTransition(Duration.millis(500), skillCard);
		FadeTransition ft1 = new FadeTransition(Duration.millis(1),	skillCard);
		ft1.setFromValue(0);
		ft1.setToValue(1);
		ft1.play();
		tt.setFromX(400f);
		tt.setToX(0);
		tt.play();
	}

	



}
