/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gestortextopredictivo;

import java.io.Serializable;

/**
 *
 * @author jcsp0003
 */
public class Ocurrencia implements Serializable{

    private int n;
    private final String prediccion;

    /**
     * Consructor por defecto
     */
    public Ocurrencia(){
        this.n=0;
        this.prediccion="";
    }
    
    /**
     * Construcor parametrizado
     * @param pred Texto de la prediccion
     */
    public Ocurrencia(String pred) {
        this.n = 1;
        this.prediccion = pred;
    }


    /**
     * Incremena las veces que ha sido referenciada la predición
     */
    public void nuevaOcurrencia() {
        ++n;
    }

    /**
     * Devuelve el número de veces que aparece dicha predicción
     * @return Número de veces que aparece dicha predicción
     */
    public int getN() {
        return n;
    }

    /**
     * Devuelve el texto de la predicción
     * @return Texto de la predicción
     */
    public String getPrediccion() {
        return prediccion;
    }
}
