package vaqpack.Tests;

import javafx.collections.ObservableList;
import vaqpack.model.resume.Context;
import vaqpack.model.resume.Experience;
import vaqpack.model.resume.Objective;
import vaqpack.model.resume.Personal;
import vaqpack.model.resume.Resume;

public class PersonalTest
{

	
	public static void main(String[] args)
	{
		Resume resume = new Resume("");
		Personal personal = new Personal ("aName", "aLastname", "(956)555-5555", "1234 drive" , "Brownsville", "Texas", "78520");
		resume.setPersonal(personal);
		
		Objective objective = new Objective("This will be the test Objective for my fake job ");
		resume.setObjective(objective);
		
		 ObservableList<Experience> experienceList = Context.getInstance().currentResume().getExperienceList();
		 resume.setExperienceList(experienceList);
		
		//System.out.print(resume.getPersonal());
		//System.out.print(resume.getObjective());
		//System.out.print(resume.getExperienceList());
		
		
		String xml = resume.toString().replaceAll("[\\[\\],]","");

		
		System.out.println(xml);
		
	}
}
