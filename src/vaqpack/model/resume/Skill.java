package vaqpack.model.resume;

import java.io.Serializable;

public class Skill implements Serializable
{
	
	private static final long serialVersionUID = 1L;
	private String skill;
	

	public Skill(String skill)
	{
		this.skill = skill;
	}

	public String getSkill()
	{
		return skill;
	}

	public void setSkill(String skill)
	{
		this.skill = skill;
	}
	
	public String toString()
	{
		return String.format("\t\t<s>"+"\n\t\t\t"
				+ "<skilltype> %s </skilltype>" + "\n\t\t"
				+ "</s>\n", skill);
	}

}
