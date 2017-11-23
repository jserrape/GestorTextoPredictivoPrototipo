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
public class Pair {

    private int ocurrencias;
    private final ArrayList<String> frecuencias; //<-- Esto deberá ser otro pair

    public Pair() {
        this.ocurrencias = 0;
        this.frecuencias = new ArrayList();
    }

    public void incrementaF() {
        ++ocurrencias;
    }

}
