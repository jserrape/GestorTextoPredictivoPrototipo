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
    private final ArrayList<Ocurrencia> ocurrencias;//<-- Esto deberá ser una PriorityQueue

    public Predicciones() {
        this.N = 0;
        this.ocurrencias = new ArrayList();
    }

    public void nuevaPrediccion(String pred) {
        ++N;
        for (int i = 0; i < getOcurrencias().size(); i++) {
            if (getOcurrencias().get(i).getPrediccion().equals(pred)) {
                getOcurrencias().get(i).nuevaOcurrencia();
                //System.out.println("Nueva");
                return;
            }else{
                //System.out.println(getOcurrencias().get(i).getPrediccion()+" NO ES "+pred);
            }
        }
        getOcurrencias().add(new Ocurrencia(pred));
    }

    public int getN() {
        return N;
    }

    public ArrayList<Ocurrencia> getOcurrencias() {
        return ocurrencias;
    }
}
