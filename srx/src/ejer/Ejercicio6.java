package ejer;

import java.util.ArrayList;
import java.util.List;

class producto {
    String nombre;
    double precio;

    public producto(String nombre, double precio) {
        this.nombre = nombre;
        this.precio = precio;
    }

    @Override
    public String toString() {
        return "producto{" + 
                "nombre=" + nombre + ", " +
                "precio=" + precio + '}';
    }
    
}
public class Ejercicio6 {
    public static void main(String[] args) {
        List<producto> productos = new ArrayList<>();
        productos.add(new producto("Barra de Pan", 1.2));
        productos.add(new producto("Lata de Monster", 2));
        productos.add(new producto("Helado de Turron", 4.75));

        productos.removeIf(new java.util.function.Predicate<producto>() {
            @Override
            public boolean test(producto p) {
                return p.precio < 20;
            }
        });
        System.out.println("Productos ordenados por precio: " + productos);
    }
}