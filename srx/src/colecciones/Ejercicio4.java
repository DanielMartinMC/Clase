package colecciones;

import java.util.Set;
import java.util.HashSet;

public class Ejercicio4 {

    public static void diferencias(Set<String> s1, Set<String> s2) {
        Set<String> diferencia = new HashSet<>(s1);
        diferencia.removeAll(s2);

        if (diferencia.isEmpty()) {
            System.out.println("No hay diferencias en los nombres del s1 están en s2)");
        } else {
            diferencia.forEach(System.out::println);
        }
    }
    public static void main(String[] args) {
        Set<String> conjunto1 = new HashSet<>();
        conjunto1.add("Daniel");
        conjunto1.add("Miriam");
        conjunto1.add("Sonia");
        conjunto1.add("Jose");

        Set<String> conjunto2 = new HashSet<>();
        conjunto2.add("Marcos");
        conjunto2.add("Miriam");
        conjunto2.add("Nieves");
        conjunto2.add("Roberto");

        System.out.println("Nombres en conjunto1 que no están en conjunto2:");
        diferencias(conjunto1, conjunto2);
    }
}