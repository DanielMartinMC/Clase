package ejer;

public class Ejercicio3 {
    interface OperacionFactorial {
        long calculate(int n);
    }
    public static void main(String[] args) {
        OperacionFactorial fac = n -> {
            long a = 1;
            for (int i = 2; i <= n; i++) {
                a *= i;
            }
            return a;
        };

        System.out.println("5! = " + fac.calculate(5));
        System.out.println("7! = " + fac.calculate(7));
        System.out.println("10! = " + fac.calculate(10));
    }


}
