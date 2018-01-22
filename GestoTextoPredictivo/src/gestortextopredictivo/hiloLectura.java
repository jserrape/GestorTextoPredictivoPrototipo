package gestortextopredictivo;

import Frame.OpcionesFrame;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
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
    private final Map<String, ArrayList<Ocurrencia>>[] almacenesSemillas;
    private final javax.swing.JProgressBar jProgressBar1;
    private final Predictor predictor;

    /**
     * Constructor parametrizado
     *
     * @param ficheros Array con los ficheros
     * @param urls Array con las urls
     * @param tamSemilla Tamaño de la semilla máxima
     * @param tamPrediccion Tamaño de la predicción
     * @param almacenesSemillas Estructura de almacenamiento de las predicciones
     * @param jProgressBar1 Barra de progreso de la lectura.
     */
    public hiloLectura(ArrayList<String> ficheros, ArrayList<String> urls, int tamSemilla, int tamPrediccion,
            Map<String, ArrayList<Ocurrencia>>[] almacenesSemillas, javax.swing.JProgressBar jProgressBar1, Predictor pred) {
        this.ficheros = ficheros;
        this.urls = urls;
        this.tamSemilla = tamSemilla;
        this.tamPrediccion = tamPrediccion;
        this.almacenesSemillas = almacenesSemillas;
        this.jProgressBar1 = jProgressBar1;
        this.predictor = pred;
    }

    /**
     * Extrae las predicciones de los ficheros/urls y las almacena
     */
    @Override
    public void run() {
        jProgressBar1.setValue(0);
        int cont = 95 / (ficheros.size() + urls.size());
        lecturaDatos lectura = new lecturaDatos();

        //Lectura de los ficheros pdf
        for (int x = 0; x < ficheros.size(); x++) {
            try {
                for (int i = 1; i < tamSemilla + 1; i++) {
                    lecturaFichero(lectura.lectura("pdf", ficheros.get(x)), i);
                }
            } catch (IOException ex) {
                Logger.getLogger(OpcionesFrame.class.getName()).log(Level.SEVERE, null, ex);
            }
            jProgressBar1.setValue(jProgressBar1.getValue() + cont);
        }

        //Lectura de las urls
        for (int x = 0; x < urls.size(); x++) {
            try {
                for (int i = 1; i < tamSemilla + 1; i++) {
                    lecturaFichero(lectura.lectura("url", urls.get(x)), i);
                }
            } catch (IOException ex) {
                Logger.getLogger(OpcionesFrame.class.getName()).log(Level.SEVERE, null, ex);
            }
            jProgressBar1.setValue(jProgressBar1.getValue() + cont);
        }

        jProgressBar1.setValue(95);

        for (int i = this.tamSemilla; i > 0; i--) {
            almacenesSemillas[i].forEach((k, v) -> Collections.sort(v, (Ocurrencia o1, Ocurrencia o2) -> Integer.valueOf(o2.getN()).compareTo(o1.getN())));
        }

        try {
            this.predictor.seriabilizarClase();
        } catch (IOException ex) {
            Logger.getLogger(hiloLectura.class.getName()).log(Level.SEVERE, null, ex);
        }

        jProgressBar1.setValue(100);
        try {
            crearDataSet(ficheros, urls);
        } catch (IOException ex) {
            Logger.getLogger(hiloLectura.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    /**
     * Extrae las predicciones de un texo y lo almacena en un almacen
     * determinado
     *
     * @param textoFichero Texto extraido de un fichero
     * @param almacen Número del almacen
     */
    private void lecturaFichero(String textoFichero, int almacen) {
        String conjuntoSemilla;
        String conjuntoPrediccion;
        String[] frases, palabras;
        textoFichero = textoFichero.toLowerCase().replaceAll("[^\\dA-Za-z.á-úÁ-Ú ]", "");

        frases = textoFichero.split("\\.");

        for (String frase : frases) {
            palabras = frase.split("\\s+");
            for (int j = 0; j < palabras.length - almacen; j++) {
                if ("".equals(palabras[j])) {
                    continue;
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
     * Crea una nueva prediccion
     *
     * @param arr
     * @param pred Texto de la prediccion
     */
    private void nuevaPrediccion(ArrayList<Ocurrencia> arr, String pred) {
        for (int i = 0; i < arr.size(); i++) {
            if (arr.get(i).getPrediccion().equals(pred)) {
                arr.get(i).nuevaOcurrencia();
                return;
            }
        }
        arr.add(new Ocurrencia(pred));
    }

    private void crearDataSet(ArrayList<String> ficheros, ArrayList<String> urls) throws IOException {
        java.util.Date utilDate = new java.util.Date();
        String[] fecha = utilDate.toString().split(" ");

        String ruta = "./dataSet/" + fecha[0] + "-" + fecha[2] + "-" + fecha[1] + "-" + fecha[3].replaceAll(":", "_");
        File archivo = new File(ruta);
        BufferedWriter bw;
        bw = new BufferedWriter(new FileWriter(archivo));

        for (int i = 0; i < ficheros.size(); i++) {
            bw.write("fichero###" + ficheros.get(i));
            bw.newLine();
        }
        for (int i = 0; i < urls.size(); i++) {
            bw.write("url###" + urls.get(i));
            bw.newLine();
        }
        bw.close();
    }

}
