package abctexteditor.Files;

import java.io.FileOutputStream;
 
import com.itextpdf.text.Document;
import com.itextpdf.text.Font;
import com.itextpdf.text.FontFactory;
import com.itextpdf.text.Paragraph;
import com.itextpdf.text.pdf.CMYKColor;
import com.itextpdf.text.pdf.PdfWriter;
import java.util.ArrayList;


/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author juanj
 */
public class FileFormatPDF implements IFileFormat{
    
    private static FileFormatPDF instance;
    

    public static IFileFormat getInstance() {
        if(instance == null){
            instance = new FileFormatPDF();
        }
        return instance;
    }
    
    
    @Override
    public String applyFormat(String fileContent) {
        Font blueFont = FontFactory.getFont(FontFactory.HELVETICA, 8, Font.NORMAL, new CMYKColor(255, 0, 0, 0));
        Font redFont = FontFactory.getFont(FontFactory.COURIER, 12, Font.BOLD, new CMYKColor(0, 255, 0, 0));
        Font yellowFont = FontFactory.getFont(FontFactory.COURIER, 14, Font.BOLD, new CMYKColor(0, 0, 255, 0));
        Document document = new Document();
        try
        {
            PdfWriter writer = PdfWriter.getInstance(document, new FileOutputStream("Documento.pdf"));
            document.open();
            document.add(new Paragraph(fileContent));

            /*//Paragraph with color and font styles
            Paragraph paragraphOne = new Paragraph("Some colored paragraph text", redFont);
            document.add(paragraphOne);

            //Create chapter and sections
            Paragraph chapterTitle = new Paragraph("Chapter Title", yellowFont);
            Chapter chapter1 = new Chapter(chapterTitle, 1);
            chapter1.setNumberDepth(0);

            Paragraph sectionTitle = new Paragraph("Section Title", redFont);
            Section section1 = chapter1.addSection(sectionTitle);

            Paragraph sectionContent = new Paragraph("Section Text content", blueFont);
            section1.add(sectionContent);

            document.add(chapter1);*/            

            document.close();
            writer.close();
        } catch (Exception e)
        {
            e.printStackTrace();
        }
      return fileContent;
    }

    @Override
    public String removeFormat(String fileContent) {
        return fileContent;
    }

    
}
