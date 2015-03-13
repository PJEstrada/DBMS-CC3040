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
    
    ArrayList<DBMetaData>  dbs;
    
    public DBMSMetaData(){
        dbs = new ArrayList<DBMetaData>();
    
    }
    
    //toString escribe el nombre de cada base de datos y la cantidad de tablas de cada una
    public String toString(){
        String s = "Master \n\r";
        for(DBMetaData d: dbs){
            s+="Nombre Base de Datos: "+d.nombreDB+"\n\r";
            s+="Cantidad Tablas: "+d.tablas.size()+"\n\r";
        
        }
    
        return s;
    }
    
    public void writeMetadata(){
    
    
    }
    
    

}
