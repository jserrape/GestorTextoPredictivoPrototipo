/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gestortextopredictivo;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.HashMap;
import java.util.Map;

/**
 *
 * @author jcsp0003
 */
public class Predictor {

    private final int tamSemilla;
    private final int tamPrediccion;

    //private final Map<String, Predicciones> almacenSemillas; // Estructura de datos principal, para almacenar las relaciones
    private Map<String, Predicciones>[] almacenesSemillas;

    public Predictor(int tamSemillaa, int tamPrediccionn) {
        this.tamSemilla = tamSemillaa;
        this.tamPrediccion = tamPrediccionn;
        //this.almacenSemillas = new HashMap<>();
        this.almacenesSemillas = new Map[tamSemilla + 1];
        for (int i = 1; i < tamSemilla + 1; i++) {
            almacenesSemillas[i] = new HashMap<>();
        }
    }

    public void insertarTexto(String textoFichero, Consola consola) {
        for (int i = 1; i < tamSemilla + 1; i++) {
            insertarTextoAlmacen(textoFichero, consola, i);
        }
    }

    public void insertarTextoAlmacen(String textoFichero, Consola consola, int almacen) {
        //System.out.println("-------------------------------------------------------------");
        //System.out.println("        COMIENZO CON EL ALMACEN DE TAM " + almacen);
        //System.out.println("-------------------------------------------------------------");
        String conjuntoSemilla;
        String conjuntoPrediccion;
        String[] frases, palabras;
        textoFichero = textoFichero.toLowerCase().replaceAll("[^\\dA-Za-z.á-úÁ-Ú ]", "");
        //System.out.println(textoFichero);
        frases = textoFichero.split("\\.");
        //consola.escribir("    - Detectadas " + frases.length + " frases.");
        for (int i = 0; i < frases.length; i++) {
            palabras = frases[i].split("\\s+");
            //consola.escribir("---------" + frases[i]);
            //consola.escribir(Arrays.toString(palabras));
            //System.out.println("Lectura de la frase:");
            //System.out.println("                                            " + Arrays.toString(palabras));
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
                //System.out.println("       +Semilla: "+conjuntoSemilla);

                //Creo la prediccion
                for (int z = 0; z < tamPrediccion; z++) {
                    if ((j + z + almacen) < palabras.length) {
                        conjuntoPrediccion += " " + palabras[j + z + almacen];
                    }
                }
                conjuntoPrediccion = conjuntoPrediccion.substring(1, conjuntoPrediccion.length());
                //System.out.println("       +Prediccion: "+conjuntoPrediccion);

                //consola.escribir(conjuntoSemilla + "----" + conjuntoPrediccion);
                if (!almacenesSemillas[almacen].containsKey(conjuntoSemilla)) { //Si no esta la semilla la creo vacia, para despues insertar la prediccion
                    almacenesSemillas[almacen].put(conjuntoSemilla, new Predicciones());
                    //System.out.println("            Nueva semilla");
                }
                //AQUI INSERTARÉ LA PREDICCION
                almacenesSemillas[almacen].get(conjuntoSemilla).nuevaPrediccion(conjuntoPrediccion);

                //System.out.println("");
            }
        }
        consola.escribir("    - Detectadas " + almacenesSemillas[almacen].size() + " palabras.");
    }

    public ArrayList<Ocurrencia> enviarPrediccion(String texto) {
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
                    System.out.println("SI ESTO NO SALTA NUNCA, ES QUE ES INNECESARIO");
                }
            }
            semilla = semilla.substring(0, semilla.length() - 1);

            if (almacenesSemillas[i].containsKey(semilla)) {
                System.out.println("Semilla usada: " + semilla);
                for (int z = 0; z < almacenesSemillas[i].get(semilla).getOcurrencias().size(); z++) {
                    arr.add(almacenesSemillas[i].get(semilla).getOcurrencias().get(z));
                    if (arr.size() == 10) {
                        return arr;
                    }
                }
            }
        }

        return arr;
    }

    public void reordenar() {
        QuickSort qui = new QuickSort();
        for (int i = this.tamSemilla; i > 0; i--) {
            almacenesSemillas[i].forEach((k, v) -> qui.sort(v.getOcurrencias()));
        }
    }

}
