package T9.EjerciciosExpresionesLambda;
//3. Manejo de Hilos con Clase Anónima:

interface Tarea {
    void ejecutar();
}

public class ManejoHilos {
    public static void main(String[] args) {
        Tarea tarea = new Tarea() {
            @Override
            public void ejecutar() {
                System.out.println("Tarea ejecutada en un hilo: " + Thread.currentThread().getName());
            }
        };

        Thread hilo = new Thread(tarea::ejecutar);
        hilo.start();
    }
}
