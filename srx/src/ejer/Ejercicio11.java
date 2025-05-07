package ejer;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

class persona{
    String nombre;
    int edad;
    persona(String nombre, int edad){
        this.nombre = nombre;
        this.edad = edad;
    }

    public int getEdad() {return edad;}

    @Override
    public String toString() {
        return "Nombre: " +  nombre ;
    }
}
public class Ejercicio11 {
    public static void main(String[] args) {
        List<persona> personas = new ArrayList<>();
        personas.add(new persona("Daniel", 17));
        personas.add(new persona("Jose Miguel", 51));
        personas.add(new persona("Miriam", 33));
        personas.add(new persona("Sonia", 52));

        personas.sort(Comparator.comparingInt(persona::getEdad).reversed());

        personas.removeIf(p -> p.edad < 18);

        System.out.println("Personas no eliminadas" + personas);
    }
}
