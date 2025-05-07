package ejer;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;

public class Ejercicio12 {
    public static void main(String[] args) {
        List<Integer> num = Arrays.asList(1, 5,6,7,12,9,4,3);

        int sum = num.stream()
                .reduce(0, Integer::sum);

        Optional<Integer> max = num.stream()
                .reduce(Integer::max);

        System.out.println("Suma: " + sum);
        System.out.println("Max: " + max.orElse(0));



    }
}
