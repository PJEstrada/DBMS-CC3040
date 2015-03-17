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
    
    String tabla;
    String nombre;
    int tipo;
    ArrayList<Columna> colsPkeys;
    
    ArrayList<Columna> localFkeys;
    ArrayList<Columna> refKeys;
    String foreignTable;
    String exprText;
    Expression expr;
    
    
    //Constructor para primary key
    public Constraint(String nombre, int tipo, ArrayList<Columna> columnas_pk,String tabla){
        this.nombre = nombre;
        this.tipo = tipo;
        colsPkeys = columnas_pk;
        
    
    }
    //Constructor para foreign Key
    public Constraint(String nombre, int tipo, ArrayList<Columna> locales,ArrayList<Columna> foreign,String tableReference,String tabla){
        this.nombre = nombre;
        this.tipo = tipo;
        this.localFkeys = locales;
        this.refKeys=foreign;
        this.foreignTable=tableReference;
        this.tabla = tabla;

    }    
    //Constructor para Check
    public Constraint(String nombre,int tipo, Expression e,String tabla,String ex){
        this.nombre = nombre;
        this.tipo = tipo;
        expr = e;
        this.tabla = tabla;
        this.exprText=ex;

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
                t="CHECK (";
                s+=t;
                s+=" "+this.exprText+" )"; 
                break;
        }
        return s;
    
    }
    
}
