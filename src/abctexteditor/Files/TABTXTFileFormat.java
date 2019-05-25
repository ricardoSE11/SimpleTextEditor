
package abctexteditor.Files;

import abctexteditor.Utils.Paragraph;
import abctexteditor.Utils.StringHandler;
import java.util.ArrayList;


public class TABTXTFileFormat implements IFileFormat{

    private static IFileFormat singletonInstance = null;

    private TABTXTFileFormat() {
    }

    public static IFileFormat getInstance() {
        if (singletonInstance == null) {
            singletonInstance = new TABTXTFileFormat();
        }
        return singletonInstance;
    }
    
    
    @Override
    public String applyFormat(String fileContent) {
        String formattedText = "";
        ArrayList<Paragraph> paragraphs = StringHandler.getParagraphs(fileContent);
        for (Paragraph currentParagraph : paragraphs){
            formattedText += addTabsToText(currentParagraph) + "\n";
        }

        return formattedText;
    }

    @Override
    public String removeFormat(String fileContent) {
        String unformattedText = "";
        ArrayList<Paragraph> paragraphs = StringHandler.getParagraphs(fileContent);
        for (Paragraph currentParagraph : paragraphs) {
            unformattedText += removeTabsFromText(currentParagraph) + "\n";
        }
        return unformattedText;
    }
    
    
    public String addTabsToText(Paragraph paragraph){
        String tabbedText = "";
        String text = paragraph.getText();
        char[] characters = text.toCharArray();
        int characterCounter = 0;
        for (int i = 0; i < characters.length; i++) {
            // Because we start counting from zero
            if (characterCounter == 9) {
                tabbedText += characters[i];
                tabbedText += "\t";
                characterCounter = 0;
            } else {
                tabbedText += characters[i];
                characterCounter++;
            }
        }
        
        return tabbedText;
    }
    
    public String removeTabsFromText(Paragraph paragraph){
        String untabbedText = "";
        String text = paragraph.getText();
        char[] characters = text.toCharArray();
        int characterCounter = 0;
        for (int i = 0; i < characters.length; i++) {
            if (characterCounter == 10) {
                characterCounter = 0;
            } else {
                untabbedText += characters[i];
                characterCounter++;
            }
        }

        return untabbedText;
    }

    @Override
    public String applyColorFormat(String fileContent, ArrayList<ColorSetting> colors) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public String removeColorFormat(String fileContent, ArrayList<ColorSetting> colors) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
}
