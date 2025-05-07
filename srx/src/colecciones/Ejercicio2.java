package colecciones;

import java.util.ArrayList;
import java.util.Iterator;

public class Ejercicio2 {
    public static void main(String[] args) {
        ArrayList<Integer> numeros = new ArrayList<>();
        for (int i = 1; i <= 20; i++) numeros.add(i);

        eliminarNoMultiplosDeTres(numeros);
        numeros.forEach(System.out::println);
    }

    public static void eliminarNoMultiplosDeTres(ArrayList<Integer> lista) {
        Iterator<Integer> it = lista.iterator();
        while (it.hasNext()) {
            if (it.next() % 3 != 0) ((Iterator<?>) it).remove();
        }
    }
}