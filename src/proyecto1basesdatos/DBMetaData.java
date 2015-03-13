/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package proyecto1basesdatos;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.io.Serializable;
import java.io.Writer;
import java.util.ArrayList;

/**
 *
 * @author pablo
 */
public class DBMetaData implements Serializable {
    
    String nombreDB;
    ArrayList<TablaMetaData> tablas;
     
    public DBMetaData(String nombreDB){
        this.nombreDB=nombreDB;
        tablas = new ArrayList<TablaMetaData>();
    
    }
     
     
    public void writeMetadata(File f){
        
    
    }

}
