package vaqpack.model;

import javafx.collections.ObservableList;

public class CoverLetter
{
	private ObservableList<CoverLetterFields> coverLetterList;
	private ObservableList<Paragraph> paragraphList;
	private CoverLetterStyle style;

	
	
	public ObservableList<Paragraph> getParagraphList()
	{
		return paragraphList;
	}
	public void setParagraphList(ObservableList<Paragraph> paragraphList)
	{
		this.paragraphList = paragraphList;
	}
	public ObservableList<CoverLetterFields> getCoverLetterList()
	{
		return coverLetterList;
	}
	public void setCoverLetterList(ObservableList<CoverLetterFields> coverLetterList)
	{
		this.coverLetterList = coverLetterList;
	}

	public CoverLetterStyle getStyle()
	{
		return style;
	}
	public void setStyle(CoverLetterStyle style)
	{
		this.style = style;
	}
}
