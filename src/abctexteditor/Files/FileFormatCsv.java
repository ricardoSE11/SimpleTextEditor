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
import java.util.ArrayList;
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
        
        impresion = fileContent.replaceAll(" ", ";");
        return impresion;
    }

    @Override
    public String removeFormat(String fileContent) {
    impresion="";
    impresion = fileContent.replaceAll(";"," ");
    return impresion;
    }

}
