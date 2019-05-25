
package abctexteditor.Files;

import java.util.ArrayList;


public interface IFileFormat {
    
    public String applyFormat(String fileContent);
    
    public String removeFormat(String fileContent);
    
    public String applyColorFormat(String fileContent, ArrayList<ColorSetting> colors);
    
    public String removeColorFormat(String fileContent, ArrayList<ColorSetting> colors);
    
}
