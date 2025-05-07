package colecciones;

import java.util.ArrayList;
import java.util.Optional;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class Ejercicio3 {

    public static String buscarPrimeraPalabraConLetra(List<String> palabras, String letra) {
        if (letra == null || letra.length() != 1) {
            return "La letra debe ser un único carácter";
        }
        return palabras.stream()
                .filter(palabra -> palabra.toLowerCase().startsWith(letra.toLowerCase()))
                .findFirst()
                .orElse("No hay palabras con esa letra.");
    }
    public static void main(String[] args) {
        List<String> palabras = new ArrayList<>();
        palabras.add("banana");
        palabras.add("pera");
        palabras.add("mango");

        System.out.println(buscarPrimeraPalabraConLetra(palabras, "m"));
        System.out.println(buscarPrimeraPalabraConLetra(palabras, "p"));
        System.out.println(buscarPrimeraPalabraConLetra(palabras, "z"));
    }
}
