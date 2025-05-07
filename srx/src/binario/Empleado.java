package binario;
import java.io.DataInput;
import java.io.DataOutput;
import java.io.IOException;

public abstract class Empleado implements Calculable {
    protected int id;
    protected String nombre;
    protected int edad;
    protected double salario;

    public Empleado() {
    }
    public Empleado(int id, String nombre, int edad, double salario) {
        this.id = id;
        this.nombre = nombre;
        this.edad = edad;
        this.salario = salario;
    }

    public int getId() {return id;}
    public void setId(int id) {this.id = id;}

    public String getNombre() {return nombre;}
    public void setNombre(String nombre) {this.nombre = nombre;}

    public int getEdad() {return edad;}
    public void setEdad(int edad) {this.edad = edad;}

    public double getSalario() {return salario;}
    public void setSalario(double salario) {this.salario = salario;}

    public void escribirEnArchivo(DataOutput out) throws IOException {
        out.writeInt(id);
        out.writeUTF(nombre);
        out.writeInt(edad);
        out.writeDouble(salario);
    }

    public void leerDeArchivo(DataInput in) throws IOException {
        id = in.readInt();
        nombre = in.readUTF();
        edad = in.readInt();
        salario = in.readDouble();
    }

    @Override
    public String toString() {
        return "ID: " + id +
                ", Nombre: " + nombre +
                ", Edad: " + edad +
                ", Salario: " + salario;
    }
    public static class EmpleadoAsalariado extends Empleado {
        public EmpleadoAsalariado() {
        }

        public EmpleadoAsalariado(int id, String nombre, int edad, double salario) {
            super(id, nombre, edad, salario);
        }


        @Override
        public void escribirEnArchivo(DataOutput out) throws IOException {
            super.escribirEnArchivo(out);
            out.writeInt(1);
        }

        @Override
        public String toString() {
            return super.toString() + " (Asalariado)";
        }

        @Override
        public double calcular() {
            return 0;
        }
    }
    public static class EmpleadoPorHoras extends Empleado {
        private double horasTrabajadas;
        private double tarifaPorHora;

        public EmpleadoPorHoras(int id, String nombre, int edad, double horasTrabajadas, double tarifaPorHora) {
            super(id, nombre, edad, 0);
            this.horasTrabajadas = horasTrabajadas;
            this.tarifaPorHora = tarifaPorHora;
            this.salario = calcular();
        }


        @Override
        public void escribirEnArchivo(DataOutput out) throws IOException {
            super.escribirEnArchivo(out);
            out.writeInt(2);
        }

        @Override
        public String toString() {
            return super.toString() + " (Por Horas)";
        }

        public double getHorasTrabajadas() {return horasTrabajadas;}

        public void setHorasTrabajadas(double horasTrabajadas) {
            this.horasTrabajadas = horasTrabajadas;
            this.salario = calcular();
        }

        public double getTarifaPorHora() {return tarifaPorHora;}
        public void setTarifaPorHora(double tarifaPorHora) {
            this.tarifaPorHora = tarifaPorHora;this.salario = calcular();
        }

        @Override
        public double calcular() {
            return 0;
        }
    }
}
