package vaqpack.model;

public class CoverLetterFields
{
	private String contactName;
	private String contactTitle;
	private String organziationName;
	private String address;
	private String city;
	private String state;
	private String zipCode;
	private String jobId;
	private String jobTitle;
	
	public CoverLetterFields(String contactName, String contactTitle,
			String organziationName, String address, String city, String state,
			String zipCode, String jobId, String jobTitle)
	{

		this.contactName = contactName;
		this.contactTitle = contactTitle;
		this.organziationName = organziationName;
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

	public String getOrganziationName()
	{
		return organziationName;
	}

	public void setOrganziationName(String organziationName)
	{
		this.organziationName = organziationName;
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
}
