
package abctexteditor.Files;


public class TXTFileFormat implements IFileFormat {

    @Override
    public String applyFormat(String fileContent) {
        return fileContent;
    }

    @Override
    public String removeFormat(String fileContent) {
        return fileContent;
    }
    
}
