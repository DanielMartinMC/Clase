package Interfaces.Bloque3;

import javax.swing.*;
import java.awt.*;

public class Ejercicio11 extends JFrame {
   public static void main(String[] args) {
       JFrame frame = new JFrame("Tablero con GridLayout");
       frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
       frame.setSize(400, 400);
       frame.setLocationRelativeTo(null);

       JPanel panel = new JPanel(new GridLayout(3, 3));

       for (int i = 1; i <= 9; i++) {
           JButton boton = new JButton(String.valueOf(i));
           panel.add(boton);
       }
       frame.add(panel, BorderLayout.SOUTH);
       frame.setVisible(true);
   }
}
