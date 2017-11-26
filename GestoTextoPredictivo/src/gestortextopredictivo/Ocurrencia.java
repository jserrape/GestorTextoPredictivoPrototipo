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
public class Ocurrencia implements Comparable<Ocurrencia> {

    private int n;
    private String prediccion;

    public Ocurrencia(String pred) {
        this.n = 1;
        this.prediccion = pred;
    }

    @Override
    public int compareTo(Ocurrencia o) {  
        return Integer.toString(o.n).compareTo(Integer.toString(this.n));
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

    public void setN(int n) {
        this.n = n;
    }

    public void setPrediccion(String prediccion) {
        this.prediccion = prediccion;
    }

}
