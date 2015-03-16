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
public class Constraint implements Serializable {
    private static final long serialVersionUID = 6529685098267757698L;
    /*Tipos de constraints*/
    final static int PK=0; // tipo primary key
    final static int FK=1; // tipo foreign key
    final static int CHECK=2; // tipo Check
    
    String nombre;
    int tipo;
    ArrayList<Columna> colsPkeys;
    
    ArrayList<Columna> localFkeys;
    ArrayList<Columna> refKeys;
    String foreignTable;
    
    
    //Constructor para primary key
    public Constraint(String nombre, int tipo, ArrayList<Columna> columnas_pk){
        this.nombre = nombre;
        this.tipo = tipo;
        colsPkeys = columnas_pk;
        
    
    }
    //Constructor para foreign Key
    public Constraint(String nombre, int tipo, ArrayList<Columna> locales,ArrayList<Columna> foreign,String tableReference){
        this.nombre = nombre;
        this.tipo = tipo;
        this.localFkeys = locales;
        this.refKeys=foreign;
        this.foreignTable=tableReference;
    
    }    
    
    
    public String toString(){
        String s = "CONSTRAINT: "+nombre+" ";
        String t="";
        switch(tipo){
            case 0:
                t="P_KEY";
                s+=t+" ( ";
                for(Columna c:colsPkeys){
                    s+=c.nombre+", ";
                }
                s+=" ) ";
                
                break;
            case 1:
                t="F_KEY (";
                s+=t;
                for(Columna c:localFkeys){
                    s+=c.nombre+", ";
                }
                s+=") REFERENCES"+this.foreignTable+" (";
                
                for(Columna c:this.refKeys){
                    s+=c.nombre+", ";
                }    
                s+=") ";
                break;
             
                
            case 2:
                t="CHECK";
                break;
        }
        return s;
    
    }
    
}
