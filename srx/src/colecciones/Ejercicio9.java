package colecciones;

import java.util.Comparator;
import java.util.PriorityQueue;

public class Ejercicio9 {
    private static void antenderClientes(PriorityQueue<String> clientes) {
        int a = 1;
        while(clientes.peek() != null){
            System.out.println(clientes.poll());
            a++;
        }
    }
    public static void main(String[] args) {
        PriorityQueue<String> clientes = new PriorityQueue<>(new Comparator<String>() {
            @Override
            public int compare(String o1, String o2) {return Integer.compare(o1.length(), o2.length());}
        });
        clientes.add("Daniel");
        clientes.add("Alfredo");
        clientes.add("Manuel");
        clientes.add("Miriam");
        clientes.add("Lucia");

        antenderClientes(clientes);
    }


}
