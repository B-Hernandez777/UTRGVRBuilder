package vaqpack.model.resume;

import java.io.Serializable;
import java.time.LocalDate;

public class Education implements Serializable
{

	private static final long serialVersionUID = 1L;
	private String institutionName;
	private String degree;
	private String city;
	private String state;
	private String gpa;
	private LocalDate startDate;
	private LocalDate endDate;
	
	public Education(String institutionName, String degree, String city,
			String state, String gpa, LocalDate startDate, LocalDate endDate)
	{
		this.institutionName = institutionName +"";
		this.degree = degree +"";
		this.city = city +"";
		this.state = state +"";
		this.gpa = gpa;
		this.startDate = startDate;
		this.endDate = endDate;
	}
	
	@Override
	public String toString()
	{
		return String.format("\t\t<ed>" + "\n\t\t\t"
				+	"<school> %s </school>" + "\n\t\t\t"
				+ "<schoolcity> %s </schoolcity>" + "\n\t\t\t"
				+ "<schoolstate >%s </schoolstate>" + "\n\t\t\t"
				+ "<degree> %s </degree>"+ "\n\t\t\t"
				+ "<GPA> %s </GPA>"+ "\n\t\t\t"
				+ "<schoolstart> %s </schoolstart>"+ "\n\t\t\t"
				+ "<schoolend> %s </schoolend>" + "\n\t\t"
				+  "</ed>\n", institutionName, city, state, degree, gpa, startDate + "", endDate + "");
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
	public String getGpa()
	{
		return gpa;
	}
	public void setGpa(String gpa)
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

	
}
