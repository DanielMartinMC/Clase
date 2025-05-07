package Lectura;

import java.io.Serializable;
import java.time.LocalDate;

/**
 * Representa un registro inmutable de datos con capacidad de conversión a CSV.
 * Implementa Serializable para permitir serialización binaria.
 */
public record Registro(String id, String nombre, LocalDate fecha, double valor) implements Serializable {

    /**
     * Convierte el registro a formato CSV
     * @return String en formato "id,nombre,fecha,valor"
     */
    public String toCSV() {
        return String.join(",", id, nombre, fecha.toString(), String.valueOf(valor));
    }

    /**
     * Crea un Registro desde una línea CSV
     * @param csvLine Línea en formato "id,nombre,fecha,valor"
     * @return Nuevo objeto Registro
     */
    public static Registro fromCSV(String csvLine) {
        String[] parts = csvLine.split(",");
        return new Registro(parts[0], parts[1], LocalDate.parse(parts[2]), Double.parseDouble(parts[3]));
    }
}
