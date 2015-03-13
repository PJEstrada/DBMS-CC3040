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
    private static final long serialVersionUID = 6529685098267757693L;
    String nombreDB;
    ArrayList<TablaMetaData> tablas;
     
    public DBMetaData(String nombreDB){
        this.nombreDB=nombreDB;
        tablas = new ArrayList<TablaMetaData>();
    
    }
     
    @Override
    public String toString(){
        String s ="Base de Datos: "+nombreDB+"\n\r";
        s+="Numero Tablas: "+tablas.size();
        for(TablaMetaData t: tablas){
            s+=t.toString()+"\n\r \n\r";
        
        }
        return s;
    
    }
     
    public void writeMetadata(){
        Writer writer = null;
        String currentDir = System.getProperty("user.dir");
        try {
            writer = new BufferedWriter(new OutputStreamWriter(
            new FileOutputStream(currentDir+"/DBMS/"+nombreDB+"/"+nombreDB+".dat"), "utf-8"));
            writer.write(this.toString());
        } catch (IOException ex) {
          System.out.println("Error WriteMetadata DB");
        } finally {
           try {writer.close();} catch (Exception ex) {}
        }        
        
    
    }

}
