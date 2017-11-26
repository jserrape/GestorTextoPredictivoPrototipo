/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gestortextopredictivo;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author jcsp0003
 */
public class Predictor {

    private final int tamSemilla;
    private final int tamPrediccion;

    private Map<String, Predicciones>[] almacenesSemillas;

    public Predictor(int tamSemillaa, int tamPrediccionn) {
        this.tamSemilla = tamSemillaa;
        this.tamPrediccion = tamPrediccionn;

        this.almacenesSemillas = new Map[tamSemilla + 1];
        for (int i = 1; i < tamSemilla + 1; i++) {
            almacenesSemillas[i] = new HashMap<>();
        }
    }

    public void insertarTexto(ArrayList<String> ficheros, javax.swing.JProgressBar jProgressBar1) {
        hiloLectura hiloLec = new hiloLectura(ficheros,ficheros,tamSemilla,tamPrediccion,almacenesSemillas,jProgressBar1); //CAMBIAR Y ENVIAR EL DE URLS
        Thread th = new Thread(hiloLec);
        th.start();
    }

    public void insertarTextoAlmacen(String textoFichero, int almacen) {
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
    }

    public ArrayList<Ocurrencia> enviarPrediccion(String texto) {
        /**
         * AQUI DEBERIA MIRAR LA FRASE Y SI EL ULTIMO CARACTER NO ES " " SIGIFICA QUE LA ULTIMA PALABRA NO ESTA ACABADA
         * PRO LO QUE TENDRIA QUE COMPLETARLA Y DESPUÉS HACER LA PREDICCION NORMAL.
         */
        ArrayList<Ocurrencia> arr = new ArrayList();
        String[] palabras = texto.split("\\s+");
        int limite;
        String semilla;

        for (int i = this.tamSemilla; i > 0; i--) {
            limite = 0;
            semilla = "";
            for (int j = palabras.length - 1; j >= 0; j--) {
                if (!"".equals(palabras[j])) {
                    semilla = palabras[j] + " " + semilla;
                    ++limite;
                    if (limite == i) {
                        if ("".equals(semilla)) {
                            return new ArrayList();
                        }
                        break;
                    }
                } else {
                    System.out.println("SI ESTO NO SALTA NUNCA, ES QUE ES INNECESARIO EL IF");
                }
            }
            semilla = semilla.substring(0, semilla.length() - 1);

            if (almacenesSemillas[i].containsKey(semilla)) {
                System.out.println("Semilla usada: " + semilla);
                for (int z = 0; z < almacenesSemillas[i].get(semilla).getOcurrencias().size(); z++) {
                    arr.add(almacenesSemillas[i].get(semilla).getOcurrencias().get(z));
                }
            }
        }

        return arr;
    }
}
