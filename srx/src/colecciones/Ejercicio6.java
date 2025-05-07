package colecciones;

import java.util.*;

public class Ejercicio6 {
    private HashMap<String, List<Integer>> notas = new HashMap<>();

    public void agregarNota(String alumno, int nota) {
        notas.computeIfAbsent(alumno, k -> new ArrayList<>()).add(nota);
    }

    public void mostrarNotas(String alumno) {
        notas.getOrDefault(alumno, Collections.emptyList()).forEach(System.out::println);
    }

    public double mediaNotas(String alumno) {
        return notas.get(alumno).stream().mapToInt(Integer::intValue).average().orElse(0);
    }

    public String mejorNota() {
        return notas.entrySet().stream()
                .max(Comparator.comparingDouble(e -> e.getValue().stream().mapToInt(Integer::intValue).average().orElse(0)))
                .map(Map.Entry::getKey)
                .orElse("No hay alumnos");
    }
    public static void main(String[] args) {
        Ejercicio6 registro = new Ejercicio6();
        registro.agregarNota("Daniel", 5);
        registro.agregarNota("Daniel", 7);
        registro.agregarNota("Daniel", 8);

        registro.agregarNota("Joel", 6);
        registro.agregarNota("Joel", 6);
        registro.agregarNota("Joel", 9);

        registro.agregarNota("Miguel", 6);
        registro.agregarNota("Miguel", 7);
        registro.agregarNota("Miguel", 9);

        System.out.println("Notas de Daniel -->");
        registro.mostrarNotas("Daniel");
        System.out.println("La media de la nota es: " + registro.mediaNotas("Daniel"));


        System.out.println("Notas de Joel -->");
        registro.mostrarNotas("Joel");
        System.out.println("La media de la nota es: " + registro.mediaNotas("Joel"));

        System.out.println("Notas de Miguel -->");
        registro.mostrarNotas("Miguel");
        System.out.println("La media de la nota es: " + registro.mediaNotas("Miguel"));

        System.out.println("Alumno con mejor nota: " + registro.mejorNota());
    }
}