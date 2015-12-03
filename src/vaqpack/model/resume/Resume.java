package vaqpack.model.resume;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

public class Resume
{
	private Personal personal;
	private Objective objective;
    private ObservableList<Experience> experienceList = FXCollections.observableArrayList(new Experience("Job1"), new Experience("Job2"), new Experience("Job3"));
    private ObservableList<Education> educationList = FXCollections.observableArrayList(new Education("MIT", "Masters in Science", "Boston", "Ma", 4.0, null, null));
    private ObservableList<Achievement> achivementList = FXCollections.observableArrayList(new Achievement("Presidents List"),new Achievement("Medal of Honor"));
    private ObservableList<Skill> skillList = FXCollections.observableArrayList(new Skill("Can heat ramen in under a minute"),new Skill("Fastest cook at McDonalds"));
	
    
    public Resume(String name)
	{
	}

		
	public ObservableList<Experience> getExperienceList()
	{
		return experienceList;
	}

	public void setExperienceList(ObservableList<Experience> experienceList)
	{
		this.experienceList = experienceList;
	}

	public ObservableList<Education> geteducationList()
	{
		return educationList;
	}

	public ObservableList<Achievement> getAchivementList()
	{
		return achivementList;
	}

	public void setAchivementList(ObservableList<Achievement> achivementList)
	{
		this.achivementList = achivementList;
	}

	public ObservableList<Skill> getSkillList()
	{
		return skillList;
	}

	public void setSkillList(ObservableList<Skill> skillList)
	{
		this.skillList = skillList;
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
		
		
		return String.format("<resume>" + "/n%s%s"
				+ "/t<experience> %s </experience>/n"
				+ "</resume>"
				,personal, objective, experienceList );
	}
}
