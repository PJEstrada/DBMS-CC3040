/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package proyecto1basesdatos;

/**
 *
 * @author pablo
 */
public class Columna {
    /*Declaramos como estaticos los posibles tipos de las columnas*/
    static final int INT_TYPE =0;
    static final int FLOAT_TYPE =1;
    static final int CHAR_TYPE =2;
    static final int DATE_TYPE=3;
    
    int tipo; //Tipo de la columna, cualquiera de los mencionados arriba
    int size; //Solo se utiliza para los CHAR_TYPE. Almacen es tamanio del CHAR ingresado entre parentesis.
    String nombre; //Nombre de la columna
    
    public Columna(String nombre,int tipo ){
    
    
    }
    public Columna(String nombre,int tipo,int size ){
    
    
    }    
}
