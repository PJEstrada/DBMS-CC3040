/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package proyecto1basesdatos;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.antlr.v4.runtime.ANTLRInputStream;
import org.antlr.v4.runtime.CommonTokenStream;
import org.antlr.v4.runtime.TokenStream;
import org.antlr.v4.runtime.tree.ParseTree;

/**
 *
 * @author pablo
 */
public class DBMS {
    
    static String currentDB;
    static DBMSMetaData metaData;
    
    
    public DBMS(){

      
        /* Test para tiempo serializacion / deserializacion*/
      /* int a =0;
        ArrayList<Tupla> ts = new ArrayList<Tupla>();
        for(int i =0; i<1500000;i++){
            a+=20000*i;
            ArrayList<Object> vals = new ArrayList<Object>();
            for(int j =0; j<100;j++){
                vals.add(j);
            }
            Tupla t = new Tupla(vals,null);
            ts.add(t);
        }          
                String currentDir1 = System.getProperty("user.dir");
                FileOutputStream fileOut1;           
                try {
                    fileOut1 = new FileOutputStream(currentDir1+"/DBMS/testTime.ser");
                        ObjectOutputStream out1;                 
                       out1 = new ObjectOutputStream(fileOut1);
                       out1.writeObject(ts);                    
                } catch (Exception ex) {
                    Logger.getLogger(DBMS.class.getName()).log(Level.SEVERE, null, ex);
                }
                System.out.print(a);
             try
            {
               FileInputStream fileIn = new FileInputStream(currentDir1+"/DBMS/testTime.ser");
               ObjectInputStream in1 = new ObjectInputStream(fileIn);
               ts = (ArrayList<Tupla>) in1.readObject();
               in1.close();
               fileIn.close();
               
               
            }catch(Exception i)
            {
               i.printStackTrace();
               return;         
            }     
        System.out.print(a);*/
        
        /*Para debugging cuando alteramos tablas*/
        /*for(int i =0; i<12000;i++){
            System.out.println("INSERT INTO asignacion VALUES ("+i+","+i+","+i+",'test"+i+"',1);");
        }*/
        //DBMS.currentDB="test";
        //Tabla t = Tabla.loadTable("asignacion");

       
        String currentDir = System.getProperty("user.dir");
        File f = new File(currentDir+"/DBMS/master.dat");
        // Buscamos el archivo. Si ya existe solo lo cargamos y lo asignamos a la variable estatica
        if(f.exists() && !f.isDirectory()) { 
            try
            {
               FileInputStream fileIn = new FileInputStream(currentDir+"/DBMS/master.ser");
               ObjectInputStream in = new ObjectInputStream(fileIn);
               metaData = (DBMSMetaData) in.readObject();
               in.close();
               fileIn.close();
               
               
            }catch(Exception i)
            {
               i.printStackTrace();
               return;         
            }
        }
        //Si no existe creamos el objeto metada y lo serializamos.
        else{
         FileInputStream fileIn;
           
             
             DBMSMetaData dbms = new DBMSMetaData();
             //Escribimos el archivo metadata
             dbms.writeMetadata();
             metaData = dbms;

             try {
                //Serializamos
                FileOutputStream fileOut =new FileOutputStream(currentDir+"/DBMS/master.ser");           
                ObjectOutputStream out;                 
                out = new ObjectOutputStream(fileOut);
                out.writeObject(dbms);
                    
                    
             } catch (IOException ex) {
                 Logger.getLogger(DBMS.class.getName()).log(Level.SEVERE, null, ex);
             }
        }
    
    }
    
    public static void guardar(){
             String currentDir = System.getProperty("user.dir");           
             try {
                //Serializamos
                FileOutputStream fileOut =new FileOutputStream(currentDir+"/DBMS/master.ser");           
                ObjectOutputStream out;                 
                out = new ObjectOutputStream(fileOut);
                out.writeObject(metaData);
                    
                    
             } catch (IOException ex) {
                 Logger.getLogger(DBMS.class.getName()).log(Level.SEVERE, null, ex);
             }
    
    }
    
    // Elemetodo crea un visitor en base al arbole generado y ejecuta la query
    public void executeQuery(String src){
                SQLLexer lexer = new SQLLexer(new ANTLRInputStream(src));
                lexer.removeErrorListeners();
                //lexer.addErrorListener(new ThrowingErrorListener(this));      

                TokenStream tokenStream = new CommonTokenStream(lexer);

                SQLParser parser = new SQLParser(tokenStream);
                parser.removeErrorListeners();
                //parser.addErrorListener(new ThrowingErrorListener(this));            
                ParseTree tree = parser.query();
                Loader l = new Loader(this);  
                l.visit(tree);
    
    }
    
}
