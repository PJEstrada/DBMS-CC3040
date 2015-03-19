/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package proyecto1basesdatos;

import java.io.Serializable;

/**
 *
 * @author pablo
 */
public class Columna implements Serializable {
    private static final long serialVersionUID = 6529685098267757697L;
    /*Declaramos como estaticos los posibles tipos de las columnas*/
    static final int INT_TYPE =0;
    static final int FLOAT_TYPE =1;
    static final int CHAR_TYPE =2;
    static final int DATE_TYPE=3;
    
    int tipo; //Tipo de la columna, cualquiera de los mencionados arriba
    int size; //Solo se utiliza para los CHAR_TYPE. Almacen es tamanio del CHAR ingresado entre parentesis.
    String nombre; //Nombre de la columna
    String tabla; //Nombre de la tabla
    
    public Columna(String nombre,int tipo,String tabla ){
        this.nombre = nombre;
        this.tipo = tipo;
        size = -1;
        this.tabla=tabla;
    
    }
    public Columna(String nombre,int tipo,int size, String tabla ){
        this.nombre = nombre;
        this.tipo = tipo;
        this.size = size;
        this.tabla = tabla;
    
    }    
    public String getStringType(int i){
        String t="";
        switch(i){
            case 0:
                t="INT";
                break;
            case 1:
                t="FLOAT";
                break;
            case 2:
                t="CHAR("+size+")";
                break;
            case 3:
                t="DATE";
                break;
        }  
        return t;
    }
    public String toString(){
        String t="";
        switch(tipo){
            case 0:
                t="INT";
                break;
            case 1:
                t="FLOAT";
                break;
            case 2:
                t="CHAR("+size+")";
                break;
            case 3:
                t="DATE";
                break;
        }
        
        String s = nombre+"  Type: "+t+",";
        return s;
    
    }
}
