/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gestortextopredictivo;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.ArrayList;
import java.util.Arrays;

/**
 *
 * @author jcsp0003
 */
public class VentanaEscritura extends javax.swing.JFrame {

    private final Consola consola;
    private final Opciones opciones;

    /**
     * Creates new form VentanaEscritura
     */
    public VentanaEscritura() {
        initComponents();

        this.consola = new Consola();
        consola.setVisible(true);

        this.opciones = new Opciones(consola);
        opciones.setVisible(true);
        opciones.setResizable(false);
        
        this.jTextField1.addKeyListener(new KeyListener(){

            @Override
            public void keyTyped(KeyEvent e) {
                
            }

            @Override
            public void keyPressed(KeyEvent e) {
                
            }

            @Override
            public void keyReleased(KeyEvent e) {
                if (Character.isSpaceChar(e.getKeyChar())){
                    hacerPrediccion();
                }
            }
        });
    }

    private void hacerPrediccion() {
        this.jTextArea1.setText("");
        int limite=0;
        String semilla="";
        String[] texto= this.jTextField1.getText().split("\\s+");
        for(int i=texto.length-1;i>=0;i--){
            if(!"".equals(texto[i])){
                semilla= texto[i]+" "+semilla;
                ++limite;
                if(limite==this.opciones.tamSemilla()){
                    break;
                }
            }
        }
        semilla = semilla.substring(0, semilla.length()-1);
        this.consola.escribir("semilla:-" +semilla+"-");
        ArrayList<Ocurrencia> predicciones = this.opciones.hacerPrediccion(semilla);
        for(int i=0;i<predicciones.size();i++){
            this.jTextArea1.append(i+1+": "+predicciones.get(i).getPrediccion()+"  -  "+predicciones.get(i).getN()+"\n");
        }
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jTextField1 = new javax.swing.JTextField();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTextArea1 = new javax.swing.JTextArea();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jTextField1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextField1ActionPerformed(evt);
            }
        });

        jTextArea1.setColumns(20);
        jTextArea1.setRows(5);
        jScrollPane1.setViewportView(jTextArea1);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jTextField1)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 380, Short.MAX_VALUE))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jTextField1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 303, Short.MAX_VALUE)
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jTextField1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextField1ActionPerformed
        // TODO add your handling code here:
        hacerPrediccion();
    }//GEN-LAST:event_jTextField1ActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTextArea jTextArea1;
    private javax.swing.JTextField jTextField1;
    // End of variables declaration//GEN-END:variables
}
