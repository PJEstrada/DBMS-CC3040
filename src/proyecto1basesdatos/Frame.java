/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package proyecto1basesdatos;

/**
 *
 * @author Al
 * FileChooser para guardar adaptado de http://stackoverflow.com/questions/9730635/saving-with-a-jfilechooser
 * MyDispatcher adpatado de http://stackoverflow.com/questions/286727/java-keylistener-for-jframe-is-being-unresponsive
 */
import java.awt.Component;
import java.awt.KeyEventDispatcher;
import java.awt.KeyboardFocusManager;
import java.awt.Rectangle;
import java.awt.event.KeyEvent;
import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.ImageIcon;
import javax.swing.JFileChooser;

import javax.swing.JFrame;
import javax.swing.JPanel;

import javax.swing.JScrollPane;

import javax.swing.JTextArea;

import javax.swing.SwingUtilities;

import javax.swing.event.DocumentEvent;

import javax.swing.event.DocumentListener;
import javax.swing.filechooser.FileNameExtensionFilter;

import javax.swing.text.BadLocationException;
import org.antlr.v4.runtime.ANTLRInputStream;
import org.antlr.v4.runtime.CommonTokenStream;
import org.antlr.v4.runtime.TokenStream;
import org.antlr.v4.runtime.tree.ParseTree;

public class Frame extends javax.swing.JFrame {

    JFileChooser jfc;
    private TextLineNumber lineNumber;
    private JFileChooser chooser;
    private boolean docUpdate = false;
    private String default_filename = "default.sql";
    private String default_directory = "/home/foo/workspace";
    private int version = 0;
    private JSwitchBox switchB;
    public static boolean useVerbose = true;
    /**
     * Creates new form Frame
     */
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel PruebaLocalizacion;
    public static javax.swing.JPanel forResults;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton3;
    private javax.swing.JButton jButton4;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JTextArea jTextArea1;
    public static javax.swing.JTextArea jTextArea2;
    private javax.swing.JToolBar jToolBar1;
    // End of variables declaration//GEN-END:variables
    public boolean error;
    public DBMS dbms;
    public Frame() {
        initComponents();
        this.dbms= new DBMS();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    
    private void initComponents() {

        jScrollPane1 = new javax.swing.JScrollPane();
        jTextArea1 = new javax.swing.JTextArea();
        lineNumber = new TextLineNumber(jTextArea1);
        jScrollPane1.setRowHeaderView( lineNumber );
        jScrollPane2 = new javax.swing.JScrollPane();
        jTextArea2 = new javax.swing.JTextArea();
        jToolBar1 = new javax.swing.JToolBar();
        jButton2 = new javax.swing.JButton(new ImageIcon("imagenes/play-icon.png"));
        jButton4 = new javax.swing.JButton(new ImageIcon("imagenes/save-icon.png"));
        jButton3 = new javax.swing.JButton(new ImageIcon("imagenes/folder-icon.png"));
        jButton1 = new javax.swing.JButton(new ImageIcon("imagenes/delete-icon.png"));
        forResults = new javax.swing.JPanel();
        switchB = new JSwitchBox("Con Verbose", "Sin Verbose");

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jTextArea1.setColumns(20);
        jTextArea1.setRows(5);
        jScrollPane1.setViewportView(jTextArea1);

        jTextArea2.setEditable(false);
        jTextArea2.setColumns(20);
        jTextArea2.setRows(5);
        jScrollPane2.setViewportView(jTextArea2);

        jToolBar1.setRollover(true);

        jButton2.setText("");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });
        jToolBar1.add(jButton2);

        jButton4.setText("");
        jButton4.setFocusable(false);
        jButton4.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        jButton4.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        jButton4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton4ActionPerformed(evt);
            }
        });
        jToolBar1.add(jButton4);

        jButton3.setText("");
        jButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton3ActionPerformed(evt);
            }
        });
        jToolBar1.add(jButton3);

        jButton1.setText("");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });
        jToolBar1.add(jButton1);

        forResults.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        forResults.setLayout(new java.awt.BorderLayout());



        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane2, javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jToolBar1, javax.swing.GroupLayout.PREFERRED_SIZE, 694, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 476, Short.MAX_VALUE))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 590, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(26, 26, 26)
                        .addComponent(forResults, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                .addContainerGap())
            .addGroup(layout.createSequentialGroup()
                .addGap(525, 525, 525)
                .addComponent(switchB)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jToolBar1, javax.swing.GroupLayout.DEFAULT_SIZE, 38, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 367, Short.MAX_VALUE)
                    .addComponent(forResults, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(18, 18, 18)
                .addComponent(switchB)
                .addGap(29, 29, 29)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 145, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
        KeyboardFocusManager manager = KeyboardFocusManager.getCurrentKeyboardFocusManager();
        manager.addKeyEventDispatcher(new MyDispatcher());
        pack();
    }

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed

        String[] wordsNot = {"CREATE","DATABASE", "DATABASES", "ALTER", "DROP", "SHOW", "USE", "TABLE", "INT", "FLOAT",
                              "DATE", "CHAR", "CONSTRAINT", "PRIMARY", "KEY", "FOREIGN", "CHECK", "REFERENCES", "TABLES",
                                "COLUMN", "FROM", "ADD", "AND", "OR", "NOT", "INSERT", "INTO", "WHERE", "UPDATE", "SET",
                                "DELETE", "SELECT", "ORDER", "BY", "ASC", "DESC", "VALUES", "RENAME", "TO", "NULL", "NULL,"}; //esto es un comentario
        
        ArrayList<String> wordsR = new ArrayList( Arrays.asList(wordsNot));
        
        String src = jTextArea1.getText();
        src= src.replaceAll(",",", ");/*insert into films values (17,null,null,'Fiction',18) */
        //src+=" ";
        String srcFinal = "";
        String [] checkA = src.split(" "); //[\\s,;]+
        for (String checkA1 : checkA) {
            String tempW = checkA1.toUpperCase();
            //System.out.println("string uppercase: "+tempW);
            tempW = tempW.replaceAll("\\s+", "");
           // srcFinal += tempW + " ";
            if (wordsR.contains(tempW)) {
                srcFinal += tempW + " ";
            } else {
                srcFinal += checkA1 + " ";
            }
        }
       

        jTextArea2.setText("");
        

        
        this.error=false;
        try{
            SQLLexer lexer  = new SQLLexer(new ANTLRInputStream(srcFinal));
            //lexer.removeErrorListeners();
            //lexer.addErrorListener(new ThrowingErrorListener(this));        
            TokenStream tokenStream = new CommonTokenStream(lexer);
            
            SQLParser parser = new SQLParser(tokenStream);
            parser.removeErrorListeners();
            parser.addErrorListener(new ThrowingErrorListener(this));
            parser.query().inspect(parser);
            if (!error) {
                dbms.executeQuery(srcFinal);
                System.out.print("  ");
                if(Frame.useVerbose){
                    jTextArea2.setText(Debug.a);
                }
            }  
            
        }
        
        catch(Exception e){
            jTextArea2.setText(e.getMessage());
            e.printStackTrace();
                   
        }
        
    }//GEN-LAST:event_jButton2ActionPerformed
    
    private void jButton4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton4ActionPerformed
        jfc = new JFileChooser();
        jfc.setCurrentDirectory(new File(default_directory));
        jfc.setSelectedFile(new File(default_filename));
        jfc.addPropertyChangeListener(new PropertyChangeListener() {

            @Override
            public void propertyChange(PropertyChangeEvent evt)
            {               
                if (docUpdate == true)
                {
                    jfc.setCurrentDirectory(new File("/home/foo"));
                    jfc.setSelectedFile(new File("default" + version + ".sql"));
                }               
            }
        });
        int returnVal = jfc.showSaveDialog(this);
        if (returnVal == JFileChooser.APPROVE_OPTION)
        {
            File file = jfc.getSelectedFile();
            // save the file.
            BufferedWriter bw;
            try {
                bw = new BufferedWriter(new FileWriter(file));
                bw.write(jTextArea1.getText());
                bw.flush();
            }               
            catch (IOException e1)
            {
                e1.printStackTrace();
            }
            version++;

        }
        else
        {
            System.out.println("");
        }
        jTextArea1.setCaretPosition(jTextArea1.getDocument().getLength());
    }//GEN-LAST:event_jButton4ActionPerformed

    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton3ActionPerformed
        String inputBoton="";
        chooser = new JFileChooser();
        FileNameExtensionFilter filter = new FileNameExtensionFilter(
                    "SQL and Text", "sql", "txt");
        chooser.setFileFilter(filter);
        //chooser.showOpenDialog(null);
        int result = chooser.showOpenDialog(null);
        if (result == JFileChooser.APPROVE_OPTION) {
                File selectedFile = chooser.getSelectedFile();
                BufferedReader br = null;
                try {
                        br = new BufferedReader(new FileReader(selectedFile));
                } catch (FileNotFoundException e) {
                        e.printStackTrace();
                }
                String st = "";
                inputBoton = "";
                try {
                        while((st = br.readLine()) != null){
                                inputBoton+=st+"\n";

                        }
                } catch (IOException e) {
                        e.printStackTrace();
                }
        }
        jTextArea1.setText(inputBoton);
    }//GEN-LAST:event_jButton3ActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        jTextArea1.setText("");
        jTextArea2.setText("");
        for(Component i: forResults.getComponents()){
           forResults.remove(i);
        }
    }//GEN-LAST:event_jButton1ActionPerformed
    
    private class MyDispatcher implements KeyEventDispatcher {
        @Override
        public boolean dispatchKeyEvent(KeyEvent e) {
            if (e.getID() == KeyEvent.KEY_PRESSED && e.getKeyCode()== KeyEvent.VK_F5) {
                System.out.println("ohasdf");
                String[] wordsNot = {"CREATE","DATABASE", "DATABASES", "ALTER", "DROP", "SHOW", "USE", "TABLE", "INT", "FLOAT",
                              "DATE", "CHAR", "CONSTRAINT", "PRIMARY", "KEY", "FOREIGN", "CHECK", "REFERENCES", "TABLES",
                                "COLUMN", "FROM", "ADD", "AND", "OR", "NOT", "INSERT", "INTO", "WHERE", "UPDATE", "SET",
                                "DELETE", "SELECT", "ORDER", "BY", "ASC", "DESC", "VALUES", "RENAME", "TO", "NULL", "NULL,"}; //Esto es otro comentario
        
               ArrayList<String> wordsR = new ArrayList( Arrays.asList(wordsNot));
        
                String src = jTextArea1.getText();
                src= src.replaceAll(",",", ");/*insert into films values (17,null,null,'Fiction',18)*/
                //src+=" ";
                String srcFinal = "";
                String [] checkA = src.split(" "); //[\\s,;]+
                for (String checkA1 : checkA) {
                    String tempW = checkA1.toUpperCase();
                    //System.out.println("string uppercase: "+tempW);
                    tempW = tempW.replaceAll("\\s+", "");
                   // srcFinal += tempW + " ";
                    if (wordsR.contains(tempW)) {
                        srcFinal += tempW + " ";
                    } else {
                        srcFinal += checkA1 + " ";
                    }
                }
               

                jTextArea2.setText("");

                jTextArea2.setText("");
                Frame.this.error=false;
                try{
                    SQLLexer lexer  = new SQLLexer(new ANTLRInputStream(srcFinal));
                    //lexer.removeErrorListeners();
                    //lexer.addErrorListener(new ThrowingErrorListener(this));        
                    TokenStream tokenStream = new CommonTokenStream(lexer);

                    SQLParser parser = new SQLParser(tokenStream);
                    parser.removeErrorListeners();
                    parser.addErrorListener(new ThrowingErrorListener(Frame.this));
                    parser.query().inspect(parser);
                    if (!error) {
                        dbms.executeQuery(srcFinal);
                        System.out.print("  ");
                    }            
                }

                catch(Exception ex){
                    jTextArea2.setText(ex.getMessage());
                    ex.printStackTrace();

                }
            }
            return false;
        }
    }
    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
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
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Frame().setVisible(true);
            }
        });
    }

    
}
