/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gestortextopredictivo;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/**
 *
 * @author jcsp0003
 */
public class Predictor {

    private final int tamSemilla;
    private final int tamPrediccion;

    private final Map<String, Predicciones> almacenSemillas; // Estructura de datos principal, para almacenar las relaciones

    public Predictor(int tamSemillaa, int tamPrediccionn) {
        this.tamSemilla = tamSemillaa;
        this.tamPrediccion = tamPrediccionn;
        this.almacenSemillas = new HashMap<>();
    }

    public void insertarTexto(String textoFichero, Consola consola) {
        String conjuntoSemilla;
        String conjuntoPrediccion;
        String[] frases, palabras;
        textoFichero = textoFichero.toLowerCase().replaceAll("[^\\dA-Za-z.á-úÁ-Ú ]", "");
        System.out.println(textoFichero);
        frases = textoFichero.split("\\.");
        consola.escribir("    - Detectadas " + frases.length + " frases.");
        for (int i = 0; i < frases.length; i++) {
            palabras = frases[i].split("\\s+");
            consola.escribir("---------" + frases[i]);
            consola.escribir(Arrays.toString(palabras));

            for (int j = 1; j < palabras.length - tamSemilla; j++) { //<--- Antes la primera palabra me la tomaba como "", comprobar
                conjuntoSemilla = "";
                conjuntoPrediccion = "";
                //Creo la semilla
                for (int z = 0; z < tamSemilla; z++) {
                    conjuntoSemilla += " " + palabras[j + z];
                }
                conjuntoSemilla = conjuntoSemilla.substring(1, conjuntoSemilla.length());

                //Creo la prediccion
                for (int z = 0; z < tamPrediccion; z++) {
                    if ((j + z + tamSemilla) < palabras.length) {
                        conjuntoPrediccion += " " + palabras[j + z + tamSemilla];
                    }
                }
                conjuntoPrediccion = conjuntoPrediccion.substring(1, conjuntoPrediccion.length());

                //consola.escribir(conjuntoSemilla + "----" + conjuntoPrediccion);

                if (!almacenSemillas.containsKey(conjuntoSemilla)) { //Si no esta la semilla la creo vacia, para despues insertar la prediccion
                    almacenSemillas.put(conjuntoSemilla, new Predicciones());
                }
                //AQUI INSERTARÉ LA PREDICCION
                almacenSemillas.get(conjuntoSemilla).nuevaPrediccion(conjuntoPrediccion);
            }
        }
        consola.escribir("    - Detectadas " + almacenSemillas.size() + " palabras.");
    }

}
