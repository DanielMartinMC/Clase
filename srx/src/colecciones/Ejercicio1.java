package colecciones;

import java.util.ArrayList;

public class Ejercicio1 {
    static ArrayList<String> nombres = new ArrayList<>();

    public static void agregarNombre(String nombre) {
        nombres.add(nombre);
    }
    public static void modificarNombre(int indice, String nuevoNombre) {
        if (indice >= 0 && indice < nombres.size()) {
            nombres.set(indice, nuevoNombre);
        }
    }
    public static void eliminarNombre(String nombre) {
        nombres.remove(nombre);
    }
    public static void mostrarNombres() {
        nombres.forEach(System.out::println);
    }
    public static void main(String[] args) {
        agregarNombre("Daniel");
        agregarNombre("Daniel");
        modificarNombre(0, "Miriam");
        eliminarNombre("Daniel");
        mostrarNombres();
    }
}
