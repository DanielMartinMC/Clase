package colecciones;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Ejercicio8 {
    public static List<Integer> extraerEdades(Map<String, Integer> map) {
        return new ArrayList<>(map.values());
    }

    public static double calcularPromedio(List<Integer> edades) {
        return edades.stream().mapToInt(Integer::intValue).average().orElse(0);
    }

    public static int encontrarMayorEdad(List<Integer> edades) {
        return edades.stream().max(Integer::compare).orElse(0);
    }

    public static void main(String[] args) {
        // Crear un mapa de nombres y edades
        Map<String, Integer> personas = new HashMap<>();
        personas.put("Daniel", 20);
        personas.put("Arturo", 21);
        personas.put("Julian", 18);
        personas.put("Marcos", 20);
        personas.put("Victor", 19);

        List<Integer> edades = extraerEdades(personas);
        System.out.println("Edades: " + edades);

        double promedio = calcularPromedio(edades);
        System.out.println("Promedio de edades: " + promedio);

        int mayorEdad = encontrarMayorEdad(edades);
        System.out.println("Mayor edad: " + mayorEdad);

    }

}
