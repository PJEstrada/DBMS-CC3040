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
         System.out.println("Creando  Directorio: " + nombre);
         Frame.jTextArea2.setText("Creando  Directorio: " + nombre);
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
            // Buscamos la metaData de la base de datos
            DBMetaData db = DBMS.metaData.findDB(name);
            if(db!=null){
                int reg = sumaRegistros(db);
                int input = JOptionPane.showConfirmDialog((Component) null, "Esta seguro que desea eliminar "+name+" con "+reg+" Registros?","alert", JOptionPane.OK_CANCEL_OPTION);
                if(input==JOptionPane.OK_OPTION){
                    //Destruimos directorio
                    deleteFolder(directorio);     
                    //Eliminamos la metaData de la base de datos
                    DBMS.metaData.dbs.remove(db);
                    DBMS.guardar();
                    Frame.jTextArea2.setText("Base de datos "+name+" Eliminada.");               
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
