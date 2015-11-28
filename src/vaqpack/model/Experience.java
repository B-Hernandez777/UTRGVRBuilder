package vaqpack.model;

import java.time.LocalDate;


public class Experience
{
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
	
	
}
