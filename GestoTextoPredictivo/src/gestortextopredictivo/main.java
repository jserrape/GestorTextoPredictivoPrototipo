/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gestortextopredictivo;

import java.io.IOException;
import javax.swing.text.BadLocationException;

/**
 *
 * @author jcsp0003
 */
public class main {

    /**
     * @param args the command line arguments
     * @throws java.io.IOException
     */
    public static void main(String[] args) throws IOException, BadLocationException {
        //VentanaEscritura ventana = new VentanaEscritura();
        //ventana.setVisible(true);
        
        InterfazFrame ventana = new InterfazFrame();
        ventana.setVisible(true);
    }

}
