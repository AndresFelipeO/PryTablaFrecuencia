package Logica;

import java.util.ArrayList;

public class ClsEstadistica {
    private static ArrayList<Double> li = new ArrayList<>();
    private static ArrayList<Double> li1 = new ArrayList<>();
    private static ArrayList<Double> xi = new ArrayList<>();
    private static ArrayList<Integer> ni = new ArrayList<>();
    private static ArrayList<Double> fi = new ArrayList<>();
    private static ArrayList<Integer> Ni = new ArrayList<>();
    private static ArrayList<Double> Fi = new ArrayList<>();

    public static double Redondear(double numero) {
        return Math.round(numero * 100) / 100d;
    }

    public static double Suma(ArrayList<Double> prmDatos) {
        double suma = 0;
        for (double i : prmDatos)
            suma += i;
        return suma;
    }

    public static double MediaAritmetica(ArrayList<Double> prmDatos) {
        return Suma(prmDatos) / prmDatos.size();
    }

    public static double Mediana(ArrayList<Double> prmDatos) {
        int mitad = prmDatos.size() / 2;
        // Si la longitud es par, se deben promediar los del centro
        if (prmDatos.size() % 2 == 0)
            return (prmDatos.get(mitad - 1) + prmDatos.get(mitad)) / 2;
        return prmDatos.get(mitad);
    }

    public static double Moda(ArrayList<Double> prmDatos) {
        int maximoNumRepeticiones = 0;
        double moda = 0;
        for (double i : prmDatos) {
            int numRepeticiones = 0;
            for (double j : prmDatos)
                if (i == j)
                    numRepeticiones++;
            if (numRepeticiones >= maximoNumRepeticiones) {
                moda = i;
                maximoNumRepeticiones = numRepeticiones;
            }
        }
        return moda;
    }

    public static double Varianza(ArrayList<Double> prmDatos, double prmPromedio) {
        double suma = 0;
        for (Double xi : prmDatos) {
            suma += Math.pow(xi - prmPromedio, 2) / prmDatos.size();
        }
        return suma;
    }

    public static double DesviacionEstandar(double prmVarianza) {
        return Math.sqrt(prmVarianza);
    }

    public static double DesviacionMedia(ArrayList<Double> prmDatos, double prmMedia) {
        double desviacionMedia = 0;
        for (double xi : prmDatos)
            desviacionMedia += Math.abs(xi - prmMedia) / prmDatos.size();
        return desviacionMedia;
    }

    public static double CoeficienteVariacion(double prmDesviacionEstandar, double prmMediaAritmetica) {
        return (prmDesviacionEstandar / prmMediaAritmetica) * 100;
    }

    public static void TablaFrecuencia(ArrayList<Double> prmDatos, String titulo) {
        LimpiarLista();
        System.out.println("\n\n-----  DATOS DE LA " + titulo + " -----");
        double menor = prmDatos.get(0);
        double mayor = prmDatos.get(prmDatos.size() - 1);
        double rango = mayor - menor;
        rango = Redondear(rango);
        int distanciaIntervalos = ((int) (3.3 * Math.log10(prmDatos.size()))) + 1;
        double ci = Redondear((rango / distanciaIntervalos));
        LlenarRangos(menor, mayor, ci);
        LLenarxi();
        Llenarni(prmDatos);
        LLenarfFi(fi, ni, prmDatos.size());
        LlenarNi();
        LLenarfFi(Fi, Ni, prmDatos.size());
        Distribucion(menor, mayor, rango, distanciaIntervalos, ci);
        ImprimirTablaFrecuencia();
        IndicadoresTabla(prmDatos);
    }

    private static void LimpiarLista() {
        li.clear();
        li1.clear();
        xi.clear();
        ni.clear();
        fi.clear();
        Ni.clear();
        Fi.clear();
    }

    private static void ImprimirTablaFrecuencia() {
        System.out.printf("%8s %8s %8s %5s %8s %5s %8s %n", "li-", "li+1", "xi", "ni", "fi", "Ni", "Fi");
        for (int i = 0; i < li.size(); i++) {
            System.out.printf("%8s %8s %8s %5s %8s %5s %8s %n", li.get(i), li1.get(i), xi.get(i), ni.get(i), fi.get(i),
                    Ni.get(i), Fi.get(i));

        }
    }

    private static void Distribucion(double menor, double mayor, double rango, double distanciaIntervalos, double ci) {
        System.out.println("**Distribución de frecuencias***************************");
        System.out.println("- Menor numero: " + menor + "     -Mayor numero: " + mayor);
        System.out.println("- Rango: " + rango + "  - intervalos: " + distanciaIntervalos + "   -ci: " + ci);
        System.out.println("**TABLA DE FRECUENCIA***********************************");

    }

    private static void IndicadoresTabla(ArrayList<Double> prmDatos) {
        double media = Redondear(MediaAritmetica(prmDatos));
        double mediana = Redondear(Mediana(prmDatos));
        double moda = Redondear(Moda(prmDatos));
        double Varianza = Redondear(Varianza(prmDatos, media));
        double DesviacionEstandar = Redondear(DesviacionEstandar(Varianza));
        double desviacionMedia = Redondear(DesviacionMedia(prmDatos, media));
        double coeficienteVariacion = Redondear(CoeficienteVariacion(DesviacionEstandar, media));
        System.out.println("********************************************************");
        System.out.print("Media: " + media);
        System.out.println("\tMediana: " + mediana);
        System.out.print("Moda: " + moda);
        System.out.println("\tVarianza :" + Varianza);
        System.out.println("Desviacion Estandar: " + DesviacionEstandar);
        System.out.print("Desviacion Media: " + desviacionMedia);
        System.out.println("\tCoeficiente de variacion: " + coeficienteVariacion);
        System.out.println("--------------------------------------------------------");
    }

    private static void LlenarRangos(double menor, double mayor, double ci) {
        double aux = menor;
        do {
            li.add(aux);
            aux += ci;
            aux = Math.round(aux * 100) / 100d;
            li1.add(aux);
        } while (aux < mayor);
    }

    private static void LLenarxi() {
        for (int i = 0; i < li.size(); i++) {
            double auxXi = (li.get(i) + li1.get(i)) / 2;
            auxXi = Math.round(auxXi * 100) / 100d;
            xi.add(auxXi);
        }
    }

    private static void Llenarni(ArrayList<Double> prmDatos) {
        int j = 0;
        for (int i = 0; i < li.size(); i++) {
            int aux = 0;
            while (j < prmDatos.size()) {
                if (prmDatos.get(j) <= li1.get(i)) {
                    aux++;
                    j++;
                } else
                    break;
            }
            ni.add(aux);
        }
    }

    private static void LLenarfFi(ArrayList<Double> fFi, ArrayList<Integer> nNi, int n) {
        for (int i : nNi)
            fFi.add((double) i / n);
    }

    public static void LlenarNi() {
        int suma = 0;
        for (int i : ni) {
            suma += i;
            Ni.add(suma);
        }
    }
}