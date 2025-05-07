package examen;

import java.util.Arrays;

public class Movil extends Dispositivo{

    private int[] consumosMedios;

    private int bateriaTotal;

    private final int BATERIA_TOTAL = 5000;

    public Movil(String marca, String modelo, double precio, int garantia, int[] consumosMedios) {
        super(marca, modelo, precio, garantia);
        this.consumosMedios = consumosMedios;
        this.bateriaTotal = BATERIA_TOTAL;
    }

    @Override
    public int obtenerResultados() {
        int consumosTotal = 0;
        for (int i = 0; i < consumosMedios.length; i++) {
            consumosTotal += consumosMedios[i];
        }
        consumosTotal /= consumosMedios.length;
        return consumosTotal;
    }


    public int getBateriaTotal() {
        return bateriaTotal;
    }

    public void setBateriaTotal(int bateriaTotal) {
        this.bateriaTotal = bateriaTotal;
    }

    public int getBATERIA_TOTAL() {
        return BATERIA_TOTAL;
    }

    public int[] getConsumosMedios() {
        return consumosMedios;
    }

    public void setConsumosMedios(int[] consumosMedios) {
        this.consumosMedios = consumosMedios;
    }

    @Override
    public String toString() {
        return super.toString() + "Movil{" +
                "consumosMedios=" + Arrays.toString(consumosMedios) +
                ", bateriaTotal=" + bateriaTotal +
                '}';
    }

}
