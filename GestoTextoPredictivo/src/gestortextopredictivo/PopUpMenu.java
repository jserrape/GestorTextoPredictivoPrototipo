/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gestortextopredictivo;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import javax.swing.JFrame;
import javax.swing.JMenuItem;
import javax.swing.JPopupMenu;

/**
 *
 * @author jcsp0003
 */
public class PopUpMenu {

    private JPopupMenu Pmenu;
    private JMenuItem menuItem;

    public PopUpMenu(javax.swing.JTextArea jt) {

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

        jt.addKeyListener(new KeyListener() {
            @Override
            public void keyTyped(KeyEvent e) {
            }

            @Override
            public void keyPressed(KeyEvent e) {
            }

            @Override
            public void keyReleased(KeyEvent e) {
                Pmenu.show(e.getComponent(), 80, 80);
            }

        });
    }
}
