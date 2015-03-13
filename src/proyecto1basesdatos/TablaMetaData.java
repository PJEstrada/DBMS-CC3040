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
    String nombre;
    int cantRegistros;
    ArrayList<String> columnas;
    ArrayList<String> constraints;
    
        public void writeMetadata(){
    
    
    }
    
}
