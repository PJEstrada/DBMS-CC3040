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
import java.io.Writer;
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
         boolean result = false;

         try{
             directorio.mkdir();
             result = true;
             writeMetadata();
             System.out.println("Creado el archivo metadata de la base de datos: ");
          } catch(SecurityException se){
             System.out.println("No es posible crear directorio, revise permisos de administrador. " + nombre);
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
    // Metodo para escribir la descripcion de la base de datos en el archivo metadata.dat
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
    public static void destroyDb(){
    
    
    }
}
