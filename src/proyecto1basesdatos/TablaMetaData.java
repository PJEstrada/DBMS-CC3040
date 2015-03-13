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
    private static final long serialVersionUID = 6529685098267757692L;
    String nombre;
    int cantRegistros;
    ArrayList<String> columnas;
    ArrayList<String> constraints;
    
        public void writeMetadata(){
    
    
    }
    
}
