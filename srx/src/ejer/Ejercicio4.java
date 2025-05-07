package ejer;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class Ejercicio4 {
    public static void main(String[] args) {
        List<String> palabras = Arrays.asList("wacamole","wolframio","ermitaño");

        List<String> pMayus = palabras.stream()
                .map(String::toUpperCase)
                .collect(Collectors.toList());
        List<String> pInvertidas = palabras.stream()
                .map(e -> new StringBuilder(e).reverse().toString())
                .collect(Collectors.toList());
        System.out.println("Palabras en Mayusculas: " + pMayus);
        System.out.println("Palabras invertidas: " + pInvertidas);

    }
}
