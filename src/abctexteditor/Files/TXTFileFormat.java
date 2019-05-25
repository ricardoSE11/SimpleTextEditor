
package abctexteditor.Files;

import java.util.ArrayList;


public class TXTFileFormat implements IFileFormat {

    private static IFileFormat singletonInstance = null;

    private TXTFileFormat() {
    }
  
    public static IFileFormat getInstance() {
        if (singletonInstance == null){
            singletonInstance = new TXTFileFormat();
        }
        return singletonInstance;
    }
    
    @Override
    public String applyFormat(String fileContent) {
        return fileContent;
    }

    @Override
    public String removeFormat(String fileContent) {
        return fileContent;
    }

    
}
