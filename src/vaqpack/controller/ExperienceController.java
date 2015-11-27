package vaqpack.controller;

import java.net.URL;
import java.util.ResourceBundle;

import javafx.animation.FadeTransition;
import javafx.animation.TranslateTransition;
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
import javafx.scene.layout.VBox;
import javafx.util.Callback;
import javafx.util.Duration;
import vaqpack.model.Context;
import vaqpack.model.Experience;
import vaqpack.model.ExperienceCell;

public class ExperienceController implements Initializable

{
	@FXML VBox experienceCard;
	@FXML VBox experienceListCard;
	
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
	


	@Override
	public void initialize(URL arg0, ResourceBundle arg1)
	{
		
		System.out.println(Context.getInstance().currentResume().getExperienceList());
		 loadList();


	}
	
	@FXML
	public void newActionButtonClicked(ActionEvent event)
	{
	
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
		Experience experience = new Experience(	
		experienceTitleField.getText(),
		descriptionTextArea.getText(),
		startDate.getValue(),
		endDate.getValue(),
		companyNameTextField.getText(),
		companyCityTextField.getText(),
		companyStateTextField.getText());
		
		
		Context.getInstance().currentResume().getExperienceList().add(experience);
	;
		
		
		
	}
	
	

	private void loadList()
	{
		 experienceListView.setItems(Context.getInstance().currentResume().getExperienceList());
		 experienceListView.setCellFactory(new Callback<ListView<Experience>, ListCell<Experience>>() {
	            @Override
	            public ListCell<Experience> call(ListView<Experience> item) {
	                return new ExperienceCell();
	            }
	        });
	        
		 experienceListView.getSelectionModel().selectedItemProperty().addListener(e->
	        {
	        	if(!Context.getInstance().currentResume().getExperienceList().isEmpty())
	        	experienceTitleField.setText(experienceListView.getSelectionModel().getSelectedItem().getTitle());
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

	



}
