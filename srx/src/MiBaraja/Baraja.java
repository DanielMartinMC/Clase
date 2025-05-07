package MiBaraja;


import java.util.Collections;
import java.util.Arrays;
import java.util.List;

public class Baraja {
    private final Carta[] cartas;
    private int posSiguienteCarta;
    public static final int num_cartas = 40;

    public Baraja() {
        this.cartas = new Carta[num_cartas];
        this.posSiguienteCarta = 0;
        crearBaraja();
        barajar();
    }

    private void crearBaraja() {
        int index = 0;
        for (String palo : Carta.palos) {
            for (int valor = 1; valor <= Carta.Total_cartas_palo; valor++) {
                if (valor != 8 && valor != 9) {
                    cartas[index++] = new Carta(valor, palo);
                }
            }
        }
    }

    public void barajar() {
        List<Carta> listaCartas = Arrays.asList(cartas);
        Collections.shuffle(listaCartas);
        listaCartas.toArray(cartas);
        posSiguienteCarta = 0;
    }

    public Carta siguienteCarta() throws NoHayMasCartasException {
        if (posSiguienteCarta >= num_cartas) {
            throw new NoHayMasCartasException("No quedan más cartas, barajea de nuevo.");
        }
        return cartas[posSiguienteCarta++];
    }

    public Carta[] darCartas(int numCartas) throws NoHaySuficientesCartasException, NoHayMasCartasException {
        if (numCartas > num_cartas) {
            throw new NoHaySuficientesCartasException("No se pueden dar más cartas");
        }

        if (cartasDisponibles() < numCartas) {
            throw new NoHaySuficientesCartasException("No hay suficientes cartas disponibles.");
        }

        Carta[] cartasParaDar = new Carta[numCartas];
        for (int i = 0; i < numCartas; i++) {
            cartasParaDar[i] = siguienteCarta();
        }
        return cartasParaDar;
    }

    public int cartasDisponibles() {
        return num_cartas - posSiguienteCarta;
    }

    public Carta[] cartasMonton() {
        if (posSiguienteCarta == 0) {
            return new Carta[0];
        }
        return Arrays.copyOfRange(cartas, 0, posSiguienteCarta);
    }

    public Carta[] mostrarBaraja() {
        if (posSiguienteCarta >= num_cartas) {
            return new Carta[0];
        }
        return Arrays.copyOfRange(cartas, posSiguienteCarta, num_cartas);
    }

    public static class NoHayMasCartasException extends Exception {
        public NoHayMasCartasException(String mensaje) {
            super(mensaje);
        }
    }

    public static class NoHaySuficientesCartasException extends Exception {
        public NoHaySuficientesCartasException(String mensaje) {
            super(mensaje);
        }
    }
}