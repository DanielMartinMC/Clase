package colecciones;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Ejercicio11 {
    public static Set<String> convertirListaASet(List<String> lista) {
        return new HashSet<>(lista);
    }

    public static void main(String[] args) {
        List<String> frutas = new ArrayList<>();
        frutas.add("Manzana");
        frutas.add("Mango");
        frutas.add("Naranja");
        frutas.add("Mango");
        frutas.add("Pera");
        frutas.add("Manzana");

        System.out.println("Lista original:");
        System.out.println(frutas);

        Set<String> frutasSinRepetidos = convertirListaASet(frutas);
        System.out.println("Lista sin duplicados:");
        System.out.println(frutasSinRepetidos);
    }
}
