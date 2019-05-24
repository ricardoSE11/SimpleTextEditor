
package abctexteditor.Utils;

import java.util.ArrayList;


public class Paragraph {
    
    private ArrayList<String> lines;

    public Paragraph() {
        lines = new ArrayList<>();
    }
    
    public Paragraph(ArrayList lines) {
        this.lines = lines;
    }

    public ArrayList<String> getLines() {
        return lines;
    }

    public void setLines(ArrayList<String> lines) {
        this.lines = lines;
    }
    
    public void addLine(String line){
        this.lines.add(line);
    }
    
    public boolean isEmpty(){
        return lines.isEmpty();
    }
    
    public String getText(){
        String text = "";
        for (String currentLine: lines){
            text += currentLine;  // + "\n" 
        }
        
        return text;
    }
    
    
    
}
