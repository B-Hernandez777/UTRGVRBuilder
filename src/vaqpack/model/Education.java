package vaqpack.model;

import java.time.LocalDate;

public class Education
{
	private String institutionName;
	private String degree;
	private String city;
	private String state;
	
	public Education(String institutionName, String degree, String city,
			String state, double gpa, LocalDate startDate, LocalDate endDate)
	{
		super();
		this.institutionName = institutionName;
		this.degree = degree;
		this.city = city;
		this.state = state;
		this.gpa = gpa;
		this.startDate = startDate;
		this.endDate = endDate;
	}
	
	
	public String getInstitutionName()
	{
		return institutionName;
	}
	public void setInstitutionName(String institutionName)
	{
		this.institutionName = institutionName;
	}
	public String getDegree()
	{
		return degree;
	}
	public void setDegree(String degree)
	{
		this.degree = degree;
	}
	public String getCity()
	{
		return city;
	}
	public void setCity(String city)
	{
		this.city = city;
	}
	public String getState()
	{
		return state;
	}
	public void setState(String state)
	{
		this.state = state;
	}
	public double getGpa()
	{
		return gpa;
	}
	public void setGpa(double gpa)
	{
		this.gpa = gpa;
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
	private double gpa;
	private LocalDate startDate;
	private LocalDate endDate;
	
}
