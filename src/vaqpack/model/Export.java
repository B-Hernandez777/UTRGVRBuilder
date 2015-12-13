/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package vaqpack.model;

import com.lowagie.text.DocumentException;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.io.Serializable;

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

}
