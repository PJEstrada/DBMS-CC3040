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
    ArrayList<String> columnas2 = new ArrayList<String>();
    //Este sera un arreglo de arreglos que mostrara los datos
    //cada arraylist interno sera como una fila de la tabla
    ArrayList<ArrayList<String>>datos = new ArrayList<ArrayList<String>>();
    ArrayList<ArrayList<String>>datos2 = new ArrayList<ArrayList<String>>();
    String[] dataC;
    String[][] filasT;
    JTable table;
    JTable table2;
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
        if(columnas2.size()>0 && datos2.size()>0)
        {
            dataC = new String[columnas2.size()];
            dataC = columnas2.toArray(dataC); 
            //se pasa de cada uno de los datos a un array tambien
            filasT = new String[datos2.size()][columnas2.size()];
            for(int i = 0; i< datos2.size(); i++)
            {
                String[] filaI = new String[datos2.get(i).size()];
                filaI = datos2.get(i).toArray(filaI);
                filasT[i] = filaI;
            }
            table2 = new JTable(filasT, dataC);
        }
    }
    
    //Constructor para cuando solo son datos en una tabla
    public Resultados(ArrayList<String> columnas, ArrayList<ArrayList<String>>datos)
    {
        this.columnas = columnas;
        this.datos = datos;
        fillData();
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(Frame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Frame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Frame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Frame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
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
    
    //Constructor para cuando son datos en dos tablas
    public Resultados(ArrayList<String> columnas1, ArrayList<ArrayList<String>>datos1, ArrayList<String> columnas2, ArrayList<ArrayList<String>>datos2)
    {
        this.columnas = columnas1;
        this.datos = datos1;
        this.columnas2 = columnas2;
        this.datos2 = datos2;
        fillData();
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(Frame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Frame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Frame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Frame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        JFrame frame = new JFrame("Resultados");
        frame.setLayout(new FlowLayout());
        frame.setSize(920,360);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        JScrollPane  scroll = new JScrollPane(table);
        table.setPreferredScrollableViewportSize(new Dimension(420, 200));
        table.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
        JScrollPane  scroll2 = new JScrollPane(table2);
        table2.setPreferredScrollableViewportSize(new Dimension(420, 200));
        table2.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
        frame.add(scroll);
        frame.add(scroll2);
        frame.setVisible(true);
    }
    
}
