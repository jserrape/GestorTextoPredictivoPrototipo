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
public class QuickSort {

    public void sort(ArrayList<Ocurrencia> ocurrencias) {
        if (ocurrencias.isEmpty()) {
            return;
        }
        quickSort(0, ocurrencias.size(), ocurrencias);
    }

    private void quickSort(int lowerIndex, int higherIndex, ArrayList<Ocurrencia> ocurrencias) {
        int i = lowerIndex;
        int j = higherIndex;
        int pivot = ocurrencias.get(lowerIndex + (higherIndex - lowerIndex) / 2).getN();

        while (i <= j) {
            while (ocurrencias.get(i).getN() < pivot) {
                i++;
            }
            while (ocurrencias.get(i).getN() > pivot) {
                j--;
            }
            if (i <= j) {
                exchangeNumbers(i, j, ocurrencias);
                i++;
                j--;
            }
        }
        if (lowerIndex < j) {
            quickSort(lowerIndex, j, ocurrencias);
        }
        if (i < higherIndex) {
            quickSort(i, higherIndex, ocurrencias);
        }
    }

    private void exchangeNumbers(int i, int j, ArrayList<Ocurrencia> ocurrencias) {
        Ocurrencia temp = ocurrencias.get(i);
        ocurrencias.set(i, ocurrencias.get(j));
        ocurrencias.set(j, temp);
    }

}
