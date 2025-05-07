package ejer;

import java.util.Arrays;

import java.util.Arrays;

interface OperacionesArray {
    int operacion(int[] array);
}

public class Ejercicio10 {

    public static void main(String[] args) {
        int[] num = {1, 4, 34, 4, 5, 55, 5, 6};

        OperacionesArray sum = arr -> Arrays.stream(arr).sum();

        OperacionesArray pares = arr -> (int) Arrays.stream(arr)
                .filter(n -> n % 2 == 0)
                .count();

        System.out.println("Suma: " + sum.operacion(num));
        System.out.println("Pares: " + pares.operacion(num));
    }
}
