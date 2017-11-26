package gestortextopredictivo;

/**
 *
 * @author jcsp0003
 */
public class Ocurrencia implements Comparable<Ocurrencia> {

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
     * Compara dos predicciones
     * @param o Segundo objeto Ocurrencia
     * @return Qué predicción ha sido referenciada más veces.
     */
    @Override
    public int compareTo(Ocurrencia o) {
        return Integer.toString(o.n).compareTo(Integer.toString(this.n));
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
