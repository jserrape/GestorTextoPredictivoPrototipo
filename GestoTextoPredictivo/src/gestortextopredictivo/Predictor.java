package gestortextopredictivo;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

/**
 *
 * @author jcsp0003
 */
public class Predictor {

    private final int tamSemilla;
    private final int tamPrediccion;

    private final Map<String, ArrayList<Ocurrencia>>[] almacenesSemillas;

    /**
     * Constructor parametrizado
     *
     * @param tamSemilla Tamaño máximo de la semilla
     * @param tamPrediccion Tamaño de la predicción
     */
    public Predictor(int tamSemilla, int tamPrediccion) {
        this.tamSemilla = tamSemilla;
        this.tamPrediccion = tamPrediccion;

        this.almacenesSemillas = new Map[tamSemilla + 1];
        for (int i = 1; i < tamSemilla + 1; i++) {
            almacenesSemillas[i] = new HashMap<>();
        }
    }

    /**
     * Crea un hilo para la lectura de los ficheros y las urls
     *
     * @param ficheros Array con las direcciones de los distinos ficheros pdf
     * @param urls
     * @param jProgressBar1 Barra de progreso
     */
    public void insertarTexto(ArrayList<String> ficheros,ArrayList<String> urls, javax.swing.JProgressBar jProgressBar1) { //AÑADIR AQUI LA URL TAMBIEN
        hiloLectura hiloLec = new hiloLectura(ficheros, urls, tamSemilla, tamPrediccion, almacenesSemillas, jProgressBar1); //CAMBIAR Y ENVIAR EL DE URLS
        Thread th = new Thread(hiloLec);
        th.start();
    }

    /**
     *
     * @param textoFichero
     * @param almacen
     */
    public void insertarTextoAlmacen(String textoFichero, int almacen) {
        String conjuntoSemilla;
        String conjuntoPrediccion;
        String[] frases, palabras;
        textoFichero = textoFichero.toLowerCase().replaceAll("[^\\dA-Za-z.á-úÁ-Ú ]", "");

        frases = textoFichero.split("\\.");

        for (String frase : frases) {
            palabras = frase.split("\\s+");
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
                    almacenesSemillas[almacen].put(conjuntoSemilla, new ArrayList());
                }
                //AQUI INSERTARÉ LA PREDICCION
                nuevaPrediccion(almacenesSemillas[almacen].get(conjuntoSemilla), conjuntoPrediccion);
            }
        }
    }

    /**
     *
     * @param texto
     * @param completa Valor que indica si la última palabra de la semilla ha
     * sido terminada de escribir
     * @return
     */
    public ArrayList<Ocurrencia> enviarPrediccion(String texto, boolean completa) {
        if (completa) {
            ArrayList<Ocurrencia> arr = new ArrayList();
            String[] palabras = texto.split("\\s+");
            int limite;
            String semilla;

            for (int i = this.tamSemilla; i > 0; i--) {
                arr.add(new Ocurrencia("---------Semilla tamaño: " + i + "  -----------"));
                limite = 0;
                semilla = "";
                for (int j = palabras.length - 1; j >= 0; j--) {
                    semilla = palabras[j] + " " + semilla;
                    ++limite;
                    if (limite == i) {
                        if ("".equals(semilla)) {
                            return new ArrayList();
                        }
                        break;
                    }
                }
                semilla = semilla.substring(0, semilla.length() - 1);

                if (almacenesSemillas[i].containsKey(semilla)) {
                    for (int z = 0; z < almacenesSemillas[i].get(semilla).size(); z++) {
                        arr.add(almacenesSemillas[i].get(semilla).get(z));
                        //if(arr.size()==15){
                        //return arr;
                        //}
                    }
                }
            }
            return arr;
        } else {
            ArrayList<Ocurrencia> arr = new ArrayList();
            String[] palabras = texto.split("\\s+");
            int limite;
            String semillaBase, semillaInacabada;
            for (int i = this.tamSemilla; i > 0; i--) {
                arr.add(new Ocurrencia("---------Semilla tamaño: " + i + "  -----------"));
                limite = 0;
                semillaBase = "";
                semillaInacabada = palabras[palabras.length - 1];
                for (int j = palabras.length - 2; j >= 0; j--) {
                    semillaBase = palabras[j] + " " + semillaBase;
                    ++limite;
                    if (limite == i) {
                        if ("".equals(semillaBase)) {
                            return new ArrayList();
                        }
                        break;
                    }
                }
                if (!"".equals(semillaBase)) { // Situación semillaBase no nula
                    semillaBase = semillaBase.substring(0, semillaBase.length() - 1);
                    if (almacenesSemillas[i].containsKey(semillaBase)) {
                        for (int j = 0; j < almacenesSemillas[i].get(semillaBase).size(); j++) {
                            if (almacenesSemillas[i].get(semillaBase).get(j).getPrediccion().indexOf(semillaInacabada) == 0) {
                                arr.add(almacenesSemillas[i].get(semillaBase).get(j));
                            }
                        }
                    }
                }
            }
            return arr;
        }
    }

    /**
     * Crea una nueva prediccion
     *
     * @param arr
     * @param pred Texto de la prediccion
     */
    public void nuevaPrediccion(ArrayList<Ocurrencia> arr, String pred) {
        for (int i = 0; i < arr.size(); i++) {
            if (arr.get(i).getPrediccion().equals(pred)) {
                arr.get(i).nuevaOcurrencia();
                return;
            }
        }
        arr.add(new Ocurrencia(pred));
    }
}
