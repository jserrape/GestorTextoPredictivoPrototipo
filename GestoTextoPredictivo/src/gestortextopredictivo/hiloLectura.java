/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gestortextopredictivo;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Map;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author jcsp0003
 */
public class hiloLectura implements Runnable {

    private final ArrayList<String> ficheros;
    private final ArrayList<String> urls;
    private final int tamSemilla;
    private final int tamPrediccion;
    private final Map<String, Predicciones>[] almacenesSemillas;
    private final javax.swing.JProgressBar jProgressBar1;

    public hiloLectura(ArrayList<String> ficheros, ArrayList<String> urls, int tamSemilla, int tamPrediccion, Map<String, Predicciones>[] almacenesSemillas, javax.swing.JProgressBar jProgressBar1) {
        this.ficheros = ficheros;
        this.urls = urls;
        this.tamSemilla = tamSemilla;
        this.tamPrediccion = tamPrediccion;
        this.almacenesSemillas = almacenesSemillas;
        this.jProgressBar1 = jProgressBar1;
    }

    @Override
    public void run() {
        jProgressBar1.setValue(0);
        int cont=100/ficheros.size();
        lecturaInfo lectura = new lecturaInfo();
        for (int x = 0; x < ficheros.size(); x++) {
            try {
                for (int i = 1; i < tamSemilla + 1; i++) {
                    lecturaFichero(lectura.lectura("pdf", ficheros.get(x)), i);
                }
            } catch (IOException ex) {
                Logger.getLogger(Opciones.class.getName()).log(Level.SEVERE, null, ex);
            }
            jProgressBar1.setValue(jProgressBar1.getValue()+cont);
        }
        System.out.println("Fin del hilo");
        jProgressBar1.setValue(100);
    }

    private void lecturaFichero(String textoFichero, int almacen) {
        String conjuntoSemilla;
        String conjuntoPrediccion;
        String[] frases, palabras;
        textoFichero = textoFichero.toLowerCase().replaceAll("[^\\dA-Za-z.á-úÁ-Ú ]", "");

        frases = textoFichero.split("\\.");

        for (int i = 0; i < frases.length; i++) {
            palabras = frases[i].split("\\s+");

            for (int j = 0; j < palabras.length - almacen; j++) { //<--- Antes la primera palabra me la tomaba como "", comprobar
                if ("".equals(palabras[j])) {
                    //continue;
                }
                conjuntoSemilla = "";
                conjuntoPrediccion = "";

                //Creo la semilla
                for (int z = 0; z < almacen; z++) {
                    conjuntoSemilla += " " + palabras[j + z];
                }
                conjuntoSemilla = conjuntoSemilla.substring(1, conjuntoSemilla.length());

                //Creo la prediccion
                for (int z = 0; z < tamPrediccion; z++) {
                    if ((j + z + almacen) < palabras.length) {
                        conjuntoPrediccion += " " + palabras[j + z + almacen];
                    }
                }
                conjuntoPrediccion = conjuntoPrediccion.substring(1, conjuntoPrediccion.length());

                if (!almacenesSemillas[almacen].containsKey(conjuntoSemilla)) { //Si no esta la semilla la creo vacia, para despues insertar la prediccion
                    almacenesSemillas[almacen].put(conjuntoSemilla, new Predicciones());
                }
                //AQUI INSERTARÉ LA PREDICCION
                almacenesSemillas[almacen].get(conjuntoSemilla).nuevaPrediccion(conjuntoPrediccion);

                //System.out.println("");
            }
        }
        //consola.escribir("    - Detectadas " + almacenesSemillas[almacen].size() + " palabras.");
    }

}
