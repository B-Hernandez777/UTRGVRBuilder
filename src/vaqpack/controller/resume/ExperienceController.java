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
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.layout.FlowPane;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.util.Callback;
import javafx.util.Duration;
import vaqpack.model.Singleton;
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
	@FXML ChoiceBox<String> companyStateTextField;
	@FXML DatePicker startDate;
	@FXML DatePicker endDate;
	@FXML Button addButton;
	@FXML Button saveButton;
	@FXML Button newActionButton;
	@FXML Label errorLabel;
	
	@FXML ListView<Experience> experienceListView;
	
	private  ObservableList<Experience> experienceList = FXCollections.observableArrayList();
	private ArrayList<Experience> globalExperience = Singleton.getInstance().currentVaqpack().getResume().getExperienceList();
	private ArrayList<String> states =  new ArrayList<>(Arrays.asList("Alabama","Alaska","Arizona","Arkansas","California","Colorado","Connecticut","Delaware","Florida","Georgia","Hawaii","Idaho","Illinois","Indiana","Iowa","Kansas","Kentucky","Louisiana","Maine","Maryland","Massachusetts","Michigan","Minnesota","Mississippi","Missouri","Montana","Nebraska","Nevada","New Hampshire","New Jersey","New Mexico","New York","North Carolina","North Dakota","Ohio","Oklahoma","Oregon","Pennsylvania","Rhode Island","South Carolina","South Dakota","Tennessee","Texas","Utah","Vermont","Virginia","Washington","West Virginia","Wisconsin","Wyoming"));
	private ObservableList<String> state = FXCollections.observableArrayList();
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
		companyStateTextField.getSelectionModel().clearSelection();
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
		Experience experience = new Experience
		(
				experienceTitleField.getText(),
				descriptionTextArea.getText(), startDate.getValue(),
				endDate.getValue(), companyNameTextField.getText(),
				companyCityTextField.getText(), companyStateTextField.getSelectionModel().getSelectedItem().toString()
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
	}

	private boolean validate(boolean error)
	{
		experienceTitleErrorLabel.setVisible(false);
		experienceTitleField.getStyleClass().remove("error");
		descriptionTextArea.setVisible(false);
		descriptionTextArea.getStyleClass().remove("error");
		errorLabel.setVisible(false);
		companyStateTextField.getStyleClass().remove("error");
		companyCityTextField.getStyleClass().remove("error");
		companyNameTextField.getStyleClass().remove("error");
		
		if(experienceTitleField.getText().isEmpty())
		{
			experienceTitleErrorLabel.setVisible(true);
			experienceTitleField.getStyleClass().add("error");
			error = true;
		}
		
		if(descriptionTextArea.getText().isEmpty())
		{
			descriptionTextArea.setVisible(true);
			descriptionTextArea.getStyleClass().add("error");
			error = true;
		}
		
		if(companyStateTextField.getSelectionModel().getSelectedItem() == null)
		{
			error=true;
			errorLabel.setText("Select a state ");
			errorLabel.setVisible(true);
			companyStateTextField.getStyleClass().add("error");
		}
		if(companyNameTextField.getText().isEmpty())
		{
			error=true;
			//errorLabel.setVisible(true);
			companyNameTextField.getStyleClass().add("error");
		}
		if(companyCityTextField.getText().isEmpty())
		{
			error=true;
			//errorLabel.setVisible(true);
			companyCityTextField.getStyleClass().add("error");
		}
		return error;
	}
	


	@Override
	public void initialize(URL arg0, ResourceBundle arg1)
	{

		 loadList();

	}

	
	
	private void loadList()
	{
		
		state.setAll(states);
		companyStateTextField.setItems(state);
		
		
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
	        		companyStateTextField.getSelectionModel().select((selected.getCompanyState()));
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
		 
		 Singleton.getInstance().currentVaqpack().getResume().setExperienceList(globalExperience);
		
		
	}

	



}
