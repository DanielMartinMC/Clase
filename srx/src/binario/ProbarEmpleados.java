package binario;
import java.io.IOException;


public class ProbarEmpleados {
    public static void main(String[] args) {
        GestionEmpleados gestion = new GestionEmpleados("no.txt");

        try {
            Empleado.EmpleadoAsalariado emp1 = new Empleado.EmpleadoAsalariado(5, "Daniel Martin", 20, 2500.0);
            Empleado.EmpleadoAsalariado emp2 = new Empleado.EmpleadoAsalariado(7, "Pedro Gonzalez", 21, 3000.0);
            Empleado.EmpleadoPorHoras emp3 = new Empleado.EmpleadoPorHoras(10, "Sonia Calderon", 52, 160, 15.0);
            Empleado.EmpleadoPorHoras emp4 = new Empleado.EmpleadoPorHoras(23, "Miriam Bonilla", 34, 120, 18.5);

            gestion.agregarEmpleado(emp1);
            gestion.agregarEmpleado(emp2);
            gestion.agregarEmpleado(emp3);
            gestion.agregarEmpleado(emp4);

            System.out.println("Empleados después de agregar:");
            gestion.listarEmpleados();

            System.out.println("\nModificando salario del empleado");
            gestion.modificarSalario(5, 2800.0);

            System.out.println("\nDespues de modificar salario del empleado");
            gestion.listarEmpleados();

            System.out.println("\nLeyendo datos empleado");
            Empleado emp = gestion.leerEmpleado(5);
            if (emp != null) {
                System.out.println(emp);
            } else {
                System.out.println("Empleado no encontrado");
            }

        } catch (IOException e) {
            System.err.println("Error al manejar el archivo: " + e.getMessage());
        }
    }

}
