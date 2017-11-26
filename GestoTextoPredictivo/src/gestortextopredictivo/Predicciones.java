/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gestortextopredictivo;

import java.util.ArrayList;

/**
 *
 * @author jcsp0003
 */
public class Predicciones {

    private int N;
    private final ArrayList<Ocurrencia> ocurrencias;

    /**
     * Construcor por defecto
     */
    public Predicciones() {
        this.N = 0;
        this.ocurrencias = new ArrayList();
    }

    /**
     * Crea una nueva prediccion
     * @param pred Texto de la prediccion
     */
    public void nuevaPrediccion(String pred) {
        ++N;
        for (int i = 0; i < getOcurrencias().size(); i++) {
            if (getOcurrencias().get(i).getPrediccion().equals(pred)) {
                getOcurrencias().get(i).nuevaOcurrencia();
                return;
            }
        }
        getOcurrencias().add(new Ocurrencia(pred));
    }

    /**
     * Devuelve el numero de predicciones de la semilla
     * @return Numero de predicciones
     */
    public int getN() {
        return N;
    }

    /**
     * Devuelve las predicciones de la semilla
     * @return Predicciones de la semilla
     */
    public ArrayList<Ocurrencia> getOcurrencias() {
        return ocurrencias;
    }
}
