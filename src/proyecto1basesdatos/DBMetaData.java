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
import java.io.PrintWriter;
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
    public ArrayList<TablaMetaData> tablas;
     
    public DBMetaData(String nombreDB){
        this.nombreDB=nombreDB;
        tablas = new ArrayList<TablaMetaData>();
    
    }
     
    public ArrayList<String> allTables()
    {
        ArrayList<String> toReturn = new ArrayList<String>();
        for(TablaMetaData t: this.tablas){
            toReturn.add(t.nombre);
        }
        return toReturn;
    }
    @Override
    public String toString(){
        String s ="Base de Datos: "+nombreDB+"\n\r";
        s+="Numero Tablas: "+tablas.size()+"\n\r";
       
        return s;
    
    }
     
    public void writeMetadata(){
        Writer writer = null;
        String currentDir = System.getProperty("user.dir");
        try {
            //Borramos la data anterior
            PrintWriter writer1 = new PrintWriter(new OutputStreamWriter(
            new FileOutputStream(currentDir+"/DBMS/"+nombreDB+"/"+nombreDB+".dat"), "utf-8"));
            writer1.print("");
            writer1.close();  
            //Escribimos la nueva data
            writer = new BufferedWriter(new OutputStreamWriter(
            new FileOutputStream(currentDir+"/DBMS/"+nombreDB+"/"+nombreDB+".dat"), "utf-8"));
            
            String out = this.toString()+"\n\r";
            for(TablaMetaData d: tablas){
                out+=d.toString();
        
            } 
            writer.write(out);
        } catch (IOException ex) {
          System.out.println("Error WriteMetadata DB");
        } finally {
           try {writer.close();} catch (Exception ex) {}
        }        
        //Escribimos cada uno de las tablas
       
    
    }
    
    public TablaMetaData findTable(String s){
        for(TablaMetaData t: this.tablas){
            if(t.nombre.equalsIgnoreCase(s)){
                return t;
            
            }
        }
        return null;
    
    }

}
