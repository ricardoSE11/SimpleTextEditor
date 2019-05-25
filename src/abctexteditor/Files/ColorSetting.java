/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package abctexteditor.Files;

/**
 *
 * @author ss
 */
//I know this is kind stupid, but it helps to save the text color
//configuration 
public class ColorSetting {
    //public because it has no big importance on the project 
    public int color;
    public int start;
    public int end;
    
    public ColorSetting(){
        
    }

    public ColorSetting(int color, int start, int end) {
        this.color = color;
        this.start = start;
        this.end = end;
    }
    
    @Override
    public String toString(){
        return "Color: "+ Integer.toString(color) + " Start: "+ Integer.toString(start)
            + " End: "+ Integer.toString(end);
    }
    
    public int getDifference(){
        return (end - start);
    }
    
    public int getStart(){
        return start;
    }
}
