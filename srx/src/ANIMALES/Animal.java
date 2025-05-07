package ANIMALES;

import java.io.Serializable;

// Clase base Animal (Serializable para poder guardarlo en archivo)
abstract class Animal implements Serializable {
    protected String nombre;
    protected int edad;

    public Animal(String nombre, int edad) {
        this.nombre = nombre;
        this.edad = edad;
    }

    public abstract String getClase(); // Saber si es un Perro o un Gato
    public abstract String hablar(); // Qué sonido hace

    @Override
    public String toString() {
        return getClase() +
                " - Nombre: " + nombre +
                ", Edad: " + edad +
                ", Sonido: " + hablar();
    }
}

// Clase Perro que hereda de Animal
class Perro extends Animal {
    private boolean raboLargo;

    public Perro(String nombre, int edad, boolean raboLargo) {
        super(nombre, edad);
        this.raboLargo = raboLargo;
    }

    @Override
    public String getClase() {
        return "Perro";
    }

    @Override
    public String hablar() {
        return "GUAU";
    }

    @Override
    public String toString() {
        return super.toString() + ", Rabo Largo: " + (raboLargo ? "Sí" : "No");
    }
}

// Clase Gato que hereda de Animal
class Gato extends Animal {
    private static final long serialVersionUID = 1L;
    private boolean bigoteLargo;

    public Gato(String nombre, int edad, boolean bigoteLargo) {
        super(nombre, edad);
        this.bigoteLargo = bigoteLargo;
    }

    @Override
    public String getClase() {
        return "Gato";
    }

    @Override
    public String hablar() {
        return "MIAU";
    }

    @Override
    public String toString() {
        return super.toString() + ", Bigote Largo: " + (bigoteLargo ? "Sí" : "No");
    }
}

