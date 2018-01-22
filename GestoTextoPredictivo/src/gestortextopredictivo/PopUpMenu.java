/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gestortextopredictivo;

import java.awt.Component;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import javax.swing.JMenuItem;
import javax.swing.JPopupMenu;

/**
 *
 * @author jcsp0003
 */
public class PopUpMenu {

    private final JPopupMenu Pmenu;
    private final javax.swing.JTextArea jt;

    public PopUpMenu(javax.swing.JTextArea jt) {
        this.jt = jt;
        Pmenu = new JPopupMenu();
    }

    public void colocar(Component e, int x, int y, ArrayList<Ocurrencia> predicciones) {
        this.Pmenu.setVisible(false);
        this.Pmenu.removeAll();

        JMenuItem menuItem;
        for (int i = 0; i < predicciones.size(); i++) {
            menuItem = new JMenuItem("(" + predicciones.get(i).getN() + ") " + predicciones.get(i).getPrediccion());
            Pmenu.add(menuItem);
            menuItem.addActionListener(new ActionListenerImpl(jt));
        }

        this.Pmenu.show(e, x, y);
        this.jt.requestFocus();
    }

    private static class ActionListenerImpl implements ActionListener {

        private final javax.swing.JTextArea jt;

        public ActionListenerImpl(javax.swing.JTextArea jt) {
            this.jt = jt;
        }

        @Override
        public void actionPerformed(ActionEvent e) {
            StringBuilder sb = new StringBuilder(jt.getText());
            if (jt.getText().charAt(jt.getCaretPosition() - 1) != ' ') {
                String semilla; //semilla
                if (jt.getCaretPosition() - 10 < 0) {
                    semilla = jt.getText().substring(0, jt.getCaretPosition());
                } else {
                    semilla = jt.getText().substring(jt.getCaretPosition() - 10, jt.getCaretPosition());
                }
                String[] palabras = semilla.split("\\s+");
                String palabraInacabada = palabras[palabras.length - 1];
                String prediccionRecortada = e.getActionCommand().substring(palabraInacabada.length(), e.getActionCommand().length());

                sb.insert(jt.getCaretPosition(), prediccionRecortada + " ");
            } else {
                sb.insert(jt.getCaretPosition(), e.getActionCommand() + " ");
            }
            jt.setText(sb.toString());
        }
    }
}
