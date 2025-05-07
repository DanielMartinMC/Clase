package colecciones;

import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

public class Ejercicio10 {

    public static void eliminarCiudadesConM(Set<String> ciudades) {
        Iterator<String> ciu = ciudades.iterator();
        while (ciu.hasNext()) {
            String ciudad = ciu.next();
            if (ciudad.startsWith("M")) {
                ciu.remove();
            }
        }
    }

    public static void main(String[] args) {
        Set<String> ciudades = new HashSet<>();
        ciudades.add("Madrid");
        ciudades.add("Barcelona");
        ciudades.add("Marbella");
        ciudades.add("Sevilla");

        eliminarCiudadesConM(ciudades);
        System.out.println("Ciudades restantes: " + ciudades);
    }
}

