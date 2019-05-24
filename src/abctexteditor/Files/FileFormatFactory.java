
package abctexteditor.Files;


class FileFormatFactory {

    public FileFormatFactory() {
    }
    
    public IFileFormat getFileFormat(FileExtension fileExtension){
        IFileFormat choosenFormat = null;
        
        switch(fileExtension){
            case TXT:{
                System.out.println("");
            }
            break;
            
            case XML:{
                choosenFormat = new XMLFileFormat();
            }
            break;
            
            case JSON:{
                choosenFormat = new JSONFileFormat();
            }
            break;
        }
        
        
        return choosenFormat;
    }
}
