/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package vaqpack.model;

import com.lowagie.text.Document;
import com.lowagie.text.DocumentException;
import com.lowagie.text.pdf.PdfContentByte;
import com.lowagie.text.pdf.PdfImportedPage;
import com.lowagie.text.pdf.PdfReader;
import com.lowagie.text.pdf.PdfWriter;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.io.Serializable;
import java.util.List;

import org.xhtmlrenderer.pdf.ITextRenderer;

/**
 *
 * @author Aerodrain
 */
@SuppressWarnings("serial")
public class Export implements Serializable {

    private String htmlFileName;
    private String pdfFileName;

    public Export(String htmlFileName, String pdfFileName) {
        this.htmlFileName = htmlFileName;
        this.pdfFileName = pdfFileName;
    }

    public String getHtmlFileName() {
        return htmlFileName;
    }

    public void setHtmlFileName(String htmlFileName) {
        this.htmlFileName = htmlFileName;
    }

    public String getPdfFileName() {
        return pdfFileName;
    }

    public void setPdfFileName(String pdfFileName) {
        this.pdfFileName = pdfFileName;
    }

    public String convert2Pdf(String htmlFileName, String pdfFileName) {
        try {
            File Htmlfile = new File(htmlFileName);

//            if (Htmlfile.exists())
//            {
//                Htmlfile.delete();
//                System.out.println("File deleted and remade");
//            }
            String url = Htmlfile.toURI().toURL().toString();

            OutputStream os = new FileOutputStream(pdfFileName);
            ITextRenderer renderer = new ITextRenderer();
            renderer.setDocument(url);
            renderer.layout();
            renderer.createPDF(os);
            os.close();
        } catch (DocumentException e) {
            System.out.println("Error in the html to pdf converter");
        } catch (IOException e) {
            System.out.println("Error in the html to pdf converter");
        } catch (Exception e) {
            System.out.println("Error in the html to pdf converter");
        }
        return pdfFileName;
    }
    public static void combinePDFFiles(List<String> list, String outName) throws DocumentException, IOException 
    {
        OutputStream out=null;
        Document document=null;
        PdfWriter writer =null;
        FileInputStream in=null;
        try {
            // Resulting pdf
             out = new FileOutputStream(new File(outName));
             document = new Document();
             writer = PdfWriter.getInstance(document, out);
            document.open();
            PdfContentByte cb = writer.getDirectContent();
            for (String inFile : list) {
                in = new FileInputStream(new File(inFile));
                PdfReader reader = new PdfReader(in);
                for (int i = 1; i <= reader.getNumberOfPages(); i++) {
                    document.newPage();
                    //import the page from source pdf
                    PdfImportedPage page = writer.getImportedPage(reader, i);
                    //add the page to the destination pdf
                    cb.addTemplate(page, 0, 0);
                }
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (DocumentException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        finally
        {
            out.flush();
            document.close();
            out.close();
            in.close();
        }

    }

}
