package Lectura;

import java.io.*;
import java.time.*;

/**
 * Demuestra acceso aleatorio a archivos usando RandomAccessFile
 * donde cada registro tiene tamaño fijo (100 bytes en este ejemplo).
 */
public class AccesoAleatorio {

    // Tamaño fijo por registro (calculado aproximadamente)
    private static final int RECORD_SIZE = 100;

    /**
     * Escribe un registro en posición específica
     * @param archivo Ruta del archivo
     * @param registro Registro a escribir
     * @param posicion Número de registro (0-based)
     * @throws IOException Si ocurre error de E/S
     *
     * Modo "rw" permite lectura/escritura
     * seek() posiciona el puntero en bytes
     * writeUTF() escribe Strings con longitud prefijada
     */
    public static void escribirRegistro(String archivo, Registro registro, long posicion) throws IOException {
        try (RandomAccessFile raf = new RandomAccessFile(archivo, "rw")) {
            raf.seek(posicion * RECORD_SIZE);       // Salta a posición deseada
            raf.writeUTF(registro.id());           // Escribe campo id (hasta 64KB)
            raf.writeUTF(registro.nombre());       // Escribe nombre
            raf.writeUTF(registro.fecha().toString()); // Fecha como String
            raf.writeDouble(registro.valor());     // Escribe valor como 8 bytes
        }
    }

    /**
     * Lee un registro de posición específica
     * @param archivo Ruta del archivo
     * @param posicion Número de registro (0-based)
     * @return Registro leído
     * @throws IOException Si ocurre error de E/S
     *
     * readUTF() lee Strings escritos con writeUTF()
     * El orden de lectura DEBE coincidir con el de escritura
     */
    public static Registro leerRegistro(String archivo, long posicion) throws IOException {
        try (RandomAccessFile raf = new RandomAccessFile(archivo, "r")) {  // Modo solo lectura
            raf.seek(posicion * RECORD_SIZE);
            return new Registro(
                    raf.readUTF(),                     // Lee id
                    raf.readUTF(),                     // Lee nombre
                    LocalDate.parse(raf.readUTF()),    // Parsea fecha
                    raf.readDouble()                   // Lee valor
            );
        }
    }
}