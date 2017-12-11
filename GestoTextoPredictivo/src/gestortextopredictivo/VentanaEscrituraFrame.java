package gestortextopredictivo;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.ArrayList;
import javax.swing.JTextField;

/**
 *
 * @author jcsp0003
 */
public class VentanaEscrituraFrame extends javax.swing.JFrame {

    private final OpcionesFrame opciones;

    /**
     * Constructor por defecto
     */
    public VentanaEscrituraFrame() {
        initComponents();

        this.opciones = new OpcionesFrame();
        opciones.setVisible(true);
        opciones.setResizable(false);

        this.jTextField1.addKeyListener(new KeyListenerImpl(jTextField1));
    }

    /**
     * Realiza una prediccion en base al etxto escrito
     */
    private void hacerPrediccion() {
        this.jTextArea1.setText("");

        ArrayList<Ocurrencia> predicciones = this.opciones.hacerPrediccion(this.jTextField1.getText(),
                this.jTextField1.getText().charAt(this.jTextField1.getText().length()-1)==' '); //Envia todo el texto, habria que enviar menos....
        for (int i = 0; i < predicciones.size(); i++) {
            this.jTextArea1.append(i + 1 + ": " + predicciones.get(i).getPrediccion() + "  -  " + predicciones.get(i).getN() + "\n");
        }
        jTextArea1.setCaretPosition(0);
    }
    
    /**
     * Borra el contenido del jTextArea1
     */
    private void reiniciar(){
        this.jTextArea1.setText("");
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
        jTextArea1.setAutoscrolls(false);
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

    }//GEN-LAST:event_jTextField1ActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTextArea jTextArea1;
    private javax.swing.JTextField jTextField1;
    // End of variables declaration//GEN-END:variables

    /**
     * Listener de escritura
     */
    private class KeyListenerImpl implements KeyListener {

        private final javax.swing.JTextField jTextField1;

        /**
         * Constructor parametrizado
         *
         * @param jTextField1 Zona de escritura
         */
        private KeyListenerImpl(JTextField jTextField1) {
            this.jTextField1 = jTextField1;
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
        public void keyReleased(KeyEvent e) { //CAMBIAR: si hay texto y borro, la prediccion sigue
            if (!"".equals(jTextField1.getText().replaceAll(" ", ""))) {
                hacerPrediccion();
            }else{
                reiniciar();
            }
        }
    }
}
