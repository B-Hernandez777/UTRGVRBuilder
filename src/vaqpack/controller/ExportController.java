package vaqpack.controller;

import com.lowagie.text.DocumentException;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.PrintStream;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.ResourceBundle;

import javafx.animation.FadeTransition;
import javafx.animation.TranslateTransition;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.CheckBox;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.scene.layout.FlowPane;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;
import javafx.stage.FileChooser;
import javafx.util.Duration;
import vaqpack.model.CoverLetterFields;
import vaqpack.model.Export;
import static vaqpack.model.Export.combinePDFFiles;
import vaqpack.model.Singleton;
import vaqpack.model.WebsiteStyle;
import vaqpack.model.resume.ResumeStyle;

public class ExportController implements Initializable {

    @FXML
    FlowPane exportBackground;
    @FXML
    VBox exportCard;
    @FXML
    StackPane exportListCard;
    @FXML
    Button exportButton;
    @FXML
    CheckBox resumeCheckBox;
    @FXML
    CheckBox coverLetterCheckBox;
    @FXML
    CheckBox websiteCheckbox;
    @FXML
    CheckBox businesscardsCheckBox;
    @FXML
    Button saveLocation;

    @FXML
    Label message;
    @FXML
    ListView<WebsiteStyle> styleListView;

    private boolean expanded;

    @Override
    public void initialize(URL arg0, ResourceBundle arg1) {

        loadList();

    }

    private void loadList() {
        expanded = true;

        animateIn();
    }

    private void animateIn() {
        TranslateTransition tt = new TranslateTransition(Duration.millis(500),
                exportCard);
        FadeTransition ft1 = new FadeTransition(Duration.millis(1), exportCard);
        ft1.setFromValue(0);
        ft1.setToValue(1);
        ft1.play();
        tt.setFromX(400f);
        tt.setToX(0);
        tt.play();
    }

    @FXML
    public void saveLocation() {

        FileChooser fileChooser = new FileChooser();
        fileChooser.setTitle("Save file");
        fileChooser.setInitialFileName("resume.xml");
        File savedFile = fileChooser.showSaveDialog(null);
        //savedFile = fileChooser.getTitle().toString();
        //       setSavedFile(savedFile.toString());
        if (savedFile != null) {

        }

    }

    @FXML
    public void exportButtonClicked() throws FileNotFoundException, IOException {
        if (resumeCheckBox.isSelected()) 
        {
            	//based on personal test 
            //get the resume xml
            String xml = Singleton.getInstance().currentVaqpack().getResume().toString().replaceAll("[\\[\\],]", "");
            String XMLfile = Singleton.getInstance().currentVaqpack().getResume().getPersonal().getFirstName() + "resume.xml";
            String XLSfile = "resumestyle1.xsl";   //Singleton.getInstance().currentVaqpack().getResume().getStyle().getStyle();
            String HTMLfile = Singleton.getInstance().currentVaqpack().getResume().getPersonal().getFirstName() + "Website.html";
            ResumeStyle xhtml = new ResumeStyle(XMLfile, XLSfile, HTMLfile);
            String PdfName = Singleton.getInstance().currentVaqpack().getResume().getPersonal().getFirstName() + "Resume.pdf";
            Export pdf = new Export(xhtml.getHtmlName(), PdfName);

            saveXmlFile(XMLfile, xml);
//              xhtml.setXmlFile(XMLfile);
            xhtml.Converter(xhtml.getXmlFile(), xhtml.getXslFileName(), xhtml.getHtmlName());
            System.out.println(xml);
            pdf.convert2Pdf(pdf.getHtmlFileName(), pdf.getPdfFileName());
            System.out.println("Printed PDF");
            printMessage();
        }

            if (coverLetterCheckBox.isSelected()) 
            {
            	
                for (CoverLetterFields letter : Singleton.getInstance().currentVaqpack().getCoverLetter().getCoverLetterList()) {
                StringBuilder cover = new StringBuilder();
                cover.append("<coverletter>\n");
                cover.append(Singleton.getInstance().currentVaqpack().getCoverLetter().getPersonal());
                cover.append(letter);
                cover.append("\t<coverparagraphs>\n");
                cover.append(Singleton.getInstance().currentVaqpack().getCoverLetter().getParagraphList());
                cover.append("\t</coverparagraphs>\n");
                cover.append(String.format("\t<end>Sincerely, \n\t%s %s\n", Singleton.getInstance().currentVaqpack().getCoverLetter().getPersonal().getFirstName(), Singleton.getInstance().currentVaqpack().getCoverLetter().getPersonal().getLastName()));
                    cover.append("\t</end>\n");
                    cover.append("</coverletter>");

                    String XMLfile = letter.getOrganizationName() + ".xml";
                    String XLSfile = "CoverLetterStyle1.xsl";   
                    String HTMLfile = letter.getOrganizationName() + ".html";
                    //coverletters.add(cover.toString().replaceAll("[\\[\\],]", ""));
                    try (PrintStream out = new PrintStream(new FileOutputStream(XMLfile))) {
                        out.print(cover);
//        		    this will combine the cover letter and resume into one pdf so we can put this function
                        // when you check the cover letter export checkbox so we run cover letter through 
                    // xhtml.Converter (coverletter.xml, coverletter.xsl, coverletter.html(this one is hardcoded i believe)
                    // then we can run the pdf.conver2pdf ( coverletter.html, CoverLetter.pdf)
//            List<String> list = new ArrayList<String>();
//            
//            list.add("CoverLetter.pdf");
//            list.add("Resume.pdf");
//            try {
//                combinePDFFiles(list, "allinone.pdf");
//            } catch (FileNotFoundException e) {
//                e.printStackTrace();
//            } catch (DocumentException e) {
//                e.printStackTrace();
//            } catch (IOException e) {
//                e.printStackTrace();
//            }     
                   
                    
                    ResumeStyle xhtml = new ResumeStyle(XMLfile, XLSfile, HTMLfile);
                   
                    xhtml.Converter(xhtml.getXmlFile(), xhtml.getXslFileName(), xhtml.getHtmlName());
                    String PdfName = letter.getOrganizationName() + ".pdf";
                    Export pdf = new Export(xhtml.getHtmlName(), PdfName);
                   
                    pdf.convert2Pdf(pdf.getHtmlFileName(), pdf.getPdfFileName());
                    System.out.println("Printed PDF");
                    printMessage();

                }

            }
        }

    }

	private void printMessage()
	{
		TranslateTransition tt = new TranslateTransition(Duration.millis(500), message);
		FadeTransition ft1 = new FadeTransition(Duration.millis(500), message);
		FadeTransition ft2 = new FadeTransition(Duration.millis(750), message);
		ft2.setDelay(Duration.millis(1000));
		ft1.setFromValue(1);
		ft1.setToValue(0);
		ft1.setFromValue(0);
		ft1.setToValue(1);
		ft1.play();
		ft2.play();
		tt.setFromY(400f);
		tt.setToY(0);
		tt.play();
	}

    private void saveXmlFile(String fileName, String resume) throws IOException, FileNotFoundException {

        try (PrintStream out = new PrintStream(new FileOutputStream(fileName))) {
            out.print(resume);
        }
    }

}

