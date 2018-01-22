/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gestortextopredictivo;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author jcsp0003
 */
public class Configuracion {

    private String idioma;
    private ArrayList<String> palabras;

    public Configuracion() throws FileNotFoundException {
        cargarConf();
        cargarIdioma(idioma);
        escribirFicheroIdiomaSpanol();
        escribirFicheroIdiomaIngles();
    }

    public String getPalabra(int i) {
        return palabras.get(i);
    }
    
    public String getIdioma(){
        return this.idioma;
    }

    private void cargarConf() {
        try {
            File archivoo = new File("./conf");
            FileReader fr = new FileReader(archivoo);
            BufferedReader br = new BufferedReader(fr);
            idioma = br.readLine();
        } catch (IOException ex) {
            Logger.getLogger(Configuracion.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public void escribirConf() {
        String ruta = "./conf";
        File archivo = new File(ruta);
        BufferedWriter bw;
        try {
            bw = new BufferedWriter(new FileWriter(archivo));
            bw.write(idioma);
            bw.close();
        } catch (IOException ex) {
            Logger.getLogger(Configuracion.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public void cargarIdioma(String idiom) {
        palabras = new ArrayList();
        FileReader f = null;
        try {
            String cadena;
            f = new FileReader("./idioma/" + idiom);
            try (BufferedReader b = new BufferedReader(f)) {
                while ((cadena = b.readLine()) != null) {
                    palabras.add(cadena);
                }
                this.idioma=idiom;
            }
        } catch (FileNotFoundException ex) {
            Logger.getLogger(Configuracion.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(Configuracion.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            try {
                f.close();
            } catch (IOException ex) {
                Logger.getLogger(Configuracion.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }

    public void escribirFicheroIdiomaSpanol() {
        String ruta = "./idioma/Español";
        File archivo = new File(ruta);
        BufferedWriter bw;
        try {
            bw = new BufferedWriter(new FileWriter(archivo));
            bw.write("Archivo");
            bw.newLine();
            bw.write("Editar");
            bw.newLine();
            bw.write("Ajustes");
            bw.newLine();
            bw.write("Ayuda");
            bw.newLine();
            bw.write("Nuevo");
            bw.newLine();
            bw.write("Abrir");
            bw.newLine();
            bw.write("Guardar");
            bw.newLine();
            bw.write("Guardar como...");
            bw.newLine();
            bw.write("Salir");
            bw.newLine();
            bw.write("Deshacer");
            bw.newLine();
            bw.write("Cortar");
            bw.newLine();
            bw.write("Copiar");
            bw.newLine();
            bw.write("Pegar");
            bw.newLine();
            bw.write("Eliminar");
            bw.newLine();
            bw.write("Buscar...");
            bw.newLine();
            bw.write("Reemplazar");
            bw.newLine();
            bw.write("Seleccionar todo");
            bw.newLine();
            bw.write("Hora y fecha");
            bw.newLine();
            bw.write("Formato");
            bw.newLine();
            bw.write("Predicción");
            bw.newLine();
            bw.write("Idioma");
            bw.newLine();
            bw.write("Aceptar");
            bw.newLine();
            bw.write("Cancelar");
            bw.newLine();
            bw.write("Elegir idioma de la interfaz");
            bw.newLine();
            bw.write("Seleccione uno de los idiomas siguientes para la interfaz");
            bw.newLine();
            bw.write("Fuente");
            bw.newLine();
            bw.write("Estilo de la fuente");
            bw.newLine();
            bw.write("Tamaño");
            bw.newLine();
            bw.write("Muestra");
            bw.newLine();
            bw.write("Normal");
            bw.newLine();
            bw.write("Negrita");
            bw.newLine();
            bw.write("Cursiva");
            bw.newLine();
            bw.write("Anadir nueva url:");
            bw.newLine();
            bw.write("Anadir nueva url");
            bw.newLine();
            bw.write("Gestor de texto predictivo con origen de datos configurable");
            bw.newLine();
            bw.write("Selección de idioma");
            bw.close();
        } catch (IOException ex) {
            Logger.getLogger(Configuracion.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public void escribirFicheroIdiomaIngles() {
        String ruta = "./idioma/English";
        File archivo = new File(ruta);
        BufferedWriter bw;
        try {
            bw = new BufferedWriter(new FileWriter(archivo));
            bw.write("Archive");
            bw.newLine();
            bw.write("Edit");
            bw.newLine();
            bw.write("Settings");
            bw.newLine();
            bw.write("Help");
            bw.newLine();
            bw.write("New");
            bw.newLine();
            bw.write("Open");
            bw.newLine();
            bw.write("Save");
            bw.newLine();
            bw.write("Save as...");
            bw.newLine();
            bw.write("Close");
            bw.newLine();
            bw.write("Undo");
            bw.newLine();
            bw.write("Cut");
            bw.newLine();
            bw.write("Copy");
            bw.newLine();
            bw.write("Paste");
            bw.newLine();
            bw.write("Remove");
            bw.newLine();
            bw.write("Find...");
            bw.newLine();
            bw.write("Replace");
            bw.newLine();
            bw.write("Select all");
            bw.newLine();
            bw.write("Time and date");
            bw.newLine();
            bw.write("Format");
            bw.newLine();
            bw.write("Prediction");
            bw.newLine();
            bw.write("Language");
            bw.newLine();
            bw.write("Accept");
            bw.newLine();
            bw.write("Cancel");
            bw.newLine();
            bw.write("Choose interface language");
            bw.newLine();
            bw.write("Select one of the following languages ​​for the interface:");
            bw.newLine();
            bw.write("Font");
            bw.newLine();
            bw.write("Font style");
            bw.newLine();
            bw.write("Size");
            bw.newLine();
            bw.write("Sample");
            bw.newLine();
            bw.write("Normal");
            bw.newLine();
            bw.write("Bold");
            bw.newLine();
            bw.write("Italics");
            bw.newLine();
            bw.write("Add new url:");
            bw.newLine();
            bw.write("Add new url");
            bw.newLine();
            bw.write("Predictive text manager with configurable data source");
            bw.newLine();
            bw.write("Language selection");
            bw.close();
        } catch (IOException ex) {
            Logger.getLogger(Configuracion.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
