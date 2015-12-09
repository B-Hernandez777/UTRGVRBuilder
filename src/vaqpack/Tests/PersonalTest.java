package vaqpack.Tests;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.io.PrintStream;
import java.sql.SQLException;
import java.util.ArrayList;

import vaqpack.model.CoverLetter;
import vaqpack.model.CoverLetterFields;
import vaqpack.model.Paragraph;
import vaqpack.model.Vaqpack;
import vaqpack.model.resume.Achievement;
import vaqpack.model.resume.Context;
import vaqpack.model.resume.Education;
import vaqpack.model.resume.Experience;
import vaqpack.model.resume.Objective;
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
	
	private static void saveXmlFile() throws IOException, FileNotFoundException
	{

		
	
		try (PrintStream out = new PrintStream(new FileOutputStream("resume.xml"))) {
		    out.print(resume);
		}

	}

	
	public static void main(String[] args) throws FileNotFoundException, IOException, SQLException
	{
		
		 vaqpack = new Vaqpack("persona@hotmail.com");
		
		
		resume = new Resume("person@hotmail.com");
		//Personal personal = new Personal ("aName", "aLastname", "(956)555-5555", resume.getPersonal().getEmail(), "1234 drive" , "Brownsville", "Texas", "78520");
		//resume.setPersonal(personal);
		
		Objective objective = new Objective("This will be the test Objective for my fake job ");
		resume.setObjective(objective);
		
		 ArrayList<Experience> experienceList = Context.getInstance().currentResume().getExperienceList();
		 resume.setExperienceList((ArrayList<Experience>) experienceList);
		 
		 ArrayList<Education> educationList = new ArrayList<Education>();
		 educationList.add(new Education("MIT", "Masters in Science", "Boston", "Massachusetts", "4.0", null, null));
		 resume.setEducationList(educationList);
		 
		 ArrayList<Achievement> achievementList = new ArrayList<Achievement>();
		 achievementList.add(new Achievement("Presidents List"));
		 achievementList.add(new Achievement("Medal of Honor"));	 
		 
		 ArrayList<Skill> skillList = new ArrayList<Skill>();
		skillList.add(new Skill("Can heat ramen in under a minute"));
		skillList.add(new Skill("Fastest cook at McDonalds"));
		 resume.setAchievementList(achievementList);
	 
		 resume.setSkillList(skillList);
		 
		 CoverLetter coverLetter = new CoverLetter();
		 
		 CoverLetterFields fields = new CoverLetterFields("Person", "Recruiter", "google", "3847 Dr", "Richmond", "California", "78555", "2F3adr", "Software Developer");
		 ArrayList<CoverLetterFields> fieldsList = new ArrayList<CoverLetterFields>();
		 fieldsList.add(fields);
		 coverLetter.setCoverLetterList(fieldsList);
		 
		 Paragraph paragraph = new Paragraph("laskdjflkasjd;fka"); 
		 ArrayList<Paragraph> paragraphList = new ArrayList<Paragraph>();
		 paragraphList.add(paragraph);
		 coverLetter.setParagraphList(paragraphList);
		 
		 vaqpack.setCoverLetter(coverLetter);
	 
		//System.out.print(resume.getPersonal());
		//System.out.print(resume.getObjective());
		//System.out.print(resume.getExperienceList());
		//System.out.println(resume.getEducationList());
		// System.out.println(resume.getAchivementList());
		//System.out.println(resume.getSkillList());
		
		String xml = resume.toString().replaceAll("[\\[\\],]","");
		
		vaqpack.setResume(resume);
		//new SQL().updateDB(vaqpack);
		saveXmlFile();
		
		System.out.println(xml);
		
	}
}
