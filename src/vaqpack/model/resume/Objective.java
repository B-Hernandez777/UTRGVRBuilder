package vaqpack.model.resume;

public class Objective
{
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
