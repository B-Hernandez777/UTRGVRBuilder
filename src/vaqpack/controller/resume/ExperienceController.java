package vaqpack.controller.resume;

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
import javafx.scene.control.DatePicker;
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
import vaqpack.model.resume.Context;
import vaqpack.model.resume.Experience;
import vaqpack.model.resume.ExperienceCell;

public class ExperienceController implements Initializable

{
	
	@FXML FlowPane experienceBackground;
	@FXML VBox experienceCard;
	@FXML StackPane experienceListCard;
	@FXML Label experienceTitleLabel;
	@FXML TextField experienceTitleField;
	@FXML Label experienceTitleErrorLabel;
	@FXML TextArea descriptionTextArea;
	@FXML Label descriptionErrorLabel;
	@FXML TextField companyNameTextField;
	@FXML TextField companyCityTextField;
	@FXML TextField companyStateTextField;
	@FXML DatePicker startDate;
	@FXML DatePicker endDate;
	@FXML Button addButton;
	@FXML Button saveButton;
	@FXML Button newActionButton;
	
	@FXML ListView<Experience> experienceListView;
	
	private  ObservableList<Experience> experienceList = FXCollections.observableArrayList();
	private ArrayList<Experience> globalExperience = Context.getInstance().currentResume().getExperienceList();
	private boolean expanded;
	
	
	@FXML
	public void newActionButtonClicked(ActionEvent event)
	{	
		
		if(!expanded)
		{
			experienceBackground.getChildren().add(0, experienceCard);
			expanded = true;
		}		
		
		experienceTitleField.setText("");
		descriptionTextArea.setText("");
		companyNameTextField.setText("");
		companyCityTextField.setText("");
		companyStateTextField.setText("");
		startDate.setValue(null);
		endDate.setValue(null);
		animateIn();
	}
	
	@FXML public void addButtonClicked() 
	{
		
		boolean added=false;
		
		Experience experience = new Experience
		(
				experienceTitleField.getText(),
				descriptionTextArea.getText(), startDate.getValue(),
				endDate.getValue(), companyNameTextField.getText(),
				companyCityTextField.getText(), companyStateTextField.getText()
		);
		
		
		for(int i =0; i < experienceList.size(); i++ )
		{
			//if Experience already exists, update
			if(experienceList.get(i).getTitle().equals(experience.getTitle()))
				{
					experienceList.remove(i);
					experienceList.add(i, experience);
					added=true;
				}
		}
			if(!added)
				experienceList.add(experience);

	}
	


	@Override
	public void initialize(URL arg0, ResourceBundle arg1)
	{
		
		// System.out.println(experienceList);
		 loadList();
		 validate();

	}

	private void validate()
	{
		experienceTitleField.setOnKeyPressed(e->
			{
				experienceTitleLabel.setTextFill(Color.web("#4CAF50"));
				experienceTitleLabel.setVisible(true);
				experienceTitleErrorLabel.setVisible(false);
			});
			experienceTitleField.focusedProperty().addListener(e->
			{
				if(experienceTitleField.isFocused()== false)
				{
					if(experienceTitleField.getText().isEmpty())
					{
						experienceTitleLabel.setVisible(false);
						experienceTitleErrorLabel.setVisible(true);
						experienceTitleField.getStyleClass().add("error");
					}
					else
						experienceTitleLabel.setTextFill(Color.GRAY);
				}
				else
				if(experienceTitleField.getText().isEmpty())
					{
						experienceTitleLabel.setVisible(false);
						experienceTitleErrorLabel.setVisible(false);
						experienceTitleField.getStyleClass().remove("error");
					}
				else
					experienceTitleLabel.setTextFill(Color.web("#4CAF50"));
				
			});
	}
	
	private void loadList()
	{
		experienceBackground.getChildren().remove(experienceCard);
		expanded = false;
	

		if(globalExperience != null)
			for(int i = 0; i < globalExperience.size(); i++)
				experienceList.add(globalExperience.get(i));
		
	

		//Connect Global Resume list with current list
		 experienceListView.setItems(experienceList);
		 
		 //Connect to Custom Cell
		 experienceListView.setCellFactory(new Callback<ListView<Experience>, ListCell<Experience>>() {
	            @Override
	            public ListCell<Experience> call(ListView<Experience> item) {
	                return new ExperienceCell();
	            }
	        });
	        
		 //Listener for when an item is selected
		 experienceListView.getSelectionModel().selectedItemProperty().addListener(e->
	        {
	        	if(!expanded)
	        	{	        		
	    			experienceBackground.getChildren().add(0, experienceCard);
	    			expanded = true;
	        	}
	        	
	        	if(!experienceList.isEmpty())
	        	{
	        		Experience selected = experienceListView.getSelectionModel().getSelectedItem();
	        		experienceTitleField.setText(selected.getTitle());
	        		descriptionTextArea.setText(selected.getDescription());
	        		companyNameTextField.setText(selected.getCompanyName());
	        		companyCityTextField.setText(selected.getCompanyCity());
	        		companyStateTextField.setText(selected.getCompanyState());
	        		startDate.setValue(selected.getStartDate());
	        		endDate.setValue(selected.getEndDate());
	        	}
	        	animateIn();
	        });
	}
	
	private void animateIn()
	{
		TranslateTransition tt = new TranslateTransition(Duration.millis(500), experienceCard);
		FadeTransition ft1 = new FadeTransition(Duration.millis(1),	experienceCard);
		ft1.setFromValue(0);
		ft1.setToValue(1);
		ft1.play();
		tt.setFromX(400f);
		tt.setToX(0);
		tt.play();
	}

	@FXML public void saveButtonClicked() {
		
		//globalExperience.clear();
		globalExperience = new ArrayList<Experience>();
		globalExperience.addAll(experienceList);
		 
		 Context.getInstance().currentResume().setExperienceList(globalExperience);
		
		
	}

	



}
