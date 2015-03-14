/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package proyecto1basesdatos;

import java.io.BufferedWriter;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.io.OutputStreamWriter;
import java.io.Serializable;
import java.io.Writer;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author pablo
 */
public class Tabla implements Serializable {
    private static final long serialVersionUID = 6529685098267757696L;
    String name;
    ArrayList<Columna> columnas;
    ArrayList<Constraint> constraints;
    ArrayList<Tupla> tuplas;
    
    public Tabla(){}
    
    public Tabla(String n, ArrayList<Columna> cols){
        this.name = n;
        columnas = cols;
        constraints = new ArrayList<Constraint>();
        
        //Escribimos la MetaData de la tabla
        //Escribiendo Columnas
        ArrayList<String> mcols = new ArrayList<String>();
        for(Columna c: columnas){
            mcols.add(c.toString());
        
        }
        
        TablaMetaData t = new TablaMetaData(name,mcols,new ArrayList<String>());
        DBMetaData d = DBMS.metaData.findDB(DBMS.currentDB);
        d.tablas.add(t);
        DBMS.guardar();
        DBMS.metaData.writeMetadata();
        guardarTabla();
        
        


    }
    
    public void guardarTabla(){
        //Serializamos
        String currentDir = System.getProperty("user.dir");
        FileOutputStream fileOut;           
        try {
            fileOut = new FileOutputStream(currentDir+"/DBMS/"+DBMS.currentDB+"/"+name+".ser");
            ObjectOutputStream out;                 
            out = new ObjectOutputStream(fileOut);
            out.writeObject(this);           
        } catch (Exception ex) {
            Logger.getLogger(Tabla.class.getName()).log(Level.SEVERE, null, ex);
        }
    
    }
    public Tabla(String n, ArrayList<Columna> cols, ArrayList<Constraint> cons){
    
        this.name = n;
        columnas = cols;
        constraints = cons;  
        //Escribimos la MetaData de la tabla
        //Escribiendo Columnas
        ArrayList<String> mcols = new ArrayList<String>();
        for(Columna c: columnas){
            mcols.add(c.toString());
        
        }
        //Escribiendo constraints
         ArrayList<String> mcons = new ArrayList<String>();
         for(Constraint c: constraints){
            mcons.add(c.toString());
         }
         
        TablaMetaData t = new TablaMetaData(name,mcols,mcons);
        DBMetaData d = DBMS.metaData.findDB(DBMS.currentDB);
        d.tablas.add(t);
        DBMS.guardar();
        DBMS.metaData.writeMetadata();
        guardarTabla();
        
                
        
        
    }
    
    

}
