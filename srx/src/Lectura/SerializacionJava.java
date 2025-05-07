package Lectura;

import java.io.*;
import java.util.*;

/**
 * Muestra serialización/deserialización binaria de objetos Java.
 * Requiere que las clases implementen Serializable.
 */
public class SerializacionJava {

    /**
     * Serializa una lista de registros a archivo
     * @param archivo Ruta de destino
     * @param registros Lista a serializar
     * @throws IOException Si ocurre error de E/S
     *
     * ObjectOutputStream convierte objetos a flujo binario
     * Incluye metadatos sobre las clases serializadas
     */
    public static void serializar(String archivo, List<Registro> registros) throws IOException {
        try (ObjectOutputStream oos = new ObjectOutputStream(
                new FileOutputStream(archivo))) {
            oos.writeObject(registros);  // Escribe el objeto completo
        }
    }

    /**
     * Deserializa una lista de registros
     * @param archivo Ruta del archivo
     * @return Lista de registros
     * @throws ClassNotFoundException Si la clase del objeto no existe
     *
     * Se necesita casting porque readObject() devuelve Object
     * @SuppressWarnings evita advertencias por casting no verificado
     */
    @SuppressWarnings("unchecked")
    public static List<Registro> deserializar(String archivo)
            throws IOException, ClassNotFoundException {
        try (ObjectInputStream ois = new ObjectInputStream(
                new FileInputStream(archivo))) {
            return (List<Registro>) ois.readObject();  // Lee y convierte el tipo
        }
    }
}