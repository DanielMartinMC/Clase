package ANIMALES;

public class ProbarAnimales {
    public static void main(String[] args) {
        GestionarAnimales gestor = new GestionarAnimales();

        // Añadir perros y gatos
        gestor.addPerro(new Perro("Rex", 5, true));
        gestor.addPerro(new Perro("Bobby", 3, false));
        gestor.addGato(new Gato("Michi", 4, true));
        gestor.addGato(new Gato("Tom", 2, false));

        // Mostrar animales antes de guardar
        System.out.println("Animales antes de guardar:");
        gestor.mostrarAnimales();

        // Guardar en archivo
        String fichero = "animales.dat";
        gestor.WriteAnimalsDisk(fichero);

        // Leer desde archivo
        GestionarAnimales gestorNuevo = new GestionarAnimales();
        gestorNuevo.ReadAnimalsDisk(fichero);

        // Mostrar animales después de cargar
        System.out.println("\nAnimales después de cargar:");
        gestorNuevo.mostrarAnimales();
    }
}
