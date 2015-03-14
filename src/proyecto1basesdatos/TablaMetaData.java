/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package proyecto1basesdatos;

import java.io.Serializable;
import java.util.ArrayList;

/**
 *
 * @author pablo
 */
public class TablaMetaData implements Serializable{
    private static final long serialVersionUID = 6529685098267757692L;
    String nombre;
    int cantRegistros;
    ArrayList<String> columnas;
    ArrayList<String> constraints;
    
    public TablaMetaData(String n,ArrayList<String>cols, ArrayList<String> constraints){
        this.nombre = n;
        cantRegistros =0;
        columnas = cols;
        this.constraints= constraints;
    
    }
    
    public String toString(){
        String s ="Tabla: "+nombre+" \n\r";
        s+="Cantidad de Registros: "+cantRegistros+"\n\r";
        for(String s1: columnas){
            s+= s1+"  ";
        }
        for(String s2:constraints){
        
            s+=s2+"  ";
        }
        return s;
    }
    
     public void writeMetadata(){
         
    
    }
    
}
