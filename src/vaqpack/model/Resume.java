package vaqpack.model;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

public class Resume
{
	private String name;
	private int  id;
	private CoverLetter coverLetter;
    private ObservableList<Experience> experienceList = FXCollections.observableArrayList(new Experience("Job1"), new Experience("Job2"), new Experience("Job3"));
    private ObservableList<Education> educationList = FXCollections.observableArrayList(new Education("MIT", "Masters in Science", "Boston", "Ma", 4.0, null, null));
    private ObservableList<Achievement> achivementList = FXCollections.observableArrayList(new Achievement("Presidents List"),new Achievement("Medal of Honor"));
    private ObservableList<Skill> skillList = FXCollections.observableArrayList(new Skill("Can heat ramen in under a minute"),new Skill("Fastest cook at McDonalds"));
	
    
    public Resume(String name)
	{
		this.name = name;
		id = 1;
	}
	
	
	
	public String getName()
	{
		return name;
	}



	public void setName(String name)
	{
		this.name = name;
	}



	public int getId()
	{
		return id;
	}



	public void setId(int id)
	{
		this.id = id;
	}



	@Override
	public String toString()
	{
		return name + id;
	}



	public CoverLetter getCoverLetter()
	{
		return coverLetter;
	}



	public void setCoverLetter(CoverLetter coverLetter)
	{
		this.coverLetter = coverLetter;
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
}
