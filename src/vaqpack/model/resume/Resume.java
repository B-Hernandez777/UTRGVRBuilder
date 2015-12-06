package vaqpack.model.resume;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Arrays;

import javafx.collections.ObservableList;

public class Resume implements Serializable
{
	private static final long serialVersionUID = 1L;
	
	private Personal personal;
	private Objective objective;
    private ArrayList<Experience> experienceList;
    private ArrayList<Education> educationList;
    private ArrayList<Achievement> achievementList;
    private ArrayList<Skill> skillList;
    private ResumeStyle style;
    
    public Resume(String name)
	{
	}



	public Personal getPersonal()
	{
		return personal;
	}


	public void setPersonal(Personal personal)
	{
		this.personal = personal;
	}


	public Objective getObjective()
	{
		return objective;
	}


	public void setObjective(Objective objective)
	{
		this.objective = objective;
	}
	
	public String toString()
	{
		return String.format("<resume>" + "\n%s%s\t"
				+ "<experience>\n%s\t</experience>\n\t"
				+ "<education>\n%s\t</education>\n\t"
				+ "<achievement>\n%s\t</achievement>\n\t"
				+ "<skill>\n%s\t</skill>\n"
				+ "</resume>"
				,personal, objective, getExperienceList(), getEducationList(), getAchievementList(), getSkillList() );
	}

	public ResumeStyle getStyle()
	{
		return style;
	}


	public void setStyle(ResumeStyle style)
	{
		this.style = style;
	}

	public ArrayList<Experience> getExperienceList()
	{
		return experienceList;
	}


	public void setExperienceList(ArrayList<Experience> experienceList)
	{
		this.experienceList = experienceList;
	}


	public ArrayList<Education> getEducationList()
	{
		return educationList;
	}

	public void setEducationList(ArrayList<Education> educationList)
	{
		this.educationList = educationList;
	}



	public ArrayList<Achievement> getAchievementList()
	{
		return achievementList;
	}



	public void setAchievementList(ArrayList<Achievement> achievementList)
	{
		this.achievementList = achievementList;
	}



	public ArrayList<Skill> getSkillList()
	{
		return skillList;
	}

	public void setSkillList(ArrayList<Skill> skillList)
	{
		this.skillList = skillList;
	}
}
