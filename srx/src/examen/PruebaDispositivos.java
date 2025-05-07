package examen;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class PruebaDispositivos {

    private List<Movil> moviles;
    private List<Portatil> portatiles;
    private List<Tableta> tabletas;

    public List<Movil> getMoviles() {
        return moviles;
    }

    public void setMoviles(List<Movil> moviles) {
        this.moviles = moviles;
    }

    public List<Portatil> getPortatiles() {
        return portatiles;
    }

    public void setPortatiles(List<Portatil> portatiles) {
        this.portatiles = portatiles;
    }

    public List<Tableta> getTabletas() {
        return tabletas;
    }

    public void setTabletas(List<Tableta> tabletas) {
        this.tabletas = tabletas;
    }

    public void leerArchivo(String archivo) {
        try (BufferedReader br = new BufferedReader(new FileReader(archivo))) {

            if (this.moviles == null) {this.moviles = new ArrayList<>();}
            if (this.portatiles == null) {this.portatiles = new ArrayList<>();}
            if (this.tabletas == null) {this.tabletas = new ArrayList<>();}

            if (br != null || br.equals("")) {
                String linea;
                while ((linea = br.readLine()) != null) {
                    String[] camposPrinciplaes = linea.split("[,;]");
                    if (camposPrinciplaes[0].equals("movil")) {
                        int[] consumosMedios = {Integer.parseInt(camposPrinciplaes[6]),
                                Integer.parseInt(camposPrinciplaes[7]), Integer.parseInt(camposPrinciplaes[8])};
                        this.moviles.add(new Movil(camposPrinciplaes[2], camposPrinciplaes[3],
                                Double.parseDouble(camposPrinciplaes[4]), Integer.parseInt(camposPrinciplaes[5]),
                                consumosMedios));

                    } else if (camposPrinciplaes[0].equals("portatil")) {
                        this.portatiles.add(new Portatil(camposPrinciplaes[2], camposPrinciplaes[3],
                                Double.parseDouble(camposPrinciplaes[4]), Integer.parseInt(camposPrinciplaes[5]),
                                Integer.parseInt(camposPrinciplaes[6]), Integer.parseInt(camposPrinciplaes[7])));

                    } else if (camposPrinciplaes[0].equals("tableta")) {
                        int[] rendimientosMedios = {Integer.parseInt(camposPrinciplaes[6]),
                                Integer.parseInt(camposPrinciplaes[7]), Integer.parseInt(camposPrinciplaes[8])};
                        this.tabletas.add(new Tableta(camposPrinciplaes[2], camposPrinciplaes[3],
                                Double.parseDouble(camposPrinciplaes[4]), Integer.parseInt(camposPrinciplaes[5]),
                                rendimientosMedios));
                    }
                }
            }
        } catch (IOException e){
            System.err.println("Error al leer el archivo " + e.getMessage());
        }
    }

    public void almacenarDatos(String archivo) {
        try (BufferedWriter datos = new BufferedWriter(new FileWriter(archivo))) {
            datos.write("Moviles: \n");
            for (Movil movil : this.moviles) {
                datos.write(movil.toString() + " Resultados:" + movil.obtenerResultados() + "\n");
            }
            datos.write("Portatiles: \n");
            for (Portatil portatil : this.portatiles) {
                datos.write(portatil.toString() + " Resultados:" + portatil.obtenerResultados() + "\n");
            }
            datos.write("Tabletas: \n");
            for (Tableta tableta : this.tabletas) {
                datos.write(tableta.toString() + " Resultados:" + tableta.obtenerResultados() + "\n");
            }
        } catch (IOException e){
            System.err.println("Error al escribir el archivo " + e.getMessage());
        }
    }


    public static void main(String[] args) {
        PruebaDispositivos prueba = new PruebaDispositivos();
        prueba.leerArchivo("ExmaneJoelJava/ExamenJava/Dispositivos.txt");
        System.out.println(prueba.getMoviles().toString());
        System.out.println("\n");
        System.out.println(prueba.getPortatiles().toString());
        System.out.println("\n");
        System.out.println(prueba.getTabletas().toString());
        prueba.almacenarDatos("Reporte_Dispositivos.txt");
    }
}