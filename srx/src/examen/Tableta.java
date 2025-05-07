package examen;

import java.util.Arrays;

public class Tableta extends Dispositivo{

    private int[] rendimientosMedios;

    public Tableta(String marca, String modelo, double precio, int garantia, int[] rendimiento) {
        super(marca, modelo, precio, garantia);
        this.rendimientosMedios = rendimiento;
    }

    @Override
    public int obtenerResultados() {
        int rendimientoTotal = 0;
        for (int i = 0; i < rendimientosMedios.length; i++) {
            rendimientoTotal += rendimientosMedios[i];
        }
        rendimientoTotal /= rendimientosMedios.length;
        return rendimientoTotal;
    }

    public int[] getRendimientosMedios() {
        return rendimientosMedios;
    }

    public void setRendimientosMedios(int[] rendimientosMedios) {
        this.rendimientosMedios = rendimientosMedios;
    }

    @Override
    public String toString() {
        return super.toString() + "Tableta{" +
                "rendimientosMedios=" + Arrays.toString(rendimientosMedios) +
                '}';
    }
}
