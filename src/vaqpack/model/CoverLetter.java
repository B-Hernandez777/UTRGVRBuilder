package vaqpack.model;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

public class CoverLetter
{
	private String coverLetter;
	private ObservableList<Paragraph> paragraphList = FXCollections.observableArrayList(new Paragraph("a;lskdjf;lkasjdf;l."));
	
	
	public CoverLetter(String coverLetter)
	{
		this.coverLetter = coverLetter;
	}
	public String getCoverLetter()
	{
		return coverLetter;
	}
	public void setCoverLetter(String coverLetter)
	{
		this.coverLetter = coverLetter;
	}
	
	@Override
	public String toString()
	{
		return coverLetter;
	}
	public ObservableList<Paragraph> getParagraphList()
	{
		return paragraphList;
	}
	public void setParagraphList(ObservableList<Paragraph> paragraphList)
	{
		this.paragraphList = paragraphList;
	}
}
