package ejer;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class Ejercicio7 {
    public static void main(String[] args) {
        List<Integer> num = Arrays.asList(3,6,7,8,2,4);

        List<Integer> duplicar = num.stream()
                .map(n -> n * 2)
                .collect(Collectors.toList());

        List<Double> RaizCuadrada = num.stream()
                .map(Math::sqrt)
                .collect(Collectors.toList());

        System.out.println("Resultado de los numeros duplicados: " + duplicar);
        System.out.println("Resultado de la raiz cuadrada: " + RaizCuadrada);

    }
}
