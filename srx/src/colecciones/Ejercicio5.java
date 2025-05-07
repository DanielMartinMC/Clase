package colecciones;

import java.util.HashSet;
import java.util.Set;

public class Ejercicio5 {
    public static Set<Integer> obtenerElementosUnicos(Set<Integer> s1, Set<Integer> s2) {
    Set<Integer> unicos = new HashSet<>();

    for (Integer num : s1) {
        if (!s2.contains(num)) {
            unicos.add(num);
        }
    }
    for (Integer num : s2) {
        if (!s1.contains(num)) {
            unicos.add(num);
        }
    }
    return unicos;
    }
    public static void main(String[] args) {
        Set<Integer> conjunto1 = new HashSet<>();
        conjunto1.add(2);
        conjunto1.add(11);
        conjunto1.add(9);
        Set<Integer> conjunto2 = new HashSet<>();
        conjunto2.add(23);
        conjunto2.add(11);
        conjunto2.add(2);

        Set<Integer> elementosUnicos = obtenerElementosUnicos(conjunto1, conjunto2);

        System.out.println("Numeros unicos en cada conjunto:");
        System.out.println(elementosUnicos);
    }
}
