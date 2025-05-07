package binario;

import java.io.IOException;
import java.io.RandomAccessFile;
import java.nio.charset.StandardCharsets;

public class GestionEmpleados {
    private static final int TamañoRegistro = 40;
    private String archivo;

    public GestionEmpleados(String archivo) {
        this.archivo = archivo;
    }

    public void agregarEmpleado(Empleado e) throws IOException {
        try (RandomAccessFile raf = new RandomAccessFile(archivo, "rw")) {
            long posicion = e.getId() * TamañoRegistro;
            raf.seek(posicion);

            raf.writeInt(e.getId());

            String nombre = e.getNombre();
            if (nombre.length() > 20) {
                nombre = nombre.substring(0, 20);
            }
            raf.writeUTF(nombre);
            for (int i = nombre.length(); i < 20; i++) {
                raf.writeByte(0);
            }

            raf.writeInt(e.getEdad());
            raf.writeDouble(e.getSalario());
            raf.writeInt(e instanceof Empleado.EmpleadoAsalariado ? 1 : 2);

            System.out.println("Empleado ID " + e.getId() + " guardado en posición " + posicion);
        }
    }

    public Empleado leerEmpleado(int id) throws IOException {
        try (RandomAccessFile raf = new RandomAccessFile(archivo, "rw")) {
            long posicion = id * TamañoRegistro;

            if (posicion >= raf.length()) {return null;}

            raf.seek(posicion);
            int idLeido = raf.readInt();
            if (idLeido == 0) {return null;}

            byte[] nombreBytes = new byte[20];
            raf.readFully(nombreBytes);
            String nombre = new String(nombreBytes, StandardCharsets.UTF_8).trim();


            int edad = raf.readInt();
            double salario = raf.readDouble();
            int tipo = raf.readInt();

            Empleado empleado;
            if (tipo == 1) {
                empleado = new Empleado.EmpleadoAsalariado(idLeido, nombre, edad, salario);
            } else if (tipo == 2) {
                empleado = new Empleado.EmpleadoPorHoras(idLeido, nombre, edad, 0, 0);
                empleado.setSalario(salario);
            } else {
                return null;
            }

            return empleado;
        }
    }

    public void modificarSalario(int id, double nuevoSalario) throws IOException {
        try (RandomAccessFile raf = new RandomAccessFile(archivo, "rw")) {
            long posicionRegistro = id * TamañoRegistro;

            if (posicionRegistro >= raf.length()) {
                System.err.println("El empleado con ID " + id + " no existe.");
                return;
            }

            long posicionSalario = posicionRegistro + 28;
            raf.seek(posicionSalario);

            raf.seek(posicionRegistro + 36);
            int tipoEmpleado = raf.readInt();

            if (tipoEmpleado == 2) {
                System.out.println("Advertencia: Estás modificando directamente el salario de un empleado por horas.");
                System.out.println("El cálculo:");
            }

            raf.seek(posicionSalario);
            raf.writeDouble(nuevoSalario);

            System.out.println("Salario empleado ID: " + id + " actualizado a: " + nuevoSalario);
        }
    }

    public void listarEmpleados() throws IOException {
        try (RandomAccessFile raf = new RandomAccessFile(archivo, "rw")) {
            System.out.println("\n Lista de empleados:");

            long numRegistros = raf.length() / TamañoRegistro;
            System.out.println("Registros: " + numRegistros);

            for (int i = 0; i < numRegistros; i++) {
                Empleado emp = leerEmpleado(i);
                if (emp != null) {
                    System.out.println(emp);
                } else {
                    System.out.println("Lectura.Registro " + i + ": Vacío");
                }  
            }
        }
    }
}
