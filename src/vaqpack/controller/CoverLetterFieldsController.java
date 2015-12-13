package vaqpack.controller;
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
import javafx.scene.control.ListCell;
import javafx.scene.control.ListView;
import javafx.scene.control.TextField;
import javafx.scene.layout.FlowPane;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;
import javafx.util.Callback;
import javafx.util.Duration;
import vaqpack.Tests.SQL;
import vaqpack.model.CoverLetterFields;
import vaqpack.model.CoverLetterFieldsCell;
import vaqpack.model.Singleton;

public class CoverLetterFieldsController implements Initializable

{
//	
	@FXML FlowPane fieldsBackground;
	@FXML VBox fieldsCard;
	@FXML StackPane fieldsListCard;
	
	@FXML TextField contactNameField;
	@FXML TextField contactTitleTextField;
	@FXML TextField organizationNameField;
	@FXML TextField addressField;
	@FXML TextField cityTextField;
	@FXML ChoiceBox<String> stateTextField;
	@FXML TextField zipCodeTextField;
	@FXML TextField jobTitleField;
	@FXML TextField jobId;
	
	@FXML Button addButton;
	@FXML Button saveButton;
	@FXML Button newActionButton;
	
	@FXML ListView<CoverLetterFields> fieldsListView;
	
	private ObservableList<CoverLetterFields> fieldsList = FXCollections.observableArrayList();
	private ArrayList<CoverLetterFields> globalFields = Singleton.getInstance().currentVaqpack().getCoverLetter().getCoverLetterList();
	private ArrayList<String> states =  new ArrayList<>(Arrays.asList("Alabama","Alaska","Arizona","Arkansas","California","Colorado","Connecticut","Delaware","Florida","Georgia","Hawaii","Idaho","Illinois","Indiana","Iowa","Kansas","Kentucky","Louisiana","Maine","Maryland","Massachusetts","Michigan","Minnesota","Mississippi","Missouri","Montana","Nebraska","Nevada","New Hampshire","New Jersey","New Mexico","New York","North Carolina","North Dakota","Ohio","Oklahoma","Oregon","Pennsylvania","Rhode Island","South Carolina","South Dakota","Tennessee","Texas","Utah","Vermont","Virginia","Washington","West Virginia","Wisconsin","Wyoming"));
	private ObservableList<String> state = FXCollections.observableArrayList();
	
	private boolean expanded;
	
	
	@FXML
	public void newActionButtonClicked(ActionEvent event)
	{	
		
		if(!expanded)
		{
			fieldsBackground.getChildren().add(0, fieldsCard);
			expanded = true;
		}		
		 contactNameField.setText("");
		 contactTitleTextField.setText("");
		 organizationNameField.setText("");
		 addressField.setText("");
		 cityTextField.setText("");
		 stateTextField.getSelectionModel().clearSelection();
		 zipCodeTextField.setText("");
		 jobTitleField.setText("");
		 jobId.setText("");
		 
		animateIn();
	}
	
	@FXML public void addButtonClicked() 
	{
		
		boolean added=false;
		
		CoverLetterFields coverLetterFields= new CoverLetterFields
		(
				 contactNameField.getText(),
				 contactTitleTextField.getText(),
				 organizationNameField.getText(),
				 addressField.getText(),
				 cityTextField.getText(),
				 stateTextField.getSelectionModel().getSelectedItem(),
				 zipCodeTextField.getText(),
				 jobTitleField.getText(),
				 jobId.getText()
		);
		
		for(int i =0; i < fieldsList.size(); i++ )
		{
			//if coverLetterFieldsList already exists, update
			if(fieldsList.get(i).getOrganizationName().equals(coverLetterFields.getOrganizationName()))
				{
					fieldsList.remove(i);
					fieldsList.add(i, coverLetterFields);
					added=true;
				}
		}
			if(!added)
				fieldsList.add(coverLetterFields);

	}
	


	@Override
	public void initialize(URL arg0, ResourceBundle arg1)
	{

		
		 loadList();
		 //validate();

	}

	private void validate()
	{
		
	}

	private void loadList()
	{
		state.setAll(states);
		stateTextField.setItems(state);
		
		
		fieldsBackground.getChildren().remove(fieldsCard);
		expanded = false;
		
		//Connect Global Resume list with current list
		if(globalFields!= null)
			for(int i = 0; i < globalFields.size(); i++)
				fieldsList.add(globalFields.get(i));
		 fieldsListView.setItems(fieldsList);
		 
		 //Connect to Custom Cell
		 fieldsListView.setCellFactory(new Callback<ListView<CoverLetterFields>, ListCell<CoverLetterFields>>() {
	            @Override
	            public ListCell<CoverLetterFields> call(ListView<CoverLetterFields> item) {
	                return new CoverLetterFieldsCell();
	            }
	        });
	        
		 //Listener for when an item is selected
		 fieldsListView.getSelectionModel().selectedItemProperty().addListener(e->
	        {
	        	if(!expanded)
	        	{	        		
	    			fieldsBackground.getChildren().add(0, fieldsCard);
	    			expanded = true;
	        	}
	        	
	        	if(!fieldsList.isEmpty())
	        	{
	        		CoverLetterFields selected = fieldsListView.getSelectionModel().getSelectedItem();
	        		 contactNameField.setText(selected.getContactName());
					 contactTitleTextField.setText(selected.getContactTitle());
					 organizationNameField.setText(selected.getOrganizationName());
					 addressField.setText(selected.getAddress());
					 cityTextField.setText(selected.getCity());
					 stateTextField.getSelectionModel().select(selected.getState());
					 zipCodeTextField.setText(selected.getZipCode());
					 jobTitleField.setText(selected.getJobTitle());
					 jobId.setText(selected.getJobId());
	        
	        	}
	        	animateIn();
	        });
		
	}
	
	private void animateIn()
	{
		TranslateTransition tt = new TranslateTransition(Duration.millis(500), fieldsCard);
		FadeTransition ft1 = new FadeTransition(Duration.millis(1),	fieldsCard);
		ft1.setFromValue(0);
		ft1.setToValue(1);
		ft1.play();
		tt.setFromX(400f);
		tt.setToX(0);
		tt.play();
	}


	@FXML public void saveButtonClicked() {
		
		//globalExperience.clear();
		globalFields= new ArrayList<CoverLetterFields>();
		globalFields.addAll(fieldsList);
		 
		Singleton.getInstance().currentVaqpack().getCoverLetter().setCoverLetterList(globalFields);
		SQL.updateDB(Singleton.getInstance().currentVaqpack(), Singleton.getInstance().currentVaqpack().getResume().getPersonal().getEmail());
		
	}
	



}
