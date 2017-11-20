/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gestortextopredictivo;

import java.io.BufferedReader;
import java.io.File;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.URL;
import org.apache.pdfbox.cos.COSDocument;
import org.apache.pdfbox.io.RandomAccessFile;
import org.apache.pdfbox.pdfparser.PDFParser;
import org.apache.pdfbox.pdmodel.PDDocument;
import org.apache.pdfbox.text.PDFTextStripper;
import org.jsoup.Jsoup;

/**
 *
 * @author jcsp0003
 */
public class lecturaInfo {

    public lecturaInfo() {

    }

    public String lectura(String tipo, String path) throws IOException {
        if ("pdf".equals(tipo)) {
            return nuevoPDF(path);
        } else {
            return nuevaURL(path);
        }
    }

    private String nuevoPDF(String filePath) throws IOException {
        File file = new File(filePath);
        PDFParser parser = new PDFParser(new RandomAccessFile(file, "r")); // update for PDFBox V 2.0

        parser.parse();
        COSDocument cosDoc = parser.getDocument();
        PDFTextStripper pdfStripper = new PDFTextStripper();
        PDDocument pdDoc = new PDDocument(cosDoc);
        pdDoc.getNumberOfPages();
        //pdfStripper.setStartPage(1);
        //pdfStripper.setEndPage(10);

        // reading text from page 1 to 10
        // if you want to get text from full pdf file use this code
        pdfStripper.setEndPage(pdDoc.getNumberOfPages());
        return pdfStripper.getText(pdDoc);
    }

    private String nuevaURL(String urlPath) throws IOException {
        String line, all = "";
        BufferedReader in = null;
        try {
            URL myUrl = new URL(urlPath);
            in = new BufferedReader(new InputStreamReader(myUrl.openStream()));

            while ((line = in.readLine()) != null) {
                all += line;
            }
        } finally {
            if (in != null) {
                in.close();
            }
        }
        return Jsoup.parse(all).text();
    }

}
