package Logica;
import java.util.ArrayList;

public class ClsConjuntoDatos {
    // Atributos
    private ArrayList<Double> atrDatos;
    private double atrMediaAritmetica;
    private double atrMediana;
    private double atrModa;
    private double atrVarianza;
    private double atrDesviacionEstandar;
    private double atrDesviacionMedia;
    private double atrCoeficienteVariacion;

    // Constructores
    public ClsConjuntoDatos() {
        atrDatos=new ArrayList<>();
    }

    // getters and setters
    public ArrayList<Double> getDatos() {
        return atrDatos;
    }
    public void setDatos(ArrayList<Double> prmDatos) {
        atrDatos = prmDatos;
    }
    public ClsConjuntoDatos datos(ArrayList<Double> datos) {
        setDatos(datos);
        return this;
    }
    public double getAtrMediaAritmetica() {
        return atrMediaAritmetica;
    }
    public void setAtrMediaAritmetica(double atrMediaAritmetica) {
        this.atrMediaAritmetica = atrMediaAritmetica;
    }
    public double getAtrMediana() {
        return atrMediana;
    }
    public void setAtrMediana(double atrMediana) {
        this.atrMediana = atrMediana;
    }
    public double getAtrModa() {
        return atrModa;
    }
    public void setAtrModa(double atrModa) {
        this.atrModa = atrModa;
    }
    public double getAtrVarianza() {
        return atrVarianza;
    }
    public void setAtrVarianza(double atrVarianza) {
        this.atrVarianza = atrVarianza;
    }
    public double getAtrDesviacionEstandar() {
        return atrDesviacionEstandar;
    }
    public void setAtrDesviacionEstandar(double atrDesviacionEstandar) {
        this.atrDesviacionEstandar = atrDesviacionEstandar;
    }
    public double getAtrDesviacionMedia() {
        return atrDesviacionMedia;
    }
    public void setAtrDesviacionMedia(double atrDesviacionMedia) {
        this.atrDesviacionMedia = atrDesviacionMedia;
    }
    public double getAtrCoeficienteVariacion() {
        return atrCoeficienteVariacion;
    }
    public void setAtrCoeficienteVariacion(double atrCoeficienteVariacion) {
        this.atrCoeficienteVariacion = atrCoeficienteVariacion;
    }
    // Metodos
    public void LlenarConjunto() {
        LlenarDatos(10, 20, 12);
        LlenarDatos(21, 40, 16);
        LlenarDatos(41, 60, 42);
        LlenarDatos(61, 70, 25);
        LlenarDatos(71, 110, 5);
        atrDatos.sort(null);
        double media=ClsEstadistica.MediaAritmetica(atrDatos);
        double mediana=ClsEstadistica.Mediana(atrDatos);
        double moda=ClsEstadistica.Moda(atrDatos);
        double varianza=ClsEstadistica.Varianza(atrDatos, media);
        double desviacionEstandar=ClsEstadistica.DesviacionEstandar(varianza);
        double desviacionMedia=ClsEstadistica.DesviacionMedia(atrDatos, mediana);
        double coeficienteVariacion=ClsEstadistica.CoeficienteVariacion(desviacionEstandar, mediana);
        setAtrMediaAritmetica(ClsEstadistica.Redondear(media));
        setAtrMediana(ClsEstadistica.Redondear(mediana));
        setAtrModa(ClsEstadistica.Redondear(moda));
        setAtrVarianza(ClsEstadistica.Redondear(varianza));
        setAtrDesviacionEstandar(ClsEstadistica.Redondear(desviacionEstandar));
        setAtrDesviacionMedia(ClsEstadistica.Redondear(desviacionMedia));
        setAtrCoeficienteVariacion(ClsEstadistica.Redondear(coeficienteVariacion));
    }

    private void LlenarDatos(int li, int ls, int ni) {
        for (int i = 0; i < ni; i++) {
            int num=(int)(Math.random() * ((ls - li) + 1)) + li;
            atrDatos.add((double) num);
        }
    }

    public void ImprimirConjunto() {
        for (double i : atrDatos) {
            System.out.println(i);
        }
    }
}