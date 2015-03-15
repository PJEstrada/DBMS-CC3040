/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package proyecto1basesdatos;

import java.awt.Dimension;
import java.awt.FlowLayout;
import java.util.ArrayList;
import javax.swing.JFrame;
import javax.swing.JTable;
import javax.swing.JScrollPane;
import javax.swing.ListSelectionModel;

/**
 *
 * @author usuario
 */
public class Resultados {
    
    //Esta solamente sera una fila con los nombres de cada dato
    ArrayList<String> columnas = new ArrayList<String>();
    //Este sera un arreglo de arreglos que mostrara los datos
    //cada arraylist interno sera como una fila de la tabla
    ArrayList<ArrayList<String>>datos = new ArrayList<ArrayList<String>>();
    String[] dataC;
    String[][] filasT;
    JTable table;
    //metodo para poder llenar la data
    public void fillData()
    {
        //Se pasa a array para poder ser puesto en la tabla
        dataC = new String[columnas.size()];
        dataC = columnas.toArray(dataC); 
        //se pasa de cada uno de los datos a un array tambien
        filasT = new String[datos.size()][columnas.size()];
        for(int i = 0; i< datos.size(); i++)
        {
            String[] filaI = new String[datos.get(i).size()];
            filaI = datos.get(i).toArray(filaI);
            filasT[i] = filaI;
        }
        table = new JTable(filasT, dataC);
    }
    
    public Resultados(ArrayList<String> columnas, ArrayList<ArrayList<String>>datos)
    {
        this.columnas = columnas;
        this.datos = datos;
        fillData();
        JFrame frame = new JFrame("Resultados");
        frame.setLayout(new FlowLayout());
        frame.setSize(460,180);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        JScrollPane  scroll = new JScrollPane(table);
        table.setPreferredScrollableViewportSize(new Dimension(420, 60));
        table.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
        frame.add(scroll);
        frame.setVisible(true);
    }
    
    
}
