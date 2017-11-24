/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gestortextopredictivo;

/**
 *
 * @author jcsp0003
 */
public class Ocurrencia {

    private int n;
    private final String prediccion;

    public Ocurrencia(String pred) {
        this.n = 1;
        this.prediccion = pred;
    }

    public void nuevaOcurrencia() {
        ++n;
    }

    public int getN() {
        return n;
    }

    public String getPrediccion() {
        return prediccion;
    }

}
