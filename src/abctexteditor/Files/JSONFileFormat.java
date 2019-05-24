package abctexteditor.Files;

import abctexteditor.Utils.Paragraph;
import abctexteditor.Utils.StringHandler;
import java.util.ArrayList;


public class JSONFileFormat implements IFileFormat{

    private static IFileFormat singletonInstance = null;

    private JSONFileFormat() {
    }

    public static IFileFormat getInstance() {
        if (singletonInstance == null) {
            singletonInstance = new JSONFileFormat();
        }
        return singletonInstance;
    }
    
    @Override
    public String applyFormat(String fileContent) {
        String formattedText = "";
        ArrayList<Paragraph> paragraphs = StringHandler.getParagraphs(fileContent);
        formatParagraphs(paragraphs);
        formattedText = "{" + "\n";
        for (int i = 0 ; i < paragraphs.size() ; i++){
            formattedText += paragraphs.get(i).getText();
        }
        formattedText += "\n" + "}";
        return formattedText;
    }

    @Override
    public String removeFormat(String fileContent) {
        String unformattedText = "";
        fileContent = removeJSONBrackets(fileContent);
        ArrayList<Paragraph> paragraphs = StringHandler.getParagraphs(fileContent);
        unformatParagraphs(paragraphs);
        for (int i = 0 ; i < paragraphs.size() ; i++){
            unformattedText += paragraphs.get(i).getText();
        }
        System.out.println("I remove JSON format to the text before it is opened");
        return unformattedText;
    }
    
    
    // <editor-fold defaultstate="collapsed" desc="Formatting methods">
    
    /* Method that gets a Paragraph and return its lines modified as specified in the format
     * -> paragraph.text ... ["paragraph.text"]
     */
    public void paragraphToJSONArray(Paragraph paragraph , int paragraphID , boolean isLastParagraph){
        if (paragraph.getLines().size() == 1){
            simpleParagraphToJSONArray(paragraph, paragraphID, isLastParagraph);
        }
        else{
            System.out.println("Tengo mas diuna");
            for (int i = 0; i < paragraph.getLines().size(); i++) {
                if (i == 0) {
                    String paragraphIdentifier = "\"" + "p" + paragraphID + "\"" + ":";
                    String lineOne = paragraphIdentifier + "[" + "\"" + paragraph.getLines().get(i);
                    paragraph.getLines().remove(i);
                    paragraph.getLines().add(i, lineOne);
                }

                if (i == paragraph.getLines().size() - 1) {
                    String lastLine = paragraph.getLines().get(i);
                    lastLine += "\"" + "]";
                    if (!isLastParagraph) {
                        lastLine += "," + "\n";
                    }
                    paragraph.getLines().remove(i);
                    paragraph.addLine(lastLine);
                }
            }
        }

    }
    
    public void simpleParagraphToJSONArray(Paragraph paragraph , int paragraphID , boolean isLastParagraph){
        String paragraphIdentifier = "\"" + "p" + paragraphID + "\"" + ":";
        String modified = paragraph.getLines().get(0);
        String formattedText = paragraphIdentifier + "[" + "\"" + modified +  "\"" + "]";
        if (!isLastParagraph){
            formattedText += "," + "\n";
        }
        paragraph.getLines().remove(0);
        paragraph.addLine(formattedText);
    }
    
    public void formatParagraphs(ArrayList<Paragraph> paragraphs){
        for (int i = 0; i < paragraphs.size(); i++) {
            boolean isLastParagraph = i == (paragraphs.size() - 1);
            paragraphToJSONArray(paragraphs.get(i) , i , isLastParagraph);
        }
    }
    
    // </editor-fold>
    
    // <editor-fold defaultstate="collapsed" desc="Unformatting methods">
    public String removeJSONBrackets(String fileContent){
        String unformattedText = "";
        int firstBracketIndex = fileContent.indexOf("{");
        int lastBracketIndex = fileContent.lastIndexOf("}");
        unformattedText = fileContent.substring(firstBracketIndex + 1, lastBracketIndex);
        unformattedText = unformattedText.replaceFirst("\n", "");
        return unformattedText;
    }
    
    public void jsonArrayToParagraph(Paragraph paragraph){
        if (paragraph.getLines().size() == 177){
            simpleJSONArrayToParagraph(paragraph);
        }
        
        else{
            for (int i = 0; i < paragraph.getLines().size(); i++) {
                if (i == 0) {
                    String firstLine = paragraph.getLines().get(i);
                    int paragraphIdentifier = firstLine.indexOf(":");
                    String unformattedFirstLine = firstLine.substring(paragraphIdentifier + 3); // texto1"], 
                    paragraph.getLines().remove(i);
                    paragraph.getLines().add(i, unformattedFirstLine);
                }

                // If we are on the last line
                if (i == paragraph.getLines().size() - 1) {
                    String lastLine = paragraph.getLines().get(i);
                    int arrayClosingBracket = lastLine.lastIndexOf("\"");
                    String unformattedLastLine = lastLine.substring(0, arrayClosingBracket);
                    paragraph.getLines().remove(i);
                    paragraph.addLine(unformattedLastLine);
                }
            }
        }        
    }
    
    public void simpleJSONArrayToParagraph(Paragraph paragraph){
        String unformattedParagraph = "";
        String paragraphText = paragraph.getLines().get(0);
        int paragraphIdentifier = paragraphText.indexOf(":");
        int arrayClosingBracket = paragraphText.lastIndexOf("\"");
        unformattedParagraph = paragraphText.substring(paragraphIdentifier + 3, arrayClosingBracket);
        paragraph.getLines().remove(0);
        paragraph.addLine(unformattedParagraph);
    }
    
    public void unformatParagraphs(ArrayList<Paragraph> paragraphs){
        for (int i = 0; i < paragraphs.size(); i++) {
            jsonArrayToParagraph(paragraphs.get(i));
        }
    }
    
    // </editor-fold>

}
