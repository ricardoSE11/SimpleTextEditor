
package abctexteditor.Files;


public class FileFormatter {
    
    FileFormatFactory fileFormatFactory;

    public FileFormatter() {
        fileFormatFactory = new FileFormatFactory();
    }
    
    public String formatFile(String fileContent, FileExtension fileExtension) {
        IFileFormat choosenFileFormat = fileFormatFactory.getFileFormat(fileExtension);
        String formattedContent = choosenFileFormat.applyFormat(fileContent);
        return formattedContent;
    }
    
    public String unformatFile(String fileContent, FileExtension fileExtension) {
        IFileFormat choosenFileFormat = fileFormatFactory.getFileFormat(fileExtension);
        String unformattedFile = choosenFileFormat.removeFormat(fileContent);
        return unformattedFile;
    }
}
