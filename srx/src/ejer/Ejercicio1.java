package ejer;

public class Ejercicio1 {
    interface Op {
        double calcular(double a, double b);
    }
    public static void main(String[] args) {
        Op potencia = new Op() {
            @Override
            public double calcular(double a, double b) {
                return Math.pow(a, b);
            }
        };
        
        Op modulo = new Op() {
            @Override
            public double calcular(double a, double b) {
                return a % b;
            }
        };

        
        Op maximo = new Op() {
            @Override
            public double calcular(double a, double b) {
                return Math.max(a, b);
            }
        };

        // Pruebas
        System.out.println("La potencia de 8^3: " + potencia.calcular(8, 3));
        System.out.println("El modulo de 4%3: " + modulo.calcular(4, 3));
        System.out.println("El maximo de 7,12: " + maximo.calcular(7, 12));
    }


}
