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
public class Constraint {
    /*Tipos de constraints*/
    final static int PK=0; // tipo primary key
    final static int FK=1; // tipo foreign key
    final static int CHECK=2; // tipo Check
    
    Tabla tabla; // Tabla a la que pertenece la constraint
    String nombre;
    int tipo;
    
    public Constraint(String nombre, int tipo, ArrayList<Columna> columnas_pk,ArrayList<Columna> columnas_fk,Tabla t){
    
    
    }
    
}
