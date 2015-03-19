/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package proyecto1basesdatos;

import java.io.Serializable;
import java.time.LocalDate;
import java.util.Date;

/**
 *
 * @author pablo
 */
public class Term implements Serializable {
    public static final int INT_TYPE=0;
    public static final int FLOAT_TYPE=1;
    public static final int DATE_TYPE=3;
    public static final int CHAR_TYPE=2;
    
    
    Object value;
    boolean isColumn;
    int type;
    Columna column;
    
    //Constructor para integers
    public Term(int v){
        value = v;
        type = INT_TYPE;
        isColumn=false;
    }
    //Constructor para floats
    public Term(float v){
        value = v;
        type = FLOAT_TYPE;
        isColumn=false;
    }
    //Constructor para CHAR 
    public Term(String v){
        value = v;
        type = CHAR_TYPE;
        isColumn=false;
    }
    //Constructor para Date 
    public Term(LocalDate v){
        value = v;
        type = DATE_TYPE;
        isColumn=false;
    }    
    
    //Constructor para columna
    public Term(Columna c){
        column = c;
        value = null;
        type = c.tipo;
        isColumn=true;
    }    
    
    /*
    Metodo getValue: verifica si el term es una columna o un valor. Si es un valor retorno el valor
    Si es una columna. revisa el iterador de tabla y obtiene el valor actual correspondiente a la columna de la tupla
    en la que se encuentre el iterador
    */
   
}
