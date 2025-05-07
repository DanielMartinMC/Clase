package colecciones;

import java.util.LinkedHashMap;
import java.util.Map;

public class Ejercicio7 {
    public static LinkedHashMap<String, Double> ordenarPorPrecioAscendente(LinkedHashMap<String, Double> productos) {
        return productos.entrySet().stream()
                .sorted(Map.Entry.comparingByValue())
                .collect(LinkedHashMap::new, (map, entry) -> map.put(entry.getKey(), entry.getValue()), LinkedHashMap::putAll);
    }

    public static void main(String[] args) {
        LinkedHashMap<String, Double> productos = new LinkedHashMap<>();
        productos.put("Nintendo Switch 2", 470.00);
        productos.put("Raton", 85.50);
        productos.put("Teclado", 120.26);
        productos.put("Monitor", 250.00);
        productos.put("Impresora", 299.99);

        System.out.println("Productos sin ordenar :");
        productos.forEach((nombre, precio) -> System.out.println(nombre + ": $" + precio));

        LinkedHashMap<String, Double> productosOrdenados = ordenarPorPrecioAscendente(productos);

        System.out.println("\nProductos ordenados:");
        productosOrdenados.forEach((nombre, precio) -> System.out.println(nombre + ": $" + precio));

    }
}