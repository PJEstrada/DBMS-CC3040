package proyecto1basesdatos;

import java.io.Serializable;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author pablo
 */
public class ColumnMetaData implements Serializable{
    
    String nombre;
    String tipo;
    
    public ColumnMetaData(String n, String t){
        nombre = n;
        tipo = t;
    }
    public String toString(){
        String s = nombre+" TIPO: "+tipo;
        return s;
    }
}
