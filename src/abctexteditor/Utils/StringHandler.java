
package abctexteditor.Utils;

import java.util.ArrayList;


public class StringHandler {
    
    public static ArrayList<Paragraph> getParagraphs(String text){
        ArrayList<Paragraph> paragraphs = new ArrayList<>();
        Paragraph currentParagraph = new Paragraph();
        String[] lines = text.split("\n");
        for (int i = 0; i < lines.length; i++) {
            // This indicates the end of a paragraph
            if (lines[i].trim().isEmpty()) {
                if (!currentParagraph.isEmpty()){
                    paragraphs.add(currentParagraph);
                    currentParagraph = new Paragraph(); // Create a new Paragraph 
                }
            } else {
                currentParagraph.addLine(lines[i]);
            }
        }
        // At the end
        if (!currentParagraph.isEmpty()){
            paragraphs.add(currentParagraph);
        }
        
        return paragraphs;
    }
}
