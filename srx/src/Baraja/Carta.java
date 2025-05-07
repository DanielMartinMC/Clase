package Baraja;

public class Carta {

        //Atributos
        private final int numero;
        private final String palo;

        //Constantes
        public static final String[] PALOS={"ESPADAS", "OROS", "COPAS", "BASTOS"};
        public static final int LIMITE_CARTA_PALO=12;

        //Constructor
        public Carta(int numero, String palo) {
            this.numero = numero;
            this.palo = palo;
        }

        @Override
        public String toString() {
            return "numero=" + numero + ", palo=" + palo;
        }

    }

