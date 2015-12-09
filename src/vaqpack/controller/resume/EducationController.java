package vaqpack.controller.resume;

import java.net.URL;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.ResourceBundle;

import javafx.animation.FadeTransition;
import javafx.animation.TranslateTransition;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.ChoiceBox;
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
import vaqpack.model.Singleton;
import vaqpack.model.resume.Education;
import vaqpack.model.resume.EducationCell;

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
	@FXML ChoiceBox<String> educationStateBox;
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
	private ArrayList<Education> globalEducation = Singleton.getInstance().currentVaqpack().getResume().getEducationList();
	private ArrayList<String> states =  new ArrayList<>(Arrays.asList("Alabama","Alaska","Arizona","Arkansas","California","Colorado","Connecticut","Delaware","Florida","Georgia","Hawaii","Idaho","Illinois","Indiana","Iowa","Kansas","Kentucky","Louisiana","Maine","Maryland","Massachusetts","Michigan","Minnesota","Mississippi","Missouri","Montana","Nebraska","Nevada","New Hampshire","New Jersey","New Mexico","New York","North Carolina","North Dakota","Ohio","Oklahoma","Oregon","Pennsylvania","Rhode Island","South Carolina","South Dakota","Tennessee","Texas","Utah","Vermont","Virginia","Washington","West Virginia","Wisconsin","Wyoming"));
	private ObservableList<String> state = FXCollections.observableArrayList();
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
		educationStateBox.getSelectionModel().clearSelection();
		degreeTextField.setText("");
		gpaTextField.setText("");
		startDate.setValue(null);
		endDate.setValue(null);
		animateIn();
	}
	
	@FXML public void addButtonClicked() 
	{
		
		boolean added=false;
		boolean error = false;
	
		error = validate(error);
		
		if(!error)
		{
		Education education = new Education
		(
				educationNameField.getText(),
				degreeTextField.getText(),
				educationCityTextField.getText(),
				educationStateBox.getSelectionModel().selectedItemProperty().toString(),
				gpaTextField.getText(),
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

	}

	private boolean validate(boolean error)
	{
		educationNameField.getStyleClass().remove("error");
		educationNameErrorLabel.setVisible(false);
		degreeTextField.getStyleClass().remove("error");
		degreeErrorLabel.setVisible(false);
		educationStateBox.getStyleClass().remove("error");
		educationCityTextField.getStyleClass().remove("error");
	
		//validate Gpa
		if(gpaTextField.getText().isEmpty())
			gpaTextField.setText("");
		try
		{
		  Double.parseDouble(gpaTextField.getText());
		}
		catch(NumberFormatException e)
		{
		  //not a double
			gpaTextField.setText("");
		}
		
		
		
		
		if(educationNameField.getText().isEmpty())
		{
			error = true;
			educationNameField.getStyleClass().add("error");
			educationNameErrorLabel.setVisible(true);
		}
		
		if(degreeTextField.getText().isEmpty())
		{
			error = true;
			degreeTextField.getStyleClass().add("error");
			degreeErrorLabel.setVisible(true);;
		}
		
		if(educationStateBox.getSelectionModel().getSelectedItem() == null)
		{
			error=true;
			educationStateBox.setVisible(true);
			educationStateBox.getStyleClass().add("error");
		
		}
		
		if(educationCityTextField.getText().isEmpty())
		{
			error = true;
			educationCityTextField.getStyleClass().add("error");
		}
		return error;
	}
	


	@Override
	public void initialize(URL arg0, ResourceBundle arg1)
	{
		state.setAll(states);
		educationStateBox.setItems(state);
		 loadList();

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
	        		educationStateBox.getSelectionModel().select(selected.getState());
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
		 
		 Singleton.getInstance().currentVaqpack().getResume().setEducationList(globalEducation);
		
		
	}




}
