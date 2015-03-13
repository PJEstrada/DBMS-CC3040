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
import java.io.ObjectOutputStream;
import java.io.OutputStreamWriter;
import java.io.Writer;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;

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
         System.out.println("Creando  Directorio: " + nombre);
         Frame.jTextArea2.setText("Creando  Directorio: \n" + nombre);
         boolean result = false;

         try{
             directorio.mkdir();
             result = true;
             //Creamos el objeto meta data
             DBMetaData dbm = new DBMetaData(name);
             //Escribimos el archivo metadata
             dbm.writeMetadata(directorio);
             
             FileOutputStream fileOut =new FileOutputStream(dir+"db.dat");             
             ObjectOutputStream out = new ObjectOutputStream(fileOut);
             out.writeObject(dbm);
            // writeMetadata();
             Frame.jTextArea2.append("Creado el archivo metadata de la base de datos: \n");
             
             
             
          } catch(SecurityException se){
             System.out.println("No es posible crear directorio, revise permisos de administrador. " + nombre);
             Frame.jTextArea2.append("No es posible crear directorio, revise permisos de administrador. \n" + nombre);
          } 
         
          if(result) {    
            System.out.println("Directorio creado en: "+directorio.getAbsolutePath());  
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
            deleteFolder(directorio);
            return true;
        }
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
    
    public void writeMetadata(){
        Writer writer = null;

        try {
            writer = new BufferedWriter(new OutputStreamWriter(
            new FileOutputStream(dir+name+"_metadata.dat"), "utf-8"));
            writer.write(this.toString());
        } catch (IOException ex) {
          // report
        } finally {
           try {writer.close();} catch (Exception ex) {}
        }       

    }
}
