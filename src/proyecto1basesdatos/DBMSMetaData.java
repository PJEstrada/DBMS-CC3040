/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package proyecto1basesdatos;

import java.io.BufferedWriter;
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
public class DBMSMetaData implements Serializable {
     private static final long serialVersionUID = 6529685098267757691L;
    ArrayList<DBMetaData>  dbs;
    
    public DBMSMetaData(){
        dbs = new ArrayList<DBMetaData>();
    
    }
    
    //toString escribe el nombre de cada base de datos y la cantidad de tablas de cada una
     @Override
    public String toString(){
        String s = "Master \n\r";
        for(DBMetaData d: dbs){
            s+="Nombre Base de Datos: "+d.nombreDB+"\n\r";
            s+="Cantidad Tablas: "+d.tablas.size()+"\n\r";
        
        }
    
        return s;
    }
    
    //Pendiente llamar recursivamente
    public void writeMetadata(){
        Writer writer = null;
        String currentDir = System.getProperty("user.dir");
        try {
            writer = new BufferedWriter(new OutputStreamWriter(
            new FileOutputStream(currentDir+"/DBMS/master.dat"), "utf-8"));
            writer.write(this.toString());
        } catch (IOException ex) {
          System.out.println("Error WriteMetadata DBMS");
        } finally {
           try {writer.close();} catch (Exception ex) {}
        }
        //Escribimos cada uno de las bases de datos
        for(DBMetaData d: dbs){
            d.writeMetadata();
        
        }
    }
    
    public DBMetaData findDB(String name){      
        for(DBMetaData d: dbs){
            if(d.nombreDB.equals(name)){
                return d;
            
            }
        
        }
        return null;
    }
    
    

}
