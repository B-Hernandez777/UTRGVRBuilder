package vaqpack.model.resume;

public class Achievement
{
	
	private String name;
	private String description;
	public Achievement(String name)
	{
		this.name = name;
	}

	public String getName()
	{
		return name;
	}

	public void setName(String name)
	{
		this.name = name;
	}
	

	public String getDescription()
	{
		return description;
	}

	public void setDescription(String description)
	{
		this.description = description;
	}

	public String toString()
	{
		return String.format("\t\t<a>"+"\n\t\t\t"
				+ "<achieve> %s </achieve>" + "\n\t\t\t"
				+ "<achievedescription> %s </achievedescription>" + "\n\t\t"
				+ "</a>\n", name, description);
	}
	
	

}
