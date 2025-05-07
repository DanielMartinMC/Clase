package Interfaces.Bloque1;
import javax.swing.*;
import java.awt.*;

public class Ejercicio1 {
    public static void main(String[] args) {
        JFrame frame = new JFrame("MiVentana");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(400, 300);

        JLabel label = new JLabel("Daniel Martin Calderon");
        frame.getContentPane().add(label);

        JPanel panel = new JPanel();
        panel.setBackground(new Color(220, 220, 220));

        frame.pack();
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);
    }

}
