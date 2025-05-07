package Lectura;

import java.io.*;
import java.util.*;

/**
 * Demuestra el uso de FileWriter/BufferedWriter y FileReader/BufferedReader
 * para operaciones básicas de archivos con manejo automático de recursos.
 */
public class IOEjercicios {

    /**
     * Escribe registros en un archivo CSV
     * @param nombreArchivo Ruta del archivo
     * @param registros Lista de registros a escribir
     * @throws IOException Si ocurre un error de E/S
     *
     * Uso de BufferedWriter mejora performance para escrituras secuenciales
     * try-with-resources asegura que el archivo se cierre automáticamente
     */
    public static void escribirArchivo(String nombreArchivo, List<Registro> registros) throws IOException {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(nombreArchivo))) {
            for (Registro r : registros) {
                writer.write(r.toCSV());  // Escribe línea CSV
                writer.newLine();         // Agrega salto de línea
            }
        }
    }

    /**
     * Lee registros desde un archivo CSV
     * @param nombreArchivo Ruta del archivo
     * @return Lista de registros leídos
     * @throws IOException Si ocurre un error de E/S
     *
     * BufferedReader permite lectura eficiente línea por línea
     */
    public static List<Registro> leerArchivo(String nombreArchivo) throws IOException {
        List<Registro> registros = new ArrayList<>();
        try (BufferedReader reader = new BufferedReader(new FileReader(nombreArchivo))) {
            String linea;
            while ((linea = reader.readLine()) != null) {  // Lee hasta fin de archivo
                registros.add(Registro.fromCSV(linea));    // Convierte línea a Registro
            }
        }
        return registros;
    }
}