import binario.Empleado;

import java.util.ArrayList;
import java.util.List;

public class EquipoTrabajo {
    private String nombre;
    private Empleado lider;
    private List<Empleado> miembros;

    public EquipoTrabajo(String nombre) {
        this.nombre = nombre;
        this.miembros = new ArrayList<>();
    }
    // Añade si no existe ya un empleado con el mismo DNI.
    public void agregarEmpleado(Empleado e) {
        boolean existe = false;
        for (Empleado emp : miembros) {
            if (emp.getDni().equals(e.getDni())) {
                existe = true;
                break;
            }
        }
        if (!existe) {
            miembros.add(e);
        }
    }

    // Elimina por DNI exacto.
    public void eliminarEmpleado(String dni) {
        miembros.removeIf(emp -> emp.getDni().equals(dni));
        if (lider != null && lider.getDni().equals(dni)) {
            lider = null;
        }
    }

    // Lista de empleados.
    public List<Empleado> listarMiembros() {
        return new ArrayList<>(miembros); /
    }

    // Asigna si el empleado pertenece al equipo.
    public void asignarLider(Empleado e) {
        if (miembros.contains(e)) {
            this.lider = e;
        } else {
            throw new IllegalArgumentException("El empleado no pertenece al equipo");
        }
    }

    // Selecciona alfabéticamente entre los activos.
    public void asignarLiderAutomaticamente() {
        miembros.stream()
                .filter(Empleado::isActivo)
                .sorted((e1, e2) -> e1.getNombre().compareToIgnoreCase(e2.getNombre()))
                .findFirst()
                .ifPresent(emp -> this.lider = emp);
    }

    // Recorre la lista y cuenta coincidencias.
    public int contarMiembrosPorRol(String rol) {
        return (int) miembros.stream()
                .filter(emp -> emp.getRol().equalsIgnoreCase(rol))
                .count();
    }

    // Calcula el porcentaje de activos sobre total.
    public double porcentajeActivos() {
        if (miembros.isEmpty()) return 0.0;

        long activos = miembros.stream()
                .filter(Empleado::isActivo)
                .count();

        return (activos * 100.0) / miembros.size();
    }

    //Devuelve resumen de nombre del equipo, líder y lista de miembros con rol y estado.
    public String obtenerResumenEquipo() {
        StringBuilder resumen = new StringBuilder();
        resumen.append("Equipo: ").append(nombre).append("\n");
        resumen.append("Líder: ");
        resumen.append(lider != null && miembros.contains(lider) ? lider.getNombre() : "No asignado")
        resumen.append("Miembros (").append(miembros.size()).append("):\n");

        for (Empleado emp : miembros) {
            resumen.append("- ").append(emp.getNombre())
                    .append(" (").append(emp.getRol())
                    .append(") - ").append(emp.isActivo() ? "Activo" : "Inactivo")
                    .append("\n");
        }

        return resumen.toString();
    }


    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public Empleado getLider() {
        return lider;
    }
}