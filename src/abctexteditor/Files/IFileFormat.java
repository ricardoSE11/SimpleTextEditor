
package abctexteditor.Files;



public interface IFileFormat {
    
    public String applyFormat(String fileContent);
    
    public String removeFormat(String fileContent);
    
}
