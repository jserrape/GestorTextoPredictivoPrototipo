/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gestortextopredictivo;

import java.io.IOException;

/**
 *
 * @author jcsp0003
 */
public class main {

    /**
     * @param args the command line arguments
     * @throws java.io.IOException
     */
    public static void main(String[] args) throws IOException {
        Consola consola = new Consola();
        consola.setVisible(true);

        Opciones opciones = new Opciones(consola);
        opciones.setVisible(true);
        opciones.setResizable(false);
         
    }


}
