
package abctexteditor.Files;


class FileFormatFactory {

    public FileFormatFactory() {
    }
    
    public IFileFormat getFileFormat(FileExtension fileExtension){
        IFileFormat choosenFormat = null;
        
        switch(fileExtension){
            case TXT:{
                choosenFormat = TXTFileFormat.getInstance();
            }
            break;
            
            case TABTXT:{
                choosenFormat = TABTXTFileFormat.getInstance();
            }
            break;
            
            case XML:{
                choosenFormat = XMLFileFormat.getInstance();
            }
            break;
            
            case JSON:{
                choosenFormat = JSONFileFormat.getInstance();
            }
            break;
            
            case PDF:{
                choosenFormat = FileFormatPDF.getInstance();
            }
            break;
            
            case CSV:{
                choosenFormat = FileFormatCsv.getInstance();
            }
            break;
        }
        
        
        return choosenFormat;
    }
}
