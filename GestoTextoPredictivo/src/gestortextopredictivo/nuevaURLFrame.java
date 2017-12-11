/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gestortextopredictivo;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import javax.swing.JButton;
import org.apache.commons.validator.UrlValidator;

/**
 *
 * @author jcsp0003
 */
public class nuevaURLFrame extends javax.swing.JDialog {

    private final OpcionesFrame op;

    /**
     * Constructor parametrizado
     *
     * @param parent Objeto Frame padre: Opciones
     * @param modal Valor modal
     * @param Opp Objeto padre: Opciones
     */
    public nuevaURLFrame(java.awt.Frame parent, boolean modal, OpcionesFrame Opp) {
        super(parent, modal);
        initComponents();

        setLocationRelativeTo(null);
        this.op = Opp;

        this.jTextField1.addKeyListener(new KeyListenerImpl(jButton1, jTextField1));
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jTextField1 = new javax.swing.JTextField();
        jLabel1 = new javax.swing.JLabel();
        jButton1 = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        jTextField1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextField1ActionPerformed(evt);
            }
        });

        jLabel1.setText("Anadir nueva url:");

        jButton1.setText("Aceptar");
        jButton1.setEnabled(false);
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        jButton2.setText("Cancelar");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel1)
                    .addComponent(jTextField1, javax.swing.GroupLayout.PREFERRED_SIZE, 546, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(layout.createSequentialGroup()
                .addGap(68, 68, 68)
                .addComponent(jButton1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jButton2)
                .addGap(67, 67, 67))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jTextField1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButton1)
                    .addComponent(jButton2))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    /**
     * Cierra el JDialog
     * @param evt Evento de pulsar el botón
     */
    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        this.dispose();
    }//GEN-LAST:event_jButton2ActionPerformed

    /**
     * Cierra el JDialog y crea una entrada con la url en la tabla de Opciones
     * @param evt Evento de pulsar el botón
     */
    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        this.op.nuevaFila("URL", this.jTextField1.getText());
        this.dispose();
    }//GEN-LAST:event_jButton1ActionPerformed

    private void jTextField1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextField1ActionPerformed

    }//GEN-LAST:event_jTextField1ActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JTextField jTextField1;
    // End of variables declaration//GEN-END:variables

    /**
     * Listener del jTextField1
     */
    private static class KeyListenerImpl implements KeyListener {

        private final javax.swing.JButton jButton;
        private final javax.swing.JTextField jTextField;

        /**
         * Consructor parametrizado
         * @param jButton1 Boton "Aceptar"
         * @param jTextField1 Zona de escritura de texto
         */
        private KeyListenerImpl(JButton jButton1, javax.swing.JTextField jTextField1) {
            this.jButton = jButton1;
            this.jTextField = jTextField1;
        }

        /**
         * Listener que sucede al: al pulsar y soltar la tecla.
         * @param e Evento sucedido
         */
        @Override
        public void keyTyped(KeyEvent e) {
        }

        /**
         * Listener que sucede al: al pulsar la tecla.
         * @param e Evento sucedido
         */
        @Override
        public void keyPressed(KeyEvent e) {
        }

        /**
         * Listener que sucede al: al soltar la tecla.
         * @param e Evento sucedido
         */
        @Override
        public void keyReleased(KeyEvent e) {
            UrlValidator validar = new UrlValidator();
            this.jTextField.setText(this.jTextField.getText().replaceAll("\\s", ""));

            /*
            if (validar.isValid(this.jTextField.getText())) {
                this.jButton.setEnabled(true);
            } else {
                this.jButton.setEnabled(false);
            }*/
            this.jButton.setEnabled(true);
        }
    }
}
