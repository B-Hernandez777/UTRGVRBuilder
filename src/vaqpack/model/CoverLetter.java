package vaqpack.model;

import java.io.Serializable;
import java.util.ArrayList;

import vaqpack.model.resume.Personal;

public class CoverLetter implements Serializable
{

	private static final long serialVersionUID = 1L;
	private ArrayList<CoverLetterFields> coverLetterList;
	private ArrayList<Paragraph> paragraphList;
	private CoverLetterStyle style;
	
	public CoverLetter()
	{
		super();
		this.coverLetterList = null;
		this.paragraphList = null;
		this.style = null;
		this.personal = null;
	}

	private Personal personal;

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
	public Personal getPersonal()
	{
		return personal;
	}
	public void setPersonal(Personal personal)
	{
		this.personal = personal;
	}
	
	public String toString()
	{
		return String.format("<coverletter>\n%s"
				+ "\t<paragraphs>\n%s" + "\n\t"
				+ "</paragraphs>\n" + "\t<CoverLetterFields>\n%s" + "\n\t" 
                                + "</CoverLetterFields>", personal, paragraphList, coverLetterList);

	}
}
