package vaqpack.model;

import java.time.LocalDate;
import java.util.Date;


public class Experience
{
	private String title;
	private String description;
	private LocalDate startDate;
	private LocalDate endDate;
	private String CompanyName;
	private String ComanyCity;
	private  String CompanyState;
	
	public Experience(String title, String description, LocalDate startDate,
			LocalDate endDate, String companyName, String comanyCity,
			String companyState)
	{
		this.title = title;
		this.description = description;
		this.startDate = startDate;
		this.endDate = endDate;
		CompanyName = companyName;
		ComanyCity = comanyCity;
		CompanyState = companyState;
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
		return CompanyName;
	}

	public void setCompanyName(String companyName)
	{
		CompanyName = companyName;
	}

	public String getComanyCity()
	{
		return ComanyCity;
	}

	public void setComanyCity(String comanyCity)
	{
		ComanyCity = comanyCity;
	}

	public String getCompanyState()
	{
		return CompanyState;
	}

	public void setCompanyState(String companyState)
	{
		CompanyState = companyState;
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
