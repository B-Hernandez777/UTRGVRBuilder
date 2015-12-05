package vaqpack.model.resume;

import java.io.Serializable;
import java.time.LocalDate;


public class Experience implements Serializable
{

	private static final long serialVersionUID = 1L;
	private String title;
	private String description;
	private LocalDate startDate;
	private LocalDate endDate;
	private String companyName;
	private String companyCity;
	private String companyState;
	
	public Experience(String title, String description, LocalDate startDate,
			LocalDate endDate, String companyName, String companyCity,
			String companyState)
	{
		this.title = title;
		this.description = description;
		this.startDate = startDate;
		this.endDate = endDate;
		this.companyName = companyName;
		this.companyCity = companyCity;
		this.companyState = companyState;
	}

	public String getDescription()
	{
		return description;
	}

	public void setDescription(String description)
	{
		this.description = description;
	}

	public LocalDate getStartDate()
	{
		return startDate;
	}

	public void setStartDate(LocalDate startDate)
	{
		this.startDate = startDate;
	}

	public LocalDate getEndDate()
	{
		return endDate;
	}

	public void setEndDate(LocalDate endDate)
	{
		this.endDate = endDate;
	}

	public String getCompanyName()
	{
		return companyName;
	}

	public void setCompanyName(String companyName)
	{
		this.companyName = companyName;
	}

	public String getCompanyCity()
	{
		return companyCity;
	}

	public void setCompanyCity(String companyCity)
	{
		this.companyCity = companyCity;
	}

	public String getCompanyState()
	{
		return companyState;
	}

	public void setCompanyState(String companyState)
	{
		this.companyState = companyState;
	}	
	public  Experience(String title)
	{
		this.title = title;
	}

	public String getTitle()
	{
		return title;
	}

	public void setTitle(String title)
	{
		this.title = title;
	}
	
	public String toString()
	{
		return String.format("\t\t<e>\n\t\t\t"
				+ "<job> %s </job>"+"\n\t\t\t"
				+ "<description> %s </description>"+"\n\t\t\t"
				+ "<companyname> %s </companyname>"+"\n\t\t\t"
				+ "<companycity> %s </companycity>"+"\n\t\t\t"
				+ "<companystate> %s </compnaystate>"+"\n\t\t\t"
				+ "<start> %s </start>"+"\n\t\t\t"
				+ "<end> %s </end>"+"\n\t\t"
				+ "</e>\n"
				, title, description, companyName, companyCity, companyState, startDate, endDate);
	}
	
	
}
