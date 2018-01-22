/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gestortextopredictivo;

import Frame.InterfazFrame;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;
import javax.swing.text.BadLocationException;

/**
 *
 * @author jcsp0003
 */
public class main {

    /**
     * @param args the command line arguments
     * @throws java.io.IOException
     * @throws javax.swing.text.BadLocationException
     */
    public static void main(String[] args) throws IOException, BadLocationException {
        try {
            UIManager.setLookAndFeel("com.jtattoo.plaf.smart.SmartLookAndFeel");
        } catch (ClassNotFoundException | InstantiationException | IllegalAccessException | UnsupportedLookAndFeelException ex) {
            Logger.getLogger(main.class.getName()).log(Level.SEVERE, null, ex);
        }
        InterfazFrame ventana = new InterfazFrame();
        ventana.setVisible(true);
    }

}
