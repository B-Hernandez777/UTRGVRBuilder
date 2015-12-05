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
import javafx.scene.control.TextField;
import javafx.scene.layout.FlowPane;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.util.Callback;
import javafx.util.Duration;
import vaqpack.model.resume.Context;
import vaqpack.model.resume.Education;
import vaqpack.model.resume.EducationCell;
import vaqpack.model.resume.Experience;

public class EducationController implements Initializable

{
//	
	@FXML FlowPane educationBackground;
	@FXML VBox educationCard;
	@FXML StackPane educationListCard;
	@FXML Label educationNameLabel;
	@FXML TextField educationNameField;
	@FXML Label educationNameErrorLabel;
	@FXML TextField educationCityTextField;
	@FXML TextField educationStateTextField;
	@FXML Label degreeLabel;
	@FXML TextField degreeTextField;
	@FXML Label degreeErrorLabel;
	@FXML TextField gpaTextField;
	@FXML DatePicker startDate;
	@FXML DatePicker endDate;
	@FXML Button addButton;
	@FXML Button saveButton;
	@FXML Button newActionButton;
//	
	@FXML ListView<Education> educationListView;
//	
	private ObservableList<Education> educationList = FXCollections.observableArrayList();
	private ArrayList<Education> globalEducation = Context.getInstance().currentResume().getEducationList();
	private boolean expanded;
	
	
	@FXML
	public void newActionButtonClicked(ActionEvent event)
	{	
		
		if(!expanded)
		{
			educationBackground.getChildren().add(0, educationCard);
			expanded = true;
		}		
		
		educationNameField.setText("");
		educationCityTextField.setText("");
		educationStateTextField.setText("");
		degreeTextField.setText("");
		gpaTextField.setText("");
		startDate.setValue(null);
		endDate.setValue(null);
		animateIn();
	}
	
	@FXML public void addButtonClicked() 
	{
		
		boolean added=false;
		
		if(gpaTextField.getText().isEmpty())
			gpaTextField.setText(0.0+"");
		
		Education education = new Education
		(
				educationNameField.getText(),
				degreeTextField.getText(),
				educationCityTextField.getText(),
				educationStateTextField.getText(),
				Double.parseDouble(gpaTextField.getText()),
				startDate.getValue(),
				endDate.getValue()
		);
		
		for(int i =0; i < educationList.size(); i++ )
		{
			//if education already exists, update
			if(educationList.get(i).getInstitutionName().equals(education.getInstitutionName()))
				{
					educationList.remove(i);
					educationList.add(i, education);
					added=true;
				}
		}
			if(!added)
				educationList.add(education);

	}
	


	@Override
	public void initialize(URL arg0, ResourceBundle arg1)
	{
		 loadList();
		 validate();

	}

	private void validate()
	{
		educationNameField.setOnKeyPressed(e->
			{
				educationNameLabel.setTextFill(Color.web("#4CAF50"));
				educationNameLabel.setVisible(true);
				educationNameErrorLabel.setVisible(false);
			});
			educationNameField.focusedProperty().addListener(e->
			{
				if(educationNameField.isFocused()== false)
				{
					if(educationNameField.getText().isEmpty())
					{
						educationNameLabel.setVisible(false);
						educationNameErrorLabel.setVisible(true);
						educationNameField.getStyleClass().add("error");
					}
					else
						educationNameLabel.setTextFill(Color.GRAY);
				}
				else
				if(educationNameField.getText().isEmpty())
					{
						educationNameLabel.setVisible(false);
						educationNameErrorLabel.setVisible(false);
						educationNameField.getStyleClass().remove("error");
					}
				else
					educationNameLabel.setTextFill(Color.web("#4CAF50"));
				
			});
	}
	

	

	private void loadList()
	{
		educationBackground.getChildren().remove(educationCard);
		expanded = false;
		
		//Connect Global Resume list with current list
		if(globalEducation != null)
			for(int i = 0; i < globalEducation.size(); i++)
				educationList.add(globalEducation.get(i));
		
		
		 educationListView.setItems(educationList);
		 
		 //Connect to Custom Cell
		 educationListView.setCellFactory(new Callback<ListView<Education>, ListCell<Education>>() {
	            @Override
	            public ListCell<Education> call(ListView<Education> item) {
	                return new EducationCell();
	            }
	        });
	        
		 //Listener for when an item is selected
		 educationListView.getSelectionModel().selectedItemProperty().addListener(e->
	        {
	        	if(!expanded)
	        	{	        		
	    			educationBackground.getChildren().add(0, educationCard);
	    			expanded = true;
	        	}
	        	
	        	if(!educationList.isEmpty())
	        	{
	        		Education selected = educationListView.getSelectionModel().getSelectedItem();
	        		educationNameField.setText(selected.getInstitutionName());
	        		educationCityTextField.setText(selected.getCity());
	        		educationStateTextField.setText(selected.getState());
	        		degreeTextField.setText(selected.getDegree());
	        		gpaTextField.setText(selected.getGpa()+"");
	        		startDate.setValue(selected.getStartDate());
	        		endDate.setValue(selected.getEndDate());
	        	}
	        	animateIn();
	        });
		
	}
	
	private void animateIn()
	{
		TranslateTransition tt = new TranslateTransition(Duration.millis(500), educationCard);
		FadeTransition ft1 = new FadeTransition(Duration.millis(1),	educationCard);
		ft1.setFromValue(0);
		ft1.setToValue(1);
		ft1.play();
		tt.setFromX(400f);
		tt.setToX(0);
		tt.play();
	}

	@FXML public void saveButtonClicked() {
		
		//globalExperience.clear();
		globalEducation= new ArrayList<Education>();
		globalEducation.addAll(educationList);
		 
		 Context.getInstance().currentResume().setEducationList(globalEducation);
		
		
	}




}
