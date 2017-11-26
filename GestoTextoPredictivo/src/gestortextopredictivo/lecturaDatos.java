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
public class lecturaDatos {

    /**
     * 
     * @param tipo
     * @param path
     * @return
     * @throws IOException 
     */
    public String lectura(String tipo, String path) throws IOException {
        if ("pdf".equals(tipo)) {
            return nuevoPDF(path);
        } else {
            return nuevaURL(path);
        }
    }

    /**
     * 
     * @param filePath
     * @return
     * @throws IOException 
     */
    private String nuevoPDF(String filePath) throws IOException {
        File file = new File(filePath);
        PDFParser parser = new PDFParser(new RandomAccessFile(file, "r"));

        parser.parse();
        String tx;
        try (COSDocument cosDoc = parser.getDocument()) {
            PDFTextStripper pdfStripper = new PDFTextStripper();
            PDDocument pdDoc = new PDDocument(cosDoc);
            pdDoc.getNumberOfPages();

            pdfStripper.setEndPage(pdDoc.getNumberOfPages());

            tx = pdfStripper.getText(pdDoc);
        }
        return tx;
    }

    /**
     * 
     * @param urlPath
     * @return
     * @throws IOException 
     */
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
