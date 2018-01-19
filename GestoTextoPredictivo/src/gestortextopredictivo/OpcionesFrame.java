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
public class OpcionesFrame extends javax.swing.JFrame {

    private final DefaultTableModel modelo;
    private Predictor predictor;

    /**
     * Constructor por defecto
     * @param pred
     */
    public OpcionesFrame(Predictor pred) {
        initComponents();

        setLocationRelativeTo(null);
        
        this.predictor=pred;

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
    
    public OpcionesFrame() { //BORRAR 
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

        jTabbedPane2 = new javax.swing.JTabbedPane();
        jPanel1 = new javax.swing.JPanel();
        jtamPrediccion = new javax.swing.JSpinner();
        jLabel2 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();
        jProgressBar1 = new javax.swing.JProgressBar();
        jButton1 = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();
        jButton3 = new javax.swing.JButton();
        jButton4 = new javax.swing.JButton();
        jButton5 = new javax.swing.JButton();
        jtSemilla = new javax.swing.JSpinner();
        jLabel1 = new javax.swing.JLabel();
        jMinSemilla = new javax.swing.JSpinner();
        jLabel3 = new javax.swing.JLabel();
        jtManPredicciones = new javax.swing.JSpinner();
        jLabel4 = new javax.swing.JLabel();
        jPanel2 = new javax.swing.JPanel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jtamPrediccion.setModel(new javax.swing.SpinnerNumberModel(2, 0, 5, 1));

        jLabel2.setText("Tamaño de la predicción");

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

        jLabel1.setText("Tamaño máximo de la semilla");

        jMinSemilla.setModel(new javax.swing.SpinnerNumberModel(1, 1, 3, 1));

        jLabel3.setText("Tamaño mínimo de la semilla");

        jtManPredicciones.setModel(new javax.swing.SpinnerNumberModel(10, 2, 20, 1));

        jLabel4.setText("Máximo de predicciones");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addGroup(jPanel1Layout.createSequentialGroup()
                                        .addGap(0, 0, Short.MAX_VALUE)
                                        .addComponent(jtSemilla, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addGroup(jPanel1Layout.createSequentialGroup()
                                        .addGap(23, 23, 23)
                                        .addComponent(jtamPrediccion, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel2)
                                    .addComponent(jLabel1))
                                .addGap(72, 72, 72)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addComponent(jMinSemilla, javax.swing.GroupLayout.PREFERRED_SIZE, 39, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jtManPredicciones, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(jButton1)
                                .addGap(68, 68, 68)
                                .addComponent(jButton2)
                                .addGap(0, 0, Short.MAX_VALUE)))
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel4)
                                    .addComponent(jLabel3))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 265, Short.MAX_VALUE))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGap(0, 25, Short.MAX_VALUE)
                                .addComponent(jButton3, javax.swing.GroupLayout.PREFERRED_SIZE, 103, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(65, 65, 65)
                                .addComponent(jButton4, javax.swing.GroupLayout.PREFERRED_SIZE, 74, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(29, 29, 29)
                                .addComponent(jButton5)
                                .addGap(31, 31, 31))))
                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 701, Short.MAX_VALUE)
                        .addComponent(jProgressBar1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                .addContainerGap(0, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(21, 21, 21)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jtSemilla, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel1)
                    .addComponent(jMinSemilla, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel3))
                .addGap(30, 30, 30)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jtamPrediccion, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel2)
                    .addComponent(jtManPredicciones, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel4))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 35, Short.MAX_VALUE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButton1)
                    .addComponent(jButton2)
                    .addComponent(jButton3)
                    .addComponent(jButton4)
                    .addComponent(jButton5))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 175, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jProgressBar1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        jTabbedPane2.addTab("Crear conjunto", jPanel1);

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 730, Short.MAX_VALUE)
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 371, Short.MAX_VALUE)
        );

        jTabbedPane2.addTab("Anteriores conjuntos", jPanel2);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jTabbedPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 735, javax.swing.GroupLayout.PREFERRED_SIZE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jTabbedPane2)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    /**
     * Extrae el texto de las entradas de la tabla y crea la estructura de datos destinada a la predicción
     * @param evt Evento del botón
     */
    private void jButton5ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton5ActionPerformed
        //this.predictor = new Predictor((int) this.jtSemilla.getValue(), (int) this.jtPrediccion.getValue());

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
            extraerPalabrasFichero(ficheros,urls);
    }//GEN-LAST:event_jButton5ActionPerformed

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
        nuevaURLFrame url = new nuevaURLFrame(this, true, this);
        url.setVisible(true);
    }//GEN-LAST:event_jButton3ActionPerformed

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
     * Extrae el texto de los ficheros de un array
     * @param ficheros Array con los ficheros pdf
     */
    private void extraerPalabrasFichero(ArrayList<String> ficheros,ArrayList<String> urls) {
        if (!ficheros.isEmpty() || !urls.isEmpty()) {
            predictor.ajustarTam(getTamSemilla(), getTamPrediccion(), getTMaxPredicciones());
            predictor.insertarTexto(ficheros,urls, jProgressBar1);
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
    public int getTamSemilla() {
        return (int) this.jtSemilla.getValue();
    }
    
    public int getTamPrediccion() {
        return (int) this.jtamPrediccion.getValue();
    }
    
    public int getTMaxPredicciones() {
        return (int) this.jtManPredicciones.getValue();
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton3;
    private javax.swing.JButton jButton4;
    private javax.swing.JButton jButton5;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JSpinner jMinSemilla;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JProgressBar jProgressBar1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTabbedPane jTabbedPane2;
    private javax.swing.JTable jTable1;
    private javax.swing.JSpinner jtManPredicciones;
    private javax.swing.JSpinner jtSemilla;
    private javax.swing.JSpinner jtamPrediccion;
    // End of variables declaration//GEN-END:variables
}
