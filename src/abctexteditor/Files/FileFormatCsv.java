/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package abctexteditor.Files;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.PrintWriter;
import java.io.UnsupportedEncodingException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author juanj
 */
public class FileFormatCsv implements IFileFormat{
    private String impresion;
    private static PrintWriter writer; 
    
    private static FileFormatCsv instance;
    
    public static IFileFormat getInstance() {
        if(instance == null){
            instance = new FileFormatCsv();
        }
        return instance;
    }
    @Override
    public String applyFormat(String fileContent) {
        //try {
            impresion = fileContent.replaceAll(" ", ";");
            /*writer = new PrintWriter("ArchivoCsv.csv", "UTF-8");
            writer.print(impresion);
            writer.close();
        } catch (FileNotFoundException ex) {
            Logger.getLogger(FileFormatCsv.class.getName()).log(Level.SEVERE, null, ex);
        } catch (UnsupportedEncodingException ex) {
            Logger.getLogger(FileFormatCsv.class.getName()).log(Level.SEVERE, null, ex);
        }*/
        return impresion;
    }

    @Override
    public String removeFormat(String fileContent) {
    /*try (BufferedReader br = new BufferedReader(new FileReader("ArchivoCsv.csv"))) {*/
    impresion="";/*
        String line;
        while ((line = br.readLine()) != null) {
            impresion+=line;
        }*/
    impresion = impresion.replaceAll(";"," ");/*
        }catch (FileNotFoundException ex) {
            Logger.getLogger(FileFormatCsv.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(FileFormatCsv.class.getName()).log(Level.SEVERE, null, ex);
        }*/
    return impresion;
    }
}
