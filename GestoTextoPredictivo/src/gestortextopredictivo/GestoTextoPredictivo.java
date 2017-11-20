/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gestortextopredictivo;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.MalformedURLException;
import java.net.URL;
import org.jsoup.Jsoup;

/**
 *
 * @author jcsp0003
 */
public class GestoTextoPredictivo {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        Consola consola = new Consola();
        consola.setVisible(true);

        Opciones opciones = new Opciones(consola);
        opciones.setVisible(true);
        opciones.setResizable(false);
    }

    public void leerURL() throws MalformedURLException, IOException {
        String line, all = "";
        BufferedReader in = null;
        try {
            URL myUrl = new URL("https://es.wikipedia.org/wiki/World_of_Warcraft");
            in = new BufferedReader(new InputStreamReader(myUrl.openStream()));

            while ((line = in.readLine()) != null) {
                all += line;
            }
        } finally {
            if (in != null) {
                in.close();
            }
        }
        System.out.println(Jsoup.parse(all).text());
    }

    public void leerPDF() throws IOException {
        PDFManager pdfManager = new PDFManager();
        pdfManager.setFilePath("test.pdf");
        System.out.println(pdfManager.ToText());
    }
}
