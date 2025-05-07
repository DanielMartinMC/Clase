package MiBaraja;

public class Carta {
    private final int numero;
    private final String palo;

    public static final String[] palos={"Espadas", "Oros", "Bastos", "Copas"};
    public static final int Total_cartas_palo = 12;

    public Carta(int numero, String palo) {
        this.numero = numero;
        this.palo = palo;
    }
    @Override
    public String toString() {
        return "numero=" + numero + ", palo=" + palo;
    }
}
