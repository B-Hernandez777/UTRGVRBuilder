package vaqpack.model;

import java.util.ArrayList;

public class CoverLetter
{
	private ArrayList<CoverLetterFields> coverLetterList;
	private ArrayList<Paragraph> paragraphList;
	private CoverLetterStyle style;

	
	
	

	public CoverLetterStyle getStyle()
	{
		return style;
	}
	public void setStyle(CoverLetterStyle style)
	{
		this.style = style;
	}
	public ArrayList<CoverLetterFields> getCoverLetterList()
	{
		return coverLetterList;
	}
	public void setCoverLetterList(ArrayList<CoverLetterFields> coverLetterList)
	{
		this.coverLetterList = coverLetterList;
	}
	public ArrayList<Paragraph> getParagraphList()
	{
		return paragraphList;
	}
	public void setParagraphList(ArrayList<Paragraph> paragraphList)
	{
		this.paragraphList = paragraphList;
	}
}
