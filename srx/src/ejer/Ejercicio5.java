package ejer;

import java.util.Arrays;
import java.util.List;

public class Ejercicio5 {
    public static void main(String[] args) {
        List<String> palabras = Arrays.asList("España", "Mesa", "Avion");

        palabras.sort(String::compareTo);
        System.out.println("Orden alfabetico: " + palabras);

        palabras.sort((a, b) -> Integer.compare(a.length(), b.length()));
        System.out.println("Longitud de las palabras: " + palabras);

    }
}
