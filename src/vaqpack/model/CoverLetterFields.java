package vaqpack.model;

import java.io.Serializable;

public class CoverLetterFields implements Serializable
{

	private static final long serialVersionUID = 1L;
	private String contactName;
	private String contactTitle;
	private String organizationName;
	private String address;
	private String city;
	private String state;
	private String zipCode;
	private String jobId;
	private String jobTitle;
	
	public CoverLetterFields(String contactName, String contactTitle,
			String organizationName, String address, String city, String state,
			String zipCode, String jobId, String jobTitle)
	{

		this.contactName = contactName;
		this.contactTitle = contactTitle;
		this.organizationName = organizationName;
		this.address = address;
		this.city = city;
		this.state = state;
		this.zipCode = zipCode;
		this.jobId = jobId;
		this.jobTitle = jobTitle;
	}
	
	
	public String getContactName()
	{
		return contactName;
	}

	public void setContactName(String contactName)
	{
		this.contactName = contactName;
	}

	public String getContactTitle()
	{
		return contactTitle;
	}

	public void setContactTitle(String contactTitle)
	{
		this.contactTitle = contactTitle;
	}

	public String getAddress()
	{
		return address;
	}

	public void setAddress(String address)
	{
		this.address = address;
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

	public String getZipCode()
	{
		return zipCode;
	}

	public void setZipCode(String zipCode)
	{
		this.zipCode = zipCode;
	}

	public String getJobId()
	{
		return jobId;
	}

	public void setJobId(String jobId)
	{
		this.jobId = jobId;
	}



	public String getJobTitle()
	{
		return jobTitle;
	}
	public void setJobTitle(String jobTitle)
	{
		this.jobTitle = jobTitle;
	}


	public String getOrganizationName()
	{
		return organizationName;
	}


	public void setOrganizationName(String organizationName)
	{
		this.organizationName = organizationName;
	}
	
	public String toString()
	{

		return String.format("\t<coverpersonal>"+ "\n\t\t"

				+ "<contactname> %s </contactname>" +"\n\t\t"
				+ "<contacttitle> %s </contacttitle>" +"\n\t\t"
				+ "<organizationname> %s </organizationname>" +"\n\t\t"
				+ "<address> %s </address>"  +"\n\t\t"
				+ "<city> %s </city>"  +"\n\t\t"
				+ "<state> %s </state>"  +"\n\t\t"
				+ "<zipCode> %s </zipCode>"  +"\n\t\t"
				+ "</coverpersonal>\n", contactName,contactTitle, organizationName, address, city, state, zipCode);

	}
}
