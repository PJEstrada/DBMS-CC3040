/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package proyecto1basesdatos;

import java.awt.Component;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.io.OutputStreamWriter;
import java.io.Writer;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import javax.swing.JOptionPane;

/**
 *
 * @author pablo
 */
public class DB {
    String name;  //Nombre de la base de datos
    ArrayList<Tabla> tablas;  //tablas que contiene la base de datos
    String dir;
    
    public DB(String nombre) throws Exception{
        this.name= nombre;
        tablas  = new ArrayList<Tabla>();
        
        
        //Creamos carpeta  con el nombre de la base de datos
        String currentDir = System.getProperty("user.dir");
        System.out.println(currentDir);
        dir=currentDir+"/DBMS/"+nombre+"/";
        File directorio  = new File(currentDir+"/DBMS/"+nombre);

       //Si no existe el directorio lo creamos
       if (!directorio.exists()) {
        Debug.agregar("Creando  Directorio: " + nombre+"\n ");


         boolean result = false;

         try{
             directorio.mkdir();
             result = true;
             //Creamos el objeto meta data
             DBMetaData dbm = new DBMetaData(name);
             //Lo agregamos a al DBMS
             DBMS.metaData.dbs.add(dbm);
             // Guardamos el archivo serializado del dbms
             DBMS.guardar();

             //Reescribimos la data de todo el dbms y sus dbs y tablas relacionadas llamando al metodo Write recursivamente
             DBMS.metaData.writeMetadata();
            // writeMetadata();
             Debug.agregar("Creado el archivo metadata de la base de datos: \n");

          } catch(SecurityException se){
             System.out.println("No es posible crear directorio, revise permisos de administrador. " + nombre);
                    Debug.agregar("\n Base de datos "+name+" creada exitosamente." );
                    if(!Frame.useVerbose){
                        Frame.jTextArea2.setText("No es posible crear directorio, revise permisos de administrador. " + nombre);
                    } 
          } 
         
          if(result) {   
            Debug.agregar("Directorio creado en: "+directorio.getAbsolutePath());
          }
       }
       // Si ya existe lanzamos una exepcion para reportar error    
       else{
           throw new Exception("ERROR: ya existe la base de datos:"+nombre);
       
       }
        
    }
    
    // Utiliado para generar el archivo de meta data de la base de datos
    public String toString(){
        String s =" DB: "+name;
        s+="\r\n TABLAS:  \r\n ";
        for(int i=0 ; i<tablas.size();i++){
            s+=i+". "+tablas.get(i)+"\n\r";
            s+=tablas.get(i).toString();  //llamamos al toString de cada tabla para obtener datos como el numero de registros y las restricciones
        }
        
       return s;
    }

    public static boolean destroyDb(String name){
        String currentDir = System.getProperty("user.dir");
        File directorio  = new File(currentDir+"/DBMS/"+name);
        boolean existe = directorio.exists();
        if(existe){
            // Buscamos la metaData de la base de datos
            Debug.agregar("Buscando la base de datos...");

            DBMetaData db = DBMS.metaData.findDB(name);
            if(db!=null){
                int reg = sumaRegistros(db);
                int input = JOptionPane.showConfirmDialog((Component) null, "Esta seguro que desea eliminar "+name+" con "+reg+" Registros?","alert", JOptionPane.OK_CANCEL_OPTION);
                if(input==JOptionPane.OK_OPTION){
                    //Destruimos directorio
                    Debug.agregar("Eliminando directorio...");
                
 
                    deleteFolder(directorio);     
                    //Eliminamos la metaData de la base de datos
                    Debug.agregar("Eliminando metadata...");

                    DBMS.metaData.dbs.remove(db);
                    DBMS.guardar();
                    Debug.agregar("Base de datos "+name+" Eliminada.");
                    if(!Frame.useVerbose){
                        Frame.jTextArea2.setText("Base de datos "+name+" Eliminada.");
                    }                       

                                  
                }
            }
            else{
                Frame.jTextArea2.setText("Error: No se encuentra metaData de la base de datos");
            }
            
            return true;
        }
        else{
            return false;
        }     
    }
    
    public static boolean renameDB(String nameA, String nameB){
        //Bucamos la base de datos en la metadata
        DBMetaData d =DBMS.metaData.findDB(nameA);
        if(d!=null){
            d.nombreDB =nameB;
            //Renombramos folder
            if(Frame.useVerbose){
                Debug.agregar("Renombrando folder...");
            }
            renameFolder(nameA,nameB);
            //Eliminamos el .dat con el nombre anterior
            String currentDir = System.getProperty("user.dir");  
             File directorio  = new File(currentDir+"/DBMS/"+nameB+"/"+nameA+".dat");
             directorio.delete();
            //Guardamos los cambios y escribimos la nuevaMetadata
            DBMS.guardar();
            
            Debug.agregar("Reescribiendo la metadata");
            
            DBMS.metaData.writeMetadata();
            
            Debug.agregar("Base de datos: "+nameA+" Modificada a : "+nameB);
            if(!Frame.useVerbose){
                Frame.jTextArea2.setText("Base de datos: "+nameA+" Modificada a : "+nameB);
            }

            return true;
        
        }
        //Si no la encontramos lanzamos error
        else{
            Debug.agregar("Error: No se encuentra metaData de la base de datos"+nameA);
            if(!Frame.useVerbose){
                Frame.jTextArea2.setText("Error: No se encuentra metaData de la base de datos"+nameA);
            }            
           
            return false;
        }
    }
    
    private static boolean renameFolder(String nameA, String nameB){
        String currentDir = System.getProperty("user.dir");    
        File directorio  = new File(currentDir+"/DBMS/"+nameA);
        //Si el directorio existe lo eliminamos
        if(directorio.exists()){
            File f2 = new File(currentDir+"/DBMS/"+nameB);
            directorio.renameTo(f2);
            return true;
        
        }
        //Sino retornamos false
        else{
            return false;
        
        }
    
    }
    
    public static void deleteFolder(File folder) {
        File[] files = folder.listFiles();
        if(files!=null) { //some JVMs return null for empty dirs
            for(File f: files) {
                if(f.isDirectory()) {
                    deleteFolder(f);
                } else {
                    f.delete();
                }
            }
        }
        folder.delete();
    }
    
    private static int sumaRegistros(DBMetaData d){
        int a =0;
        for(TablaMetaData t:d.tablas){
            a+=t.cantRegistros;
        
        }
        return a;
    
    }
   
}
