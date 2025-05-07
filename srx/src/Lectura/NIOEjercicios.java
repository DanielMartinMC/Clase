package Lectura;

import java.io.IOException;
import java.nio.file.*;
import java.util.*;
import java.util.stream.*;

/**
 * Muestra el uso moderno de java.nio.file.Files para operaciones con archivos
 * usando streams y métodos de conveniencia.
 */
public class NIOEjercicios {

    /**
     * Escribe registros usando Files.write()
     * @param nombreArchivo Ruta del archivo
     * @param registros Lista de registros
     * @throws IOException Si ocurre error de E/S
     *
     * Files.write() maneja todo el proceso de apertura, escritura y cierre
     * StandardOpenOption.CREATE crea el archivo si no existe
     */
    public static void escribirConNIO(String nombreArchivo, List<Registro> registros) throws IOException {
        List<String> lineas = registros.stream()
                .map(Registro::toCSV)                  // Convierte cada registro a CSV
                .collect(Collectors.toList());         // Recoge en una List<String>

        Files.write(
                Paths.get(nombreArchivo),              // Obtiene ruta como Path
                lineas,                                // Datos a escribir
                StandardOpenOption.CREATE);            // Opción de creación
    }

    /**
     * Lee registros usando Files.readAllLines()
     * @param nombreArchivo Ruta del archivo
     * @return Lista de registros
     * @throws IOException Si ocurre error de E/S
     *
     * readAllLines() carga todo el archivo en memoria (cuidado con archivos grandes)
     * El stream procesa línea por línea convirtiendo a Registro
     */
    public static List<Registro> leerConNIO(String nombreArchivo) throws IOException {
        return Files.readAllLines(Paths.get(nombreArchivo)).stream()
                .map(Registro::fromCSV)                // Convierte cada línea
                .collect(Collectors.toList());         // Recoge en una List<Registro>
    }
}