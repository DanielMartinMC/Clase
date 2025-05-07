package examen;

public class Portatil extends Dispositivo{

    private int capacidadAlmacenamiento, almacenamientoUsado;

    public Portatil(String marca, String modelo, double precio, int garantia, int capacidadAlmacenamiento, int almacenamientoUsado) {
        super(marca, modelo, precio, garantia);
        this.capacidadAlmacenamiento = capacidadAlmacenamiento;
        this.almacenamientoUsado = almacenamientoUsado;
    }

    @Override
    public int obtenerResultados() {
        return capacidadAlmacenamiento - almacenamientoUsado;
    }

    public int getCapacidadAlmacenamiento() {
        return capacidadAlmacenamiento;
    }

    public void setCapacidadAlmacenamiento(int capacidadAlmacenamiento) {
        this.capacidadAlmacenamiento = capacidadAlmacenamiento;
    }

    public int getAlmacenamientoUsado() {
        return almacenamientoUsado;
    }

    public void setAlmacenamientoUsado(int almacenamientoUsado) {
        this.almacenamientoUsado = almacenamientoUsado;
    }

    @Override
    public String toString() {
        return super.toString() + "Portatil{" +
                "capacidadAlmacenamiento=" + capacidadAlmacenamiento +
                ", almacenamientoUsado=" + almacenamientoUsado +
                '}';
    }
}
