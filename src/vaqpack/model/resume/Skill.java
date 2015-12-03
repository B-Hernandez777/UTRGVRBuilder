package vaqpack.model.resume;

public class Skill
{
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
