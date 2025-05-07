package ANIMALES;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

class GestionarAnimales {
    private List<Perro> perros;
    private List<Gato> gatos;
    private static final int MAX_ANIMALES = 5;

    public GestionarAnimales() {
        this.perros = new ArrayList<>();
        this.gatos = new ArrayList<>();
    }

    public boolean addPerro(Perro perro) {
        if (perros.size() < MAX_ANIMALES) {
            perros.add(perro);
            return true;
        }
        return false;
    }

    public boolean addGato(Gato gato) {
        if (gatos.size() < MAX_ANIMALES) {
            gatos.add(gato);
            return true;
        }
        return false;
    }

    public void WriteAnimalsDisk(String fichero) {
        try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(fichero))) {
            int totalAnimales = perros.size() + gatos.size();
            oos.writeInt(totalAnimales);

            for (Perro p : perros) oos.writeObject(p);
            for (Gato g : gatos) oos.writeObject(g);

            System.out.println("Animales guardados en el archivo: " + fichero);
        } catch (IOException e) {
            System.err.println("Error al guardar los animales: " + e.getMessage());
        }
    }

    public void ReadAnimalsDisk(String fichero) {
        try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream(fichero))) {
            int totalAnimales = ois.readInt();
            perros.clear();
            gatos.clear();

            for (int i = 0; i < totalAnimales; i++) {
                Animal animal = (Animal) ois.readObject();
                if (animal instanceof Perro) perros.add((Perro) animal);
                else if (animal instanceof Gato) gatos.add((Gato) animal);
            }
            System.out.println("Animales cargados desde el archivo: " + fichero);
        } catch (IOException | ClassNotFoundException e) {
            System.err.println("Error al leer los animales: " + e.getMessage());
        }
    }

    public void mostrarAnimales() {
        System.out.println("\nPerros:");
        for (Perro p : perros) System.out.println(p);
        System.out.println("\nGatos:");
        for (Gato g : gatos) System.out.println(g);
    }
}
