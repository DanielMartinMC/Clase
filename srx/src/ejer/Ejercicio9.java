package ejer;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class Ejercicio9 {
    public static void main(String[] args) {
        List<String> palabras = Arrays.asList("Cadena","Arbol","Tetris","Maquina Virtual");

        String resultado = palabras.stream()
                .collect(Collectors.joining(",  "));
        System.out.println(resultado);
    }
}
