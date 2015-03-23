/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package proyecto1basesdatos;

import java.util.ArrayList;

/**
 *
 * @author pablo
 */
public class IteradorTabla {
    
    int indiceActual;
    Tabla tabla;
    
    public IteradorTabla(Tabla t, int i){
        tabla = t;
        indiceActual =i;
    
    }
    // Metodo devuelve las tuplas del indiceActual en la tabla
    public ArrayList<Object> getValues(){
        return tabla.tuplas.get(indiceActual).valores;
    }
    
    //Devuelve el valor especifico de una columna de la t+ dependiendo del indiceActual
    public Object getValueFromColumn(int indiceColumna){
        if(tabla.tuplas.isEmpty()){return null;}
        return tabla.tuplas.get(indiceActual).valores.get(indiceColumna);
    
    }
    
    //Metodo que elimina un elemento de la tabla segun el indice
    public void deleteValue(){
        tabla.tuplas.remove(indiceActual);
    }
    
}
