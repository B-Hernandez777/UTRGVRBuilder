package vaqpack.model;

import java.io.Serializable;

public class Paragraph implements Serializable
{

	private static final long serialVersionUID = 1L;
	private String paragraph;

	public String getParagraph()
	{
		return paragraph;
	}

	public void setParagraph(String paragraph)
	{
		this.paragraph = paragraph;
	}

	public Paragraph(String paragraph)
	{
		this.paragraph = paragraph;
	}
	
	public String toString()
	{
		return String.format("\t"
				+ "<paragraph> %s </paragrpah>\n", paragraph);
	}
}
