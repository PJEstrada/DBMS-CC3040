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
    
    DB currentDB;
    static DBMSMetaData metaData;
    
    
    public DBMS(){
      
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
