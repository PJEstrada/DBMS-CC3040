/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package proyecto1basesdatos;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.OutputStreamWriter;
import java.io.Serializable;
import java.io.Writer;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import static proyecto1basesdatos.DBMS.metaData;

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
        //Serializamos la tabla
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
        //Serializamos columnas por separado       
        try {
            fileOut = new FileOutputStream(currentDir+"/DBMS/"+DBMS.currentDB+"/"+name+"_cols.ser");
            ObjectOutputStream out;                 
            out = new ObjectOutputStream(fileOut);
            out.writeObject(this.columnas);           
        } catch (Exception ex) {
            Logger.getLogger(Tabla.class.getName()).log(Level.SEVERE, null, ex);
        }  
        //Serializamos constraints por separado       
        try {
            fileOut = new FileOutputStream(currentDir+"/DBMS/"+DBMS.currentDB+"/"+name+"_constraints.ser");
            ObjectOutputStream out;                 
            out = new ObjectOutputStream(fileOut);
            out.writeObject(this.constraints);           
        } catch (Exception ex) {
            Logger.getLogger(Tabla.class.getName()).log(Level.SEVERE, null, ex);
        }        
    }
    
    public static ArrayList<Columna> loadColums(String nombreTabla){
                
        String currentDir = System.getProperty("user.dir");
        File f = new File(currentDir+"/DBMS/"+DBMS.currentDB+"/"+nombreTabla+"_cols.ser");
        if(f.exists() && !f.isDirectory()) {
            //Deserializamos
            try
            {
               FileInputStream fileIn = new FileInputStream(currentDir+"/DBMS/"+DBMS.currentDB+"/"+nombreTabla+"_cols.ser");
               ObjectInputStream in = new ObjectInputStream(fileIn);
               ArrayList<Columna> ret = (ArrayList<Columna>) in.readObject();
               in.close();
               fileIn.close(); 
               return ret;
            }catch(Exception i)
            {
               i.printStackTrace();
               return null;         
            }            
        
        }  
        else{
            return null;
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
