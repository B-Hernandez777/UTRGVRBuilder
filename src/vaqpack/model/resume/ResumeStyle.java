package vaqpack.model.resume;

import java.io.FileOutputStream;
import java.io.Serializable;
import javax.xml.transform.OutputKeys;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.stream.StreamResult;
import javax.xml.transform.stream.StreamSource;

public class ResumeStyle implements Serializable {

    private static final long serialVersionUID = 1L;
    private String style;
    private String XmlFile;

    public String getXmlFile() {
        return XmlFile;
    }

    public void setXmlFile(String XmlFile) {
        this.XmlFile = XmlFile;
    }
    private String xslFileName;
    private String xslFileName2;
    private String xslFileName3;
    private String HtmlName;

    public ResumeStyle(String Xmlfile, String Xslfile, String Htmlfile) {
        this.xslFileName = Xslfile;
        this.HtmlName = Htmlfile;
        this.XmlFile = Xmlfile;
    }

    public String getHtmlName() {
        return HtmlName;
    }

    public void setHtmlName(String HtmlName) {
        this.HtmlName = HtmlName;
    }

    public String getXslFileName2() {
        return xslFileName2;
    }

    public void setXslFileName2(String xslFileName2) {
        this.xslFileName2 = xslFileName2;
    }

    public String getXslFileName3() {
        return xslFileName3;
    }

    public void setXslFileName3(String xslFileName3) {
        this.xslFileName3 = xslFileName3;
    }

    public String getXslFileName() {
        return xslFileName;
    }

    public void setXslFileName(String xslFileName) {
        this.xslFileName = xslFileName;
    }

    public ResumeStyle(String style) {
        this.style = style;
    }

    public ResumeStyle(String style, String xslFile) {
        this.xslFileName = xslFile;
    }

    public String getStyle() {
        return style;
    }

    public void setStyle(String style) {
        this.style = style;
    }

    public String toString() {
        return style;
    }

    public String Converter(String XmlFile, String XslFile, String HtmlName) {

        try {
             TransformerFactory tFactory = TransformerFactory.newInstance();
            Transformer transformer = 
                    tFactory.newTransformer(new javax.xml.transform.stream.StreamSource(XslFile));
            
            transformer.transform(new javax.xml.transform.stream.StreamSource(XmlFile),
                new javax.xml.transform.stream.StreamResult(new FileOutputStream(HtmlName)));
        } catch (Exception e) {
        }
        return HtmlName;
    }
    
}
