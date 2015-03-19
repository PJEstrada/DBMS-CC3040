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
public class Tupla implements Serializable {
    private static final long serialVersionUID = 6529685098267757699L;
    Tabla tabla; //Tabla a la que pertenece la tupla
    ArrayList<Object> valores;
    
    public Tupla(ArrayList<Object> vals, Tabla t){
        this.tabla=t;
        //Agregamos el valor de cada columna uno por uno para verificar constraints y cualquier otra condicion
    }
}
