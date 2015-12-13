package vaqpack.Tests;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.PrintStream;
import java.sql.SQLException;
import java.util.ArrayList;

import vaqpack.model.CoverLetter;
import vaqpack.model.CoverLetterFields;
import vaqpack.model.Export;
import vaqpack.model.Paragraph;
import vaqpack.model.Vaqpack;
import vaqpack.model.resume.Personal;
import vaqpack.model.resume.Resume;
import vaqpack.model.resume.ResumeStyle;

public class CoverLetterTest {

    private static Resume resume;
    static Vaqpack vaqpack;
    static String XMLfile = "resume.xml";
    static String XLSfile = "resumestyle1.xsl";
    static String HTMLfile = "ResumeWebPage.html";
    static String PdfName = "Resume.pdf";
    
    private static ResumeStyle xhtml = new ResumeStyle(XMLfile, XLSfile, HTMLfile);
    private static Export pdf = new Export(xhtml.getHtmlName(), PdfName);
 
    @SuppressWarnings("unused")
	private static void saveXmlFile() throws IOException, FileNotFoundException {

        try (PrintStream out = new PrintStream(new FileOutputStream(XMLfile))) {
            out.print(resume);
        }

    }

    public static void main(String[] args) throws FileNotFoundException, IOException, SQLException {

        vaqpack = new Vaqpack("persona@hotmail.com");
        resume = new Resume("person@hotmail.com");
        Personal personal = new Personal("aName", "aLastname", "(956)555-5555", resume.getPersonal().getEmail(), "1234 drive", "Brownsville", "Texas", "78520");
        resume.setPersonal(personal);
        CoverLetter coverLetter = new CoverLetter();
        ArrayList<CoverLetterFields> fieldsList = new ArrayList<CoverLetterFields>();
        fieldsList.add(new CoverLetterFields("Person", "Recruiter", "google", "3847 Dr", "Richmond", "California", "78555", "2F3adr", "Software Developer"));
        fieldsList.add(new CoverLetterFields("Person2", "Recruiter", "apple", "123 street", "Austin", "Texas", "78555", "2F3adr", "Software Developer"));
        fieldsList.add(new CoverLetterFields("Person3", "Recruiter", "microsoft", "654 ave", "Redmund", "Washington", "78555", "2F3adr", "Software Developer"));
        coverLetter.setCoverLetterList(fieldsList);

        ArrayList<Paragraph> paragraphList = new ArrayList<Paragraph>();
        paragraphList.add(new Paragraph("laskdjflsdfsdfkasjd;fka"));
        paragraphList.add(new Paragraph("sdfsdfasdfdfsdfslk;fka"));
        paragraphList.add(new Paragraph("qwerwerweasdffadfasdfsdfasdf;fka"));
        coverLetter.setParagraphList(paragraphList);
        coverLetter.setPersonal(vaqpack.getResume().getPersonal());
        vaqpack.setCoverLetter(coverLetter);
        vaqpack.getCoverLetter().setPersonal(personal);
        
        ArrayList <String> coverletters = new ArrayList<String>();
        for (CoverLetterFields letter : vaqpack.getCoverLetter().getCoverLetterList())
		{
			StringBuilder cover = new StringBuilder();
			cover.append("<coverletter>\n");
			cover.append(vaqpack.getCoverLetter().getPersonal());
			cover.append(letter);
                        cover.append("\t<coverparagraphs>\n");
			cover.append(vaqpack.getCoverLetter().getParagraphList());
                        cover.append("\t</coverparagraphs>\n");
			cover.append(String.format("\t<end>Sincerely, \n\t%s %s\n",vaqpack.getCoverLetter().getPersonal().getFirstName(), vaqpack.getCoverLetter().getPersonal().getLastName()));
			cover.append("\t</end>\n");
			cover.append("</coverletter>");
			coverletters.add(cover.toString().replaceAll("[\\[\\],]", ""));
			
			 try (PrintStream out = new PrintStream(new FileOutputStream(letter.getOrganizationName()+".xml" ))) {
		            out.print(cover);
		}
        
        System.out.println(coverletters);
        String xml = resume.toString().replaceAll("[\\[\\],]", "");
        //need the xml file name?
        vaqpack.setResume(resume);
 
    }
    }
}
