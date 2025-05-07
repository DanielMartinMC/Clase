package ejer;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class Ejercicio2 {
    public static void main(String[] args) {
        List<Integer> num = Arrays.asList(6, 12, 3, 45, 15, 7, 20, 1, 10);

        // Números impares
        List<Integer> numimpar = num.stream()
                .filter(n -> n % 2 != 0)
                .collect(Collectors.toList());

        // Números mayores que 10
        List<Integer> nummayores = num.stream()
                .filter(n -> n > 10)
                .collect(Collectors.toList());

        System.out.println("Numeros impares: " + numimpar);
        System.out.println("Numeros > 10: " + nummayores);
    }
}
