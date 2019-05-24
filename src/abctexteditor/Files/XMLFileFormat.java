
package abctexteditor.Files;

public class XMLFileFormat implements IFileFormat{

    public XMLFileFormat() {
    }

    
    @Override
    public String applyFormat(String fileContent) {
        String formattedText = "";
        formattedText = "<p>" + "\n" + fileContent + "\n" + "</p>" ;
        System.out.println("I apply XML format to the text before saving it");
        return formattedText;
    }

    @Override
    public String removeFormat(String fileContent) {
        String unformattedText = "";
        int firstPTagIndex = fileContent.indexOf(">");
        int lastPTagIndex = fileContent.lastIndexOf("<");
        unformattedText = fileContent.substring(firstPTagIndex + 1 , lastPTagIndex);
        unformattedText = unformattedText.replaceFirst("\n", "");
        
        System.out.println("I remove XML format to the text before it is opened");
        return unformattedText;
    }
    
}
