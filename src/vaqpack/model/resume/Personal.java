package vaqpack.model.resume;

public class Personal
{
	private String firstName;
	private String lastName;
	private String phoneNumber;
	private String email;
	private String address;
	private String city;
	private String state;
	private String zipCode;
		
	public Personal(String firstName, String lastName, String phoneNumber, String address, String city, String state,
			String zipCode)
	{
		this.firstName = firstName;
		this.lastName = lastName;
		this.phoneNumber = phoneNumber;
		this.address = address;
		this.city = city;
		this.state = state;
		this.zipCode = zipCode;
	}
	
	
	
	public String getFirstName()
	{
		return firstName;
	}
	public void setFirstName(String firstName)
	{
		this.firstName = firstName;
	}
	public String getLastName()
	{
		return lastName;
	}
	public void setLastName(String lastName)
	{
		this.lastName = lastName;
	}
	public String getPhoneNumber()
	{
		return phoneNumber;
	}
	public void setPhoneNumber(String phoneNumber)
	{
		this.phoneNumber = phoneNumber;
	}
	public String getEmail()
	{
		return email;
	}
	public void setEmail(String email)
	{
		this.email = email;
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
	
	public String toString()
	{
		return String.format("\t<personal>"+ "\n\t\t"
				+ "<firstname> %s </firstname>" +"\n\t\t"
				+ "<lastname> %s </lastname>" +"\n\t\t"
				+ "<email> %s </email>" +"\n\t\t"
				+ "<address> %s </address>"  +"\n\t\t"
				+ "<city> %s </city>"  +"\n\t\t"
				+ "<state> %s </state>"  +"\n\t\t"
				+ "<zipCode> %s </state>"  +"\n\t\t"
				+ "<phone> %s </phone>"  +"\n\t"
				+ "</personal>\n", firstName,lastName, email, address, city, state, zipCode, phoneNumber);
	}
	
	

}
