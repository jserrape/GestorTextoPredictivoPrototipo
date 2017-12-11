/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gestortextopredictivo;

import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.font.FontRenderContext;
import java.awt.geom.AffineTransform;
import javax.swing.JMenuItem;
import javax.swing.JPopupMenu;
import javax.swing.JTextArea;

/**
 *
 * @author jcsp0003
 */
public class PopUpMenu {

    private final JPopupMenu Pmenu;
    private JMenuItem menuItem;
    private final KeyListenerImpl liste;

    public PopUpMenu(javax.swing.JTextArea jt, Font font) {

        Pmenu = new JPopupMenu();
        menuItem = new JMenuItem("Predicción 1");
        Pmenu.add(menuItem);
        menuItem = new JMenuItem("Predicción 2");
        Pmenu.add(menuItem);
        menuItem = new JMenuItem("Predicción 3");
        Pmenu.add(menuItem);
        menuItem = new JMenuItem("Predicción 4");
        Pmenu.add(menuItem);
        menuItem = new JMenuItem("Predicción 5");
        Pmenu.add(menuItem);
        menuItem.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
            }
        });

        liste = new KeyListenerImpl(jt, font);
        jt.addKeyListener(liste);
    }

    public void cambiarFuente(Font f){
        this.liste.cambiarFuente(f);
    }

    private class KeyListenerImpl implements KeyListener {

        private final JTextArea jt;
        private Font font;

        public KeyListenerImpl(JTextArea jt, Font font) {
            this.jt = jt;
            this.font = font;
        }

        public void cambiarFuente(Font f) {
            this.font = f;
        }

        @Override
        public void keyTyped(KeyEvent e) {
        }

        @Override
        public void keyPressed(KeyEvent e) {
        }

        @Override
        public void keyReleased(KeyEvent e) {
            String text = jt.getText();

            AffineTransform affinetransform = new AffineTransform();
            FontRenderContext frc = new FontRenderContext(affinetransform, true, true);
            int textwidth = (int) (font.getStringBounds(text, frc).getWidth());
            int textheight = (int) (font.getStringBounds(text, frc).getHeight());

            System.out.println(this.jt.getCaretPosition());
            Pmenu.show(e.getComponent(), textwidth, textheight);
            this.jt.requestFocus();
        }
    }
}
