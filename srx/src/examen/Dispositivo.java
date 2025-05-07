package examen;

public abstract class Dispositivo {

    private String marca, modelo;
    private int garantia;
    private double precio;

    public Dispositivo(String marca, String modelo, double precio, int garantia) {
        this.marca = marca;
        this.modelo = modelo;
        this.precio = precio;
        this.garantia = garantia;
    }

    public abstract int obtenerResultados();


    public String getMarca() {
        return marca;
    }

    public void setMarca(String marca) {
        this.marca = marca;
    }

    public String getModelo() {
        return modelo;
    }

    public void setModelo(String modelo) {
        this.modelo = modelo;
    }

    public double getPrecio() {
        return precio;
    }

    public void setPrecio(int precio) {
        this.precio = precio;
    }

    public int getGarantia() {
        return garantia;
    }

    public void setGarantia(int garantia) {
        this.garantia = garantia;
    }

    @Override
    public String toString() {
        return "Dispositivo{" +
                "marca='" + marca + '\'' +
                ", modelo='" + modelo + '\'' +
                ", garantia=" + garantia +
                ", precio=" + precio +
                '}';
    }
}
