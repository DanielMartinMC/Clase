package ejer;

import java.util.Arrays;
import java.util.IntSummaryStatistics;
import java.util.List;

public class Ejercicio8 {
    public static void main(String[] args) {
        List<Integer> num = Arrays.asList(5,6,7,4,1,5,7);

        IntSummaryStatistics stats = num.stream()
                .mapToInt(Integer::intValue)
                .summaryStatistics();

        System.out.println("Maximo: " + stats.getMax());
        System.out.println("Minimo: " + stats.getMin());
        System.out.println("Suma: " + stats.getAverage());
    }
}
