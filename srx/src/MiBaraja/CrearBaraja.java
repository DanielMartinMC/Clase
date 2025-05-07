package MiBaraja;

public class CrearBaraja {
    public static void main(String[] args) {
        try {
            Baraja baraja = new Baraja();

            System.out.println("Cartas disponibles: " + baraja.cartasDisponibles());

            Carta primeraCarta = baraja.siguienteCarta();
            System.out.println("Primera carta: " + primeraCarta);

            Carta[] mano = baraja.darCartas(5);
            System.out.println("\n Mano de 5 cartas:");
            for (Carta carta : mano) {
                System.out.println(carta);
            }

            System.out.println("\n Cartas disponibles: " + baraja.cartasDisponibles());

            // Mostrar cartas sacadas
            System.out.println("\n Cartas sacadas hasta ahora:");
            Carta[] cartasSacadas = baraja.cartasMonton();
            for (Carta carta : cartasSacadas) {
                System.out.println(carta);
            }

            // Barajar de nuevo
            baraja.barajar();

            // Sacar otras 5 cartas
            Carta[] nuevaMano = baraja.darCartas(5);
            System.out.println("\n Nueva mano después de barajar:");
            for (Carta carta : nuevaMano) {
                System.out.println(carta);
            }

            // Mostrar cartas restantes
            System.out.println("\n Cartas restantes en la baraja:");
            Carta[] cartasRestantes = baraja.mostrarBaraja();
            for (Carta carta : cartasRestantes) {
                System.out.println(carta);
            }

        } catch (Baraja.NoHaySuficientesCartasException | Baraja.NoHayMasCartasException e) {
            System.err.println("Error: " + e.getMessage());
        }
    }
}
