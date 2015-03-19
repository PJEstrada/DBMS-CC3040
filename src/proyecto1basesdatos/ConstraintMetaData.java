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
public class ConstraintMetaData implements Serializable {
    String nombre;
    String tipo;
    String decripcion;
    
    public ConstraintMetaData(String n, String t, String d){
        nombre = n;
        tipo = t;
        decripcion = d;
    
    }
    public ConstraintMetaData(String n, String t){
        nombre = n;
        tipo = t;
    
    }   
    
    public String toString(){
        return this.decripcion;
    }
    
}
