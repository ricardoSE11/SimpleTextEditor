
package abctexteditor.Files;


public class TXTFileFormat implements IFileFormat {

    private static IFileFormat singletonInstance = null;
    
    @Override
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
