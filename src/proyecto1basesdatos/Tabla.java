/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package proyecto1basesdatos;

import java.awt.Component;
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
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import static proyecto1basesdatos.DB.deleteFolder;
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
    
    public Tabla(){
        columnas = new ArrayList<Columna>();
        constraints = new ArrayList<Constraint>();
        tuplas = new ArrayList<Tupla>();
    }
    
    public Tabla(String n, ArrayList<Columna> cols){
        this.name = n;
        columnas = cols;
        constraints = new ArrayList<Constraint>();
        this.tuplas = new ArrayList<Tupla>();
        
        //Escribimos la MetaData de la tabla
        //Escribiendo Columnas
        ArrayList<ColumnMetaData> mcols = new ArrayList<ColumnMetaData>();
        for(Columna c: columnas){
            mcols.add(new ColumnMetaData(c.nombre,c.getStringType(c.tipo)));
        
        }
        
        TablaMetaData t = new TablaMetaData(name,mcols,new ArrayList<ConstraintMetaData>());
        DBMetaData d = DBMS.metaData.findDB(DBMS.currentDB);
        d.tablas.add(t);
        DBMS.guardar();
        DBMS.metaData.writeMetadata();
        guardarTabla();
        
        


    }
    public boolean contieneValor(Object valor, int iColumna){
        for(Tupla t:this.tuplas){
            Object v2 = t.valores.get(iColumna);
            if(v2 instanceof Integer){
               int v2c = (Integer) v2;
               int valorc = (Integer) valor;
               if(v2c==valorc){
                   return true;
               }
            }
            else if( v2 instanceof Float){
                if(v2 instanceof Float){
                    float v2c = (Float) v2;
                    float valorc = (Float) valor;
                    if(v2c == valorc){
                        return true;
                    }
                
                }
            }
            
            else if (v2 instanceof String){
                String v2c = (String) v2.toString();
                String valorc = valor.toString();
                if(v2c.equals(valorc)){
                    return true;
                }
                
            }
            
            else if(v2 instanceof LocalDateTime){
                LocalDate v2c = (LocalDate) v2;
                LocalDate valorc = (LocalDate) valor;
                if(v2c.equals(valorc)){
                    return true;
                }
            
            }
        }
        return false;
    
    }
    public boolean contieneValor(ArrayList<Object> valores, ArrayList<Integer> iColumnas){       
        for(Tupla t:this.tuplas){
            boolean result = true;
            for(int i =0;i<valores.size();i++){             
                Object v1 = valores.get(i);
                int iColumna = iColumnas.get(i);
                Object v2 = t.valores.get(iColumna);
                if(v2 instanceof Integer){
                    int v2c = (Integer) v2;
                    int valorc = (Integer) v1;
                    if(v2c!=valorc){
                        result = false;
                        break;
                    }
                 }
                 else if( v2 instanceof Float){
                     if(v2 instanceof Float){
                         float v2c = (Float) v2;
                         float valorc = (Float) v1;
                         if(v2c != valorc){
                             result = false;
                             break;
                         }

                     }
                 }

                 else if (v2 instanceof String){
                     String v2c = (String) v2.toString();
                     String valorc = v1.toString();
                     if(!v2c.equals(valorc)){
                         result = false;
                         break;
                     }

                 }

                 else if(v2 instanceof LocalDateTime){
                     LocalDate v2c = (LocalDate) v2;
                     LocalDate valorc = (LocalDate) v1;
                     if(!v2c.equals(valorc)){
                         result = false;
                         break;
                     }

                 }           
            }
            if(result){
                return true;
            }
            
 
        }
        return false;
    
    }    
    public int getIndiceColumna(String colName){
        int i =0;
        boolean f =false;
        for(Columna c: this.columnas){
            if(c.nombre.equalsIgnoreCase(colName)){
                f = true;
                break;
            }
            i++;
        
        }
        if(f){return i;}
        else{return -1;}
    
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
    
    public static Tabla loadTable(String nombreTabla){
                 
        String currentDir = System.getProperty("user.dir");
        File f = new File(currentDir+"/DBMS/"+DBMS.currentDB+"/"+nombreTabla+".ser");
        if(f.exists() && !f.isDirectory()) {
            //Deserializamos
            try
            {
               FileInputStream fileIn = new FileInputStream(currentDir+"/DBMS/"+DBMS.currentDB+"/"+nombreTabla+".ser");
               ObjectInputStream in = new ObjectInputStream(fileIn);
               Tabla ret = (Tabla) in.readObject();
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
    
    private void deleteOldFilesWithName(String oldName){
        String currentDir = System.getProperty("user.dir");
        File directorio  = new File(currentDir+"/DBMS/"+DBMS.currentDB+"/"+oldName+".ser");
        boolean existe = directorio.exists();
        if(existe){
             File f1  = new File(currentDir+"/DBMS/"+DBMS.currentDB+"/"+oldName+"_constraints.ser");
             File f2  = new File(currentDir+"/DBMS/"+DBMS.currentDB+"/"+oldName+"_cols.ser");
             f1.delete();
             f2.delete();
             directorio.delete();        
        }     
    }
    
    public void renameTo(String s){
        String oldName = this.name;
        this.name = s;
        for(Columna c: this.columnas){
            c.tabla=s;
        }
        for(Constraint c:this.constraints){
            c.tabla=s;
        }
        this.deleteOldFilesWithName(oldName);
        this.guardarTabla();
        
    
    }
    
    public void eliminarConstraint(String nombreConstraint){
        int i =0;
        boolean f = false;
        for(Constraint c: this.constraints){
            if(c.nombre.equalsIgnoreCase(nombreConstraint)){
                f=true;
                break;
            }
            i++;
        }
        if(f){this.constraints.remove(i);}
        //Eliminamos constraint de la metaData
         DBMetaData d = DBMS.metaData.findDB(DBMS.currentDB);
         TablaMetaData t = d.findTable(this.name);  
         i=0;
         f=false;
         for(ConstraintMetaData cm: t.constraints){
             if(cm.nombre.equalsIgnoreCase(nombreConstraint)){
                 f=true;
                 break;
             }
             i++;
         }
         if(f){t.constraints.remove(i);}
         
    }
    
    //Elimina la columna de cada una de las tuplas de la tabla, y del atributo columnas del objeto tabla. Ademas actualiza la metaData eliminando la columna y el archivo serializado de constraints y columnas
    public void eliminarColumna(Columna col){
        int i =0;
        boolean find = false;
        for(Columna c: this.columnas){
            //Si encontramos la columna procedemos a eliminarla y guardamos el indice para las tuplas
            if(c.nombre.equalsIgnoreCase(col.nombre)&&c.tabla.equalsIgnoreCase(col.tabla)){
                find = true;
                break;
            
            }
            i++;
        }
        
        if(find){ this.columnas.remove(i);}
        
        //Recorremos las tupls y eliminamos el i-esimo elemento de cada unoa
        for(Tupla t: this.tuplas){
            t.valores.remove(i);
        }
        //Verificamos si existe una primary key con la columna para eliminarla
        String n="";
        for(Constraint constr: this.constraints){
            for(Columna colCons: constr.colsPkeys){
                if(colCons.nombre.equalsIgnoreCase(col.nombre)){
                    n = constr.nombre;
                    break;
                }
            }
        }
        eliminarConstraint(n);
        //Actualizamo la metadata eliminando la columna
        DBMetaData d = DBMS.metaData.findDB(DBMS.currentDB);
        TablaMetaData t = d.findTable(this.name);
        i =0;
        find = false;
        for(ColumnMetaData cm: t.columnas){
            if(cm.nombre.equalsIgnoreCase(col.nombre)){
                find = true;
                break;
            }
            i++;
        }
        if(find){t.columnas.remove(i);}
    
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
    public static ArrayList<Constraint> loadConstraints(String nombreTabla){
                
        String currentDir = System.getProperty("user.dir");
        File f = new File(currentDir+"/DBMS/"+DBMS.currentDB+"/"+nombreTabla+"_constraints.ser");
        if(f.exists() && !f.isDirectory()) {
            //Deserializamos
            try
            {
               FileInputStream fileIn = new FileInputStream(currentDir+"/DBMS/"+DBMS.currentDB+"/"+nombreTabla+"_constraints.ser");
               ObjectInputStream in = new ObjectInputStream(fileIn);
               ArrayList<Constraint> ret = (ArrayList<Constraint>) in.readObject();
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
        this.tuplas = new ArrayList<Tupla>();
        //Escribimos la MetaData de la tabla
        //Escribiendo Columnas
        ArrayList<ColumnMetaData> mcols = new ArrayList<ColumnMetaData>();
        for(Columna c: columnas){
            mcols.add(new ColumnMetaData(c.nombre,c.getStringType(c.tipo)));
        
        }
        //Escribiendo constraints
         ArrayList<ConstraintMetaData> mcons = new ArrayList<ConstraintMetaData>();
         for(Constraint c: constraints){
            mcons.add(new ConstraintMetaData(c.nombre,c.getStringType(c.tipo),c.toString()));
         }
         
        TablaMetaData t = new TablaMetaData(name,mcols,mcons);
        DBMetaData d = DBMS.metaData.findDB(DBMS.currentDB);
        d.tablas.add(t);
        DBMS.guardar();
        DBMS.metaData.writeMetadata();
        guardarTabla();
        
                
        
        
    }
    
    

}
