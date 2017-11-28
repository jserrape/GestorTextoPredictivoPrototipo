/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gestortextopredictivo;

import java.io.File;
import java.util.ArrayList;
import javax.swing.JFileChooser;
import javax.swing.JLabel;
import javax.swing.filechooser.FileNameExtensionFilter;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableColumnModel;

/**
 *
 * @author jcsp0003
 */
public class Opciones extends javax.swing.JFrame {

    private final DefaultTableModel modelo;
    private Predictor predictor;

    /**
     * Constructor por defecto
     */
    public Opciones() {
        initComponents();

        setLocationRelativeTo(null);

        modelo = new DefaultTableModel();
        modelo.addColumn("Tipo");
        modelo.addColumn("Dirección");
        this.jTable1.setModel(modelo);
        DefaultTableCellRenderer centerRenderer = new DefaultTableCellRenderer();
        centerRenderer.setHorizontalAlignment(JLabel.CENTER);
        this.jTable1.getColumnModel().getColumn(0).setCellRenderer(centerRenderer);
        TableColumnModel cm = this.jTable1.getColumnModel();
        cm.getColumn(1).setPreferredWidth(450);
    }

    /**
     * Busca predicciones de etxto en función de una semilla
     * @param frase Texto escrito hasa el momento
     * @param completada Valor que indica si la última palabra de la semilla ha sido terminada de escribir
     * @return Array con las predicciones
     */
    public ArrayList<Ocurrencia> hacerPrediccion(String frase,boolean completada) {
        return predictor.enviarPrediccion(frase,completada);
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane1 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();
        jButton1 = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();
        jButton3 = new javax.swing.JButton();
        jButton4 = new javax.swing.JButton();
        jButton5 = new javax.swing.JButton();
        jtSemilla = new javax.swing.JSpinner();
        jLabel1 = new javax.swing.JLabel();
        jtPrediccion = new javax.swing.JSpinner();
        jLabel2 = new javax.swing.JLabel();
        jProgressBar1 = new javax.swing.JProgressBar();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jTable1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {},
                {},
                {},
                {}
            },
            new String [] {

            }
        ));
        jScrollPane1.setViewportView(jTable1);

        jButton1.setText("Nuevo fichero");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        jButton2.setText("Nuevo directorio");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });

        jButton3.setText("Nuevo html");
        jButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton3ActionPerformed(evt);
            }
        });

        jButton4.setText("Borrar");
        jButton4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton4ActionPerformed(evt);
            }
        });

        jButton5.setText("Aceptar");
        jButton5.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton5ActionPerformed(evt);
            }
        });

        jtSemilla.setModel(new javax.swing.SpinnerNumberModel(3, 0, 5, 1));

        jLabel1.setText("Tamaño de la semilla");

        jtPrediccion.setModel(new javax.swing.SpinnerNumberModel(2, 0, 5, 1));

        jLabel2.setText("Tamaño de la predicción");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jProgressBar1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 519, Short.MAX_VALUE)
                    .addComponent(jScrollPane1)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(13, 13, 13)
                        .addComponent(jtSemilla, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabel1)
                        .addGap(46, 46, 46)
                        .addComponent(jtPrediccion, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabel2)
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jButton1)
                        .addGap(18, 18, 18)
                        .addComponent(jButton2)
                        .addGap(18, 18, 18)
                        .addComponent(jButton3, javax.swing.GroupLayout.PREFERRED_SIZE, 103, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jButton4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGap(18, 18, 18)
                        .addComponent(jButton5)))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jtSemilla, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel1)
                    .addComponent(jtPrediccion, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel2))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButton1)
                    .addComponent(jButton2)
                    .addComponent(jButton3)
                    .addComponent(jButton4)
                    .addComponent(jButton5))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 175, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jProgressBar1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    /**
     * Selecciona un fichero del ordenador y almacena la ruta en la tabla
     * @param evt Evento del botón
     */
    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        FileNameExtensionFilter filter = new FileNameExtensionFilter(".pdf", "pdf", "text");
        JFileChooser chooser = new JFileChooser();

        chooser.setFileFilter(filter);
        chooser.setCurrentDirectory(new java.io.File("."));
        chooser.setDialogTitle("choosertitle");
        chooser.setFileSelectionMode(JFileChooser.FILES_ONLY);
        chooser.setAcceptAllFileFilterUsed(false);

        if (chooser.showOpenDialog(null) == JFileChooser.APPROVE_OPTION) {
            this.nuevaFila("Fichero", chooser.getSelectedFile().toString());
        }
    }//GEN-LAST:event_jButton1ActionPerformed

    /**
     * Selecciona un directorio del ordenador y almacena la ruta en la tabla
     * @param evt Evento del botón
     */
    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        JFileChooser chooser = new JFileChooser();

        chooser.setCurrentDirectory(new java.io.File("."));
        chooser.setDialogTitle("choosertitle");
        chooser.setFileSelectionMode(JFileChooser.DIRECTORIES_ONLY);
        chooser.setAcceptAllFileFilterUsed(false);

        if (chooser.showOpenDialog(null) == JFileChooser.APPROVE_OPTION) {
            this.nuevaFila("Directorio", chooser.getSelectedFile().toString());
        } else {
            System.out.println("No Selection ");
        }
    }//GEN-LAST:event_jButton2ActionPerformed

    /**
     * Elimina una entrada seleccionada de la tabla
     * @param evt Evento del botón
     */
    private void jButton4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton4ActionPerformed
        int filaselecionada = jTable1.getSelectedRow();
        if (filaselecionada >= 0) {
            modelo.removeRow(filaselecionada);
        }
    }//GEN-LAST:event_jButton4ActionPerformed

    /**
     * Crea un JDialog para añadir una url válida a la tabla
     * @param evt Evento del botón
     */
    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton3ActionPerformed
        nuevaURL url = new nuevaURL(this, true, this);
        url.setVisible(true);
    }//GEN-LAST:event_jButton3ActionPerformed

    
    /**
     * Extrae el texto de las entradas de la tabla y crea la estructura de datos destinada a la predicción
     * @param evt Evento del botón
     */
    private void jButton5ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton5ActionPerformed
        this.predictor = new Predictor((int) this.jtSemilla.getValue(), (int) this.jtPrediccion.getValue());

        ArrayList<String> ficheros = new ArrayList();
        ArrayList<String> urls = new ArrayList();
        int index;

        for (int i = 0; i < modelo.getRowCount(); i++) {
            switch (modelo.getValueAt(i, 0).toString()) {
                case "Fichero":
                    if (!ficheros.contains(modelo.getValueAt(i, 1).toString())) {
                        ficheros.add(modelo.getValueAt(i, 1).toString());
                    }
                    break;
                case "Directorio":
                    File f = new File(modelo.getValueAt(i, 1).toString());
                    if (f.exists()) {
                        File[] fich = f.listFiles();
                        for (File fich1 : fich) {
                            index = fich1.getName().lastIndexOf('.');
                            if (index != -1) {
                                if (".pdf".equals(fich1.getName().substring(index, fich1.getName().length()).toLowerCase())) {
                                    if (!ficheros.contains(modelo.getValueAt(i, 1).toString() + "\\" + fich1.getName())) {
                                        ficheros.add(modelo.getValueAt(i, 1).toString() + "\\" + fich1.getName());
                                    }
                                }
                            }
                        }
                    }
                    break;
                case "URL":
                    urls.add(modelo.getValueAt(i, 1).toString());
                    break;
            }
        }
        extraerPalabrasFichero(ficheros);
    }//GEN-LAST:event_jButton5ActionPerformed

    /**
     * Extrae el texto de los ficheros de un array
     * @param ficheros Array con los ficheros pdf
     */
    private void extraerPalabrasFichero(ArrayList<String> ficheros) {
        if (!ficheros.isEmpty()) {
            predictor.insertarTexto(ficheros, jProgressBar1);
        }
    }

    /**
     * Añade una fila a la abla 
     * @param tipo "fichero" o "directorio"
     * @param ruta Ruta del documento
     */
    public void nuevaFila(String tipo, String ruta) {
        String[] datos = new String[2];
        datos[0] = tipo;
        datos[1] = ruta;
        modelo.addRow(datos);
    }

    /**
     * Devuelve el valor del tamaño de la semilla seleccionado pro el usuario
     * @return Valor del tamaño de la semilla
     */
    public int tamSemilla() {
        return (int) this.jtSemilla.getValue();
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton3;
    private javax.swing.JButton jButton4;
    private javax.swing.JButton jButton5;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JProgressBar jProgressBar1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable jTable1;
    private javax.swing.JSpinner jtPrediccion;
    private javax.swing.JSpinner jtSemilla;
    // End of variables declaration//GEN-END:variables
}
