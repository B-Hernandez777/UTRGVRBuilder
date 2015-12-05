package vaqpack.model.resume;

import java.io.Serializable;

public class Objective implements Serializable
{

	private static final long serialVersionUID = 1L;
	private String objective;

	public String getObjective()
	{
		return objective;
	}

	public void setObjective(String objective)
	{
		this.objective = objective;
	}

	public Objective(String objective)
	{
		this.objective = objective;
	}
	

	public String toString()
	{
		return String.format("\t<objective>" + "\n\t\t" 
				+ "<object> %s </object>\n\t"
				+ "</objective>\n", objective);
				
		
	}
}
