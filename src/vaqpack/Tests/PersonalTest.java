package vaqpack.Tests;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;

import javafx.collections.ObservableList;
import vaqpack.model.Vaqpack;
import vaqpack.model.resume.Achievement;
import vaqpack.model.resume.Context;
import vaqpack.model.resume.Education;
import vaqpack.model.resume.Experience;
import vaqpack.model.resume.Objective;
import vaqpack.model.resume.Personal;
import vaqpack.model.resume.Resume;
import vaqpack.model.resume.Skill;

public class PersonalTest
{
	private static Resume resume;
	static Vaqpack vaqpack;
	
	private static void saveFile() throws IOException, FileNotFoundException
	{

		System.out.println("Save Button pressed");
		try(ObjectOutputStream output = new ObjectOutputStream( new FileOutputStream("1.dat", false));)
			{
				output.writeObject(vaqpack);
			}
		System.out.println("Saved Successfully");

	}

	
	public static void main(String[] args) throws FileNotFoundException, IOException, SQLException
	{
		
		 vaqpack = new Vaqpack();
		
		
		resume = new Resume("");
		Personal personal = new Personal ("aName", "aLastname", "(956)555-5555", "1234 drive" , "Brownsville", "Texas", "78520");
		resume.setPersonal(personal);
		
		Objective objective = new Objective("This will be the test Objective for my fake job ");
		resume.setObjective(objective);
		
		 ArrayList<Experience> experienceList = Context.getInstance().currentResume().getExperienceList();
		 resume.setExperienceList((ArrayList<Experience>) experienceList);
		 ArrayList<Education> educationList = new ArrayList<Education>();
		 educationList.add(new Education("MIT", "Masters in Science", "Boston", "Ma", 4.0, null, null));
		 resume.setEducationList(educationList);
		 
		 ArrayList<Achievement> achievementList = new ArrayList<Achievement>();
		 achievementList.add(new Achievement("Presidents List"));
		 achievementList.add(new Achievement("Medal of Honor"));
//		 
		 
		 ArrayList<Skill> skillList = new ArrayList<Skill>();
		skillList.add(new Skill("Can heat ramen in under a minute"));
		skillList.add(new Skill("Fastest cook at McDonalds"));
		 resume.setAchievementList(achievementList);
//		 
		 resume.setSkillList(skillList);
//		 
		//System.out.print(resume.getPersonal());
		//System.out.print(resume.getObjective());
		//System.out.print(resume.getExperienceList());
		//System.out.println(resume.getEducationList());
		// System.out.println(resume.getAchivementList());
		//System.out.println(resume.getSkillList());
		
		//String xml = resume.toString().replaceAll("[\\[\\],]","");
		
		vaqpack.setResume(resume);
		new SQL().updateDB(vaqpack);
		saveFile();
		
		//System.out.println(xml);
		
	}
}
