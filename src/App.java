//Desarrollado por:Andres Felipe Ocampo

import java.util.ArrayList;
import Logica.*;

public class App {
    private static ArrayList<Double> conjuntosMedia = new ArrayList<>();
    private static ArrayList<Double> conjuntosMediana = new ArrayList<>();
    private static ArrayList<Double> conjuntosModa = new ArrayList<>();
    private static ArrayList<Double> conjuntosVarianza = new ArrayList<>();
    private static ArrayList<Double> conjuntosDesviacionEstandar = new ArrayList<>();
    private static ArrayList<Double> conjuntosDesviacionMedia = new ArrayList<>();
    private static ArrayList<Double> conjuntosCoeficienteDeVariacion = new ArrayList<>();

    public static void main(String[] args) throws Exception {
        GenerarDatos();
        ClsEstadistica.TablaFrecuencia(conjuntosMedia, "MEDIA");
        ClsEstadistica.TablaFrecuencia(conjuntosMediana, "MEDIANA");
        ClsEstadistica.TablaFrecuencia(conjuntosModa,"MODA");
        ClsEstadistica.TablaFrecuencia(conjuntosVarianza, "VARIANZA");
        ClsEstadistica.TablaFrecuencia(conjuntosDesviacionEstandar, "DESVIACION ESTANDAR");
        ClsEstadistica.TablaFrecuencia(conjuntosMedia, "DESVIACION MEDIA");
        ClsEstadistica.TablaFrecuencia(conjuntosCoeficienteDeVariacion, "COEFICIENTE DE VARIACION");
    }

    public static void GenerarDatos() {
        for (int i = 0; i < 1000; i++) {
            ClsConjuntoDatos misDatos = new ClsConjuntoDatos();
            misDatos.LlenarConjunto();
            conjuntosMedia.add(misDatos.getAtrMediaAritmetica());
            conjuntosMediana.add(misDatos.getAtrMediana());
            conjuntosModa.add(misDatos.getAtrModa());
            conjuntosVarianza.add(misDatos.getAtrVarianza());
            conjuntosDesviacionEstandar.add(misDatos.getAtrDesviacionEstandar());
            conjuntosDesviacionMedia.add(misDatos.getAtrDesviacionMedia());
            conjuntosCoeficienteDeVariacion.add(misDatos.getAtrCoeficienteVariacion());
        }
        conjuntosMedia.sort(null);
        conjuntosMediana.sort(null);
        conjuntosModa.sort(null);
        conjuntosVarianza.sort(null);
        conjuntosDesviacionEstandar.sort(null);
        conjuntosCoeficienteDeVariacion.sort(null);
        conjuntosCoeficienteDeVariacion.sort(null);
    }
}